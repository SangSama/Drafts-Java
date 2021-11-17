package com.news.orm.imlp;

import com.mysql.cj.util.StringUtils;
import com.news.exception.OrmException;
import com.news.orm.JpaRepository;
import com.news.orm.annotation.Id;
import com.news.orm.paging.Page;
import com.news.orm.paging.PageAble;
import com.news.orm.pool.ConnectionPool;

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

import static com.news.utils.AnnotationUtil.*;
import static com.news.utils.ReflectionUtil.get;
import static com.news.utils.ReflectionUtil.mapToEntity;

public class BaseRepository<T, ID extends Serializable> implements JpaRepository<T, ID> {

    private final Class<T> tClass;
    private final String tableName;
    private String insert;
    private String update;
    private String select;

    public BaseRepository() {
        this.tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.tableName = getClassName(tClass);
        // insert into student(%s) VALUES(%s) => %s : dùng StringFormat add vào
        this.insert = "INSERT INTO " + tableName + "(%s) VALUES (%S)";
        // update student set user_name where id = ?; <<== giả sử
        this.update = "UPDATE " + tableName + " SET %s WHERE %s";
        this.select = "SELECT * FROM " + tableName;
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
        return null;
    }

    @Override
    public List<T> findAll() {
        try (Connection connection = ConnectionPool.of().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(this.select);
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

    @Override
    public long count() {
        return 0;
    }
}
