package com.news.orm.imlp;

import com.news.exception.OrmException;
import com.news.orm.JpaRepository;
import com.news.orm.annotation.Id;
import com.news.orm.paging.Page;
import com.news.orm.paging.PageAble;
import com.news.orm.pool.ConnectionPool;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static com.news.utils.AnnotationUtil.*;
import static com.news.utils.ReflectionUtil.*;

public class BaseRepository<T, ID extends Serializable> implements JpaRepository<T, ID> {

    private Class<T> tClass;
    private final String tableName;
    private String insert;

    public BaseRepository() {
        this.tClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.tableName = getClassName(tClass);
        // insert into student(%s) VALUES(%s) => %s : dùng StringFormat add vào
        this.insert = "INSERT INTO " + tableName + "(%s) VALUES (%S)";
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
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.empty();
    }

    @Override
    public T getOne() {
        return null;
    }

    @Override
    public Page<T> findAll(PageAble pageAble) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
