package com.news.orm.impl;

import com.mysql.cj.util.StringUtils;
import com.news.exception.OrmException;
import com.news.orm.JpaRepository;
import com.news.orm.Query;
import com.news.orm.annotation.Id;
import com.news.orm.paging.Page;
import com.news.orm.paging.PageAble;
import com.news.orm.paging.impl.PageImpl;
import com.news.orm.pool.ConnectionPool;
import com.news.utils.StringUtil;

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
import java.util.stream.Stream;

import static com.news.utils.AnnotationUtil.*;
import static com.news.utils.ReflectionUtil.get;
import static com.news.utils.ReflectionUtil.mapToEntity;

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
        this.insert = "INSERT INTO " + tableName + "(%s) VALUES (%s)";
        this.update = "UPDATE " + tableName + " SET %s WHERE %s";
        this.select = "SELECT * FROM " + tableName;
        this.count = "SELECT COUNT(1) AS total FROM " + tableName;
        this.delete = "DELETE FROM " + tableName;
    }

    @Override
    public void save(final T t) {
        Field[] fields = tClass.getDeclaredFields();
        final StringBuilder columns = new StringBuilder();
        final StringBuilder values = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        AtomicInteger index = new AtomicInteger(1);
        Arrays.stream(fields).forEach(field -> {
            if (field.isAnnotationPresent(Id.class)) {
                boolean isAutoIncrement = isAutoIncrement(tClass, field.getName());
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
        String column = columns.deleteCharAt(columns.length() - 1).toString();
        String value = values.deleteCharAt(values.length() - 1).toString();
        insert = String.format(insert, column, value);
        Connection connection = null;
        try {
            connection.setAutoCommit(false);
            connection = ConnectionPool.of().getConnection();
            final PreparedStatement ps = connection.prepareStatement(insert);
            Arrays.stream(fields).forEach(field -> {
                if (field.isAnnotationPresent(Id.class)) {
                    boolean isAutoIncrement = isAutoIncrement(tClass, field.getName());
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
        StringBuilder set = new StringBuilder();
        StringBuilder condition = new StringBuilder();
        Field[] fields = tClass.getDeclaredFields();
        Map<String, Integer> map = new HashMap<>();
        AtomicInteger index = new AtomicInteger(1);
        AtomicReference<String> primary = new AtomicReference<>();
        Arrays.stream(fields).forEach(field -> {
            if (!field.isAnnotationPresent(Id.class)) {
                String columnName = getColumnName(tClass, field.getName());
                if (StringUtils.isNullOrEmpty(columnName)) {
                    throw new OrmException("primaryName is null");
                }
                set.append(columnName).append(" = ?,");
                map.put(field.getName(), index.getAndIncrement());
            } else {
                String primaryName = primaryColumn(tClass, field.getName());
                if (StringUtils.isNullOrEmpty(primaryName)) {
                    throw new OrmException("primaryName is null");
                }
                condition.append(primaryName).append(" = ?");
                primary.set(field.getName());
            }
        });
        map.put(primary.get(), index.get());
        set.deleteCharAt(set.length() - 1);
        this.update = String.format(this.update, set, condition);
        Connection connection = null;
        try {
            connection.setAutoCommit(false);
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
            selectLimit = this.select + " limit ? Offset ?";
        }

        List<T> data = getAll(selectLimit, pageAble);
        long totalItem = count();
        int page = pageAble == null ? 0 : pageAble.getPage();
        int size = pageAble == null ? 0 : pageAble.getSize();
        return PageImpl.of(page, size, totalItem, data);
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
        if (fieldId.isPresent()) {
            String column = primaryColumn(tClass, fieldId.get().getName());
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
                    throw new OrmException(e.getMessage());
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
        String listString = ids.stream().map(Object::toString)
                .collect(Collectors.joining(","));
        Field[] fields = tClass.getDeclaredFields();
        Optional<Field> fieldId = Arrays.stream(fields).filter(field -> field.isAnnotationPresent(Id.class)).findFirst();
        if (fieldId.isPresent()) {
            String column = primaryColumn(tClass, fieldId.get().getName());
            this.delete = this.delete + " WHERE " + column + " IN (" + listString + ")";
            Connection connection = null;
            try {
                connection.setAutoCommit(false);
                connection = ConnectionPool.of().getConnection();
                PreparedStatement ps = connection.prepareStatement(this.delete);
                int index = 0;
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
                    throw new OrmException(e.getMessage());
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

    private List<T> getAll(String sql, PageAble pageAble) {
        try (Connection connection = ConnectionPool.of().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            if (pageAble != null) {
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

    @Override
    public Optional<T> find(Query<T> query) {
        var sqlBuilder = new StringBuilder(this.select);
        if (StringUtil.notEmpty(query.condition())) {
            sqlBuilder.append(" WHERE ").append(query.condition());
        }
        try (var connection = ConnectionPool.of().getConnection()) {
            var ps = connection.prepareStatement(sqlBuilder.toString());
            if (query.value() != null) {
                ps.setObject(1, query.value());
            } else if (query.values() != null) {
                AtomicInteger index = new AtomicInteger(1);
                query.values().forEach(value-> {
                    try {
                        ps.setObject(index.getAndIncrement(), value);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
            }

            var rs = ps.executeQuery();
            T t = null;
            if (rs.next()) {
                t = mapToEntity(rs, tClass);

                return Optional.of(t);
            }

            return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();

            return Optional.empty();
        }
    }

    @Override
    public Page<T> findAll(Query<T> query, PageAble pageAble) {
        var sqlBuilder = new StringBuilder(this.select);
        int index = 0;
        int size = 10;
        if (StringUtil.notEmpty(query.condition())) {
            sqlBuilder.append(" WHERE ").append(query.condition());
        }
        if (pageAble != null) {
            index = pageAble.getPage();
            size = pageAble.getSize();
            sqlBuilder.append(" LIMIT ? OFFSET ?");
        }
        try (var connection = ConnectionPool.of().getConnection()) {
            var ps = connection.prepareStatement(sqlBuilder.toString());
            var j = 1;
            if (query.value() != null) {
                ps.setObject(j++, query.value());
            } else if (query.values() != null) {
                for (Object value : query.values()) {
                    ps.setObject(j++, value);
                }
            }
            ps.setInt(j++, size);
            ps.setInt(j, index);


            var rs = ps.executeQuery();
            List<T> list = new LinkedList<>();
            T t = null;
            while (rs.next()) {
                t = mapToEntity(rs, tClass);
                list.add(t);
            }
            var totalItem = count(query);

            return PageImpl.of(index, size, totalItem, list);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return PageImpl.of();
    }

    @Override
    public long count(Query<T> query) {
        var sqlBuilder = new StringBuilder(this.count);
        if (StringUtils.isNullOrEmpty(query.condition())) {
            sqlBuilder.append(" WHERE ").append(query.condition());
        }
        try (var connection = ConnectionPool.of().getConnection()) {
            var ps = connection.prepareStatement(sqlBuilder.toString());
            if (query.value() != null) {
                ps.setObject(1, query.value());
            } else if (query.values() != null) {
                int j = 1;
                for (Object value : query.values()) {
                    ps.setObject(j++, value);
                }
            }

            var rs = ps.executeQuery();

            return rs.getLong("total");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
