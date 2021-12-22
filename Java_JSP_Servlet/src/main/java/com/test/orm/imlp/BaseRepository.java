package com.test.orm.imlp;

import com.mysql.cj.util.StringUtils;
import com.test.exception.OrmException;
import com.test.orm.JpaRepository;
import com.test.orm.annotation.Id;
import com.test.orm.paging.Page;
import com.test.orm.paging.PageAble;
import com.test.orm.paging.impl.PageImpl;
import com.test.orm.pool.ConnectionPool;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static com.test.utils.AnnotationUtil.*;
import static com.test.utils.ReflectionUtil.get;
import static com.test.utils.ReflectionUtil.mapToEntity;

public class BaseRepository<T, ID extends Serializable> implements JpaRepository<T, ID> {

    private final Class<T> tClass;
    private final String tableName;
    private String insert;
    private String update;
    private String select;
    private String count;
    private String delete;

    public BaseRepository() {
        this.tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.tableName = getClassName(tClass);
        // insert into student(%s) VALUES(%s) => %s : dùng StringFormat add vào
        this.insert = "INSERT INTO " + tableName + "(%s) VALUES (%S)";
        // update student set user_name where id = ?; <<== giả sử
        this.update = "UPDATE " + tableName + " SET %s WHERE %s";
        this.select = "SELECT * FROM " + tableName;
        this.count = "SELECT COUNT(1) AS total FROM " + tableName;
        this.delete = "DELETE FROM " + tableName + " WHERE ";
    }

    @Override
    public void save(final T t) {
        Field[] fields = tClass.getDeclaredFields();
        final StringBuilder columns = new StringBuilder();
        final StringBuilder values = new StringBuilder();
        Map<String, Integer> map = new HashMap<>(); // key => tên field , value = vị trí của field trong database
        // tìm hiểu cách java tương tác db qua jdbc
        AtomicInteger index = new AtomicInteger(1);
        Arrays.stream(fields).forEach(field -> {
            if (field.isAnnotationPresent(Id.class)) {
                boolean isAutoIncrement = isAutoIncrement(tClass, field.getName());
                // nếu isAutoIncrement không tự động tăng <=> isAutoIncrement = false <=> !isAutoIncrement
                if (!isAutoIncrement) {
                    String primaryName = primaryColumn(tClass, field.getName());
                    columns.append(primaryName).append(",");
                    values.append("?,");
                    map.put(field.getName(), index.getAndIncrement());
                }
            } else {
                String columnName = getColumnName(tClass, field.getName());
                columns.append(columnName).append(",");
                values.append("?,");
                map.put(field.getName(), index.getAndIncrement());
            }
        });

        String column = columns.deleteCharAt(columns.length()-1).toString();
        String value = values.deleteCharAt(values.length()-1).toString();
        insert = String.format(insert, column, value);

        // Connection connection = ConnectionPool.of().getConnection()
        // => Try catch của java7 - try catch resource : tự động mở, tự động đóng connection này
        Connection connection = null;
        try {
            // dùng setAutoCommit => để đảm bảo được Transaction => tính toàn vẹn dữ liệu
            // Trong 1 hàm: n câu query thực hiện cùng 1 lúc
            // => 1 câu query false => rollback toàn bộ các câu query còn lại, kể cả đã thành công
            // VD: bản ghi đang có 10
            // => insert thành công 3 => hiện bản ghi có 13
            // => đến 4 bị false => rollback lại 3 bản vừa thành công => bản ghi có 10
            connection.setAutoCommit(false);
            connection = ConnectionPool.of().getConnection();
            final PreparedStatement ps = connection.prepareStatement(insert);
            Arrays.stream(fields).forEach(field -> {
                if (field.isAnnotationPresent(Id.class)) {
                    boolean isAutoIncrement = isAutoIncrement(tClass, field.getName());
                    // nếu isAutoIncrement không tự động tăng <=> isAutoIncrement = false <=> !isAutoIncrement
                    if (!isAutoIncrement) {
                        try {
                            ps.setObject(map.get(field.getName()), get(t, field));
                        } catch (SQLException e) {
                            throw new OrmException(e.getMessage());
                        }
                    }
                } else {
                    try {
                        ps.setObject(map.get(field.getName()), get(t, field));
                    } catch (SQLException e) {
                        throw new OrmException(e.getMessage());
                    }
                }
            });
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException exception) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            throw new OrmException(exception.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new OrmException(e.getMessage());
                }
            }
        }
    }

    @Override
    public void update(ID id, T t) {
        // UPDATE student SET name = ?, age = ?, ... WHERE id = ?
        StringBuilder set = new StringBuilder();
        StringBuilder condition = new StringBuilder();
        Field[] fields = tClass.getDeclaredFields();
        Map<String, Integer> map = new HashMap<>();     // lưu lại vị trí ? => student(name)  value(?)
        AtomicInteger index = new AtomicInteger(1);     // Cơ chế của Atomic
//        final String name; => thread save => dùng khi biến không thay đổi trên các khối lệch khác nhau, các thread khác nhau
//      // => 2 name không hiểu nhau được vì bản chất năm trên 2 stack khác nhau => 2 thread khác nhau
        // => không tham chiếu đến nhau được
        // => Vừa muốn thay đổi vừa muốn sử dụng trên 2 thread => dùng AtomicReference
        AtomicReference<String> primary = new AtomicReference<>();
        // stream chạy trên 1 luồng khác
        // cần tìm hiểu về terminal và non-terminal
        Arrays.stream(fields).forEach(field -> {
            // Nếu khác id => fieldName = ?, fieldName = ?
            if (!field.isAnnotationPresent(Id.class)) {
                String columnName = getColumnName(tClass, field.getName());
                if (StringUtils.isNullOrEmpty(columnName)) {
                    throw new OrmException("primaryName is null");
                }
                set.append(columnName).append(" = ?,");
                map.put(field.getName(), index.getAndIncrement());
            // Nếu id => id = ?
            } else {
                String primaryName = primaryColumn(tClass, field.getName());
                if (StringUtils.isNullOrEmpty(primaryName)) {
                    throw new OrmException("primaryName is null");
                }
                condition.append(primaryName).append(" = ?");
//                name = field.getName(); => 2 name không hiểu nhau được vì bản chất năm trên 2 stack khác nhau
                primary.set(field.getName());
            }
        });

        map.put(primary.get(), index.get());
        set.deleteCharAt(set.length() - 1);
        this.update = String.format(this.update, set, condition);
        Connection connection = null;
        try {
            connection.setAutoCommit(false);
            /*
            * Tại sao dùng .of() ?
            * => muốn sử dụng tính static nhưng không muốn bên ngoài khởi tạo quá bừa bãi
            * => dùng .of() để quy định đúng cái Object
            * */
            connection = ConnectionPool.of().getConnection();
            final PreparedStatement ps = connection.prepareStatement(this.update);
            Arrays.stream(fields).forEach(field -> {
                try {
                    ps.setObject(map.get(field.getName()), get(t, field));
                } catch (SQLException e) {
                    throw new OrmException(e.getMessage());
                }
            });
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException exception) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            throw new OrmException(exception.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new OrmException(e.getMessage());
                }
            }
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        Optional<Field> field = Arrays
                .stream(tClass.getDeclaredFields())
                .filter(field1 -> field1.isAnnotationPresent(Id.class))
                .findFirst();

        if (!field.isPresent()) {
            return Optional.empty();
        }

        this.select = this.select + " WHERE " + primaryColumn(tClass, field.get().getName()) + " = ?";

        try (Connection connection = ConnectionPool.of().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(this.select);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(mapToEntity(rs, tClass));
            }
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException exception) {
            throw new OrmException(exception.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public T getOne(ID id) {
        Optional<Field> field = Arrays
                .stream(tClass.getDeclaredFields())
                .filter(field1 -> field1.isAnnotationPresent(Id.class))
                .findFirst();

        if (!field.isPresent()) {
            return null;
        }

        this.select = this.select + " WHERE " + primaryColumn(tClass, field.get().getName()) + " = ?";

        try (Connection connection = ConnectionPool.of().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(this.select);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapToEntity(rs, tClass);
            }
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException exception) {
            throw new OrmException(exception.getMessage());
        }

        return null;
    }

    @Override
    public Page<T> findAll(PageAble pageAble) {
        String selectLimit;

        if (pageAble == null) {
            selectLimit = this.select;
        } else {
            selectLimit = this.select + " limit ? offset ?";
        }

        List<T> data = getAll(selectLimit, pageAble);
        long totalItem = count();

        return PageImpl.of(pageAble.getPage(), pageAble.getSize(), totalItem, data);
    }

    @Override
    public List<T> findAll() {
        return getAll(this.select, null);
    }

    @Override
    public long count() {
        try (Connection connection = ConnectionPool.of().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(this.count);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getLong("total");
            }

            return 0;
        } catch (SQLException exception) {
            throw new OrmException(exception.getMessage());
        }
    }

    @Override
    public boolean delete(ID id) {
        Field[] fields = tClass.getDeclaredFields();
        Optional<Field> fieldId = Arrays.stream(fields).filter(field -> field.isAnnotationPresent(Id.class)).findFirst();
        // Kiểm tra xem fieldId có null không?
        // Nếu khác null
        if (fieldId.isPresent()) {
            String column = primaryColumn(tClass, fieldId.get().getName()); // lấy tên cột khóa chính
            this.delete = this.delete + " WHERE " + column + " = ?";
            Connection connection = null;
            try {
                connection.setAutoCommit(false);
                connection = ConnectionPool.of().getConnection();
                PreparedStatement ps = connection.prepareStatement(this.delete);
                ps.setObject(1, id);
                ps.executeUpdate();
                connection.commit();

                return true;
            } catch (SQLException e) {
                try {
                    if (connection != null) {
                        connection.rollback();
                    }
                } catch (SQLException ex) {
                    throw new OrmException((e.getMessage()));
                }
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        throw new OrmException(e.getMessage());
                    }
                }
            }
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteAll(List<ID> ids) {
        // DELETE FROM user WHERE in in(?,?,?)
        String listString = ids.stream().map(Objects::toString).collect(Collectors.joining(","));

        Field[] fields = tClass.getDeclaredFields();
        Optional<Field> fieldId = Arrays.stream(fields).filter(field -> field.isAnnotationPresent(Id.class)).findFirst();
        // Kiểm tra xem fieldId có null không?
        // Nếu khác null
        if (fieldId.isPresent()) {
            String column = primaryColumn(tClass, fieldId.get().getName()); // lấy tên cột khóa chính
            this.delete = this.delete + " WHERE " + column + " IN (" + listString +  ")";
            Connection connection = null;
            try {
                connection.setAutoCommit(false);
                connection = ConnectionPool.of().getConnection();
                PreparedStatement ps = connection.prepareStatement(this.delete);
                int index = 1;
                for (ID id : ids) {
                    ps.setObject(++index, id);
                }
                ps.executeUpdate();
                connection.commit();

                return true;
            } catch (SQLException e) {
                try {
                    if (connection != null) {
                        connection.rollback();
                    }
                } catch (SQLException ex) {
                    throw new OrmException((e.getMessage()));
                }
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        throw new OrmException(e.getMessage());
                    }
                }
            }
            return true;
        }

        return false;
    }

    /*
    * Bình thường sẽ có 2 câu query:
    *   Câu số 1: SELECT * FROM user
    *       => lấy All nhưng không phân trang
    *   Câu số 2: SELECT * FROM user limit 10 offset 0
    *       => lấy All nhưng phân trang, lấy 10 phần tử từ vị trí 0
    *
    * PageAble = null   --> xảy ra câu số 1
    * PageAble != null  --> xảy ra câu số 2
    * */
    private List<T> getAll(String sql, PageAble pageAble) {
        try (Connection connection = ConnectionPool.of().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            // SELECT * FROM user limit ? offset ?
            if (pageAble == null) {
                ps.setInt(1, pageAble.getSize());
                ps.setInt(2, pageAble.getOffset());
            }

            ResultSet rs = ps.executeQuery();
            List<T> ts = new ArrayList<>();
            while (rs.next()) {
                T t = mapToEntity(rs, tClass);
                ts.add(t);
            }

            return ts;
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException exception) {
            throw new OrmException(exception.getMessage());
        }
    }
}
