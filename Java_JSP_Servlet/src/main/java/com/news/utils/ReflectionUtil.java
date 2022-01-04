package com.news.utils;

import com.news.exception.OrmException;
import com.news.orm.annotation.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import static com.news.utils.AnnotationUtil.getColumnName;
import static com.news.utils.AnnotationUtil.primaryColumn;

public class ReflectionUtil {
    private ReflectionUtil() {}

    public static <T> Object get(Object instance, Field field) {
        String name = field.getName();          // lấy name của field
        String prefix;
        /*
         * flag
         * => isFlag() => flag
         * name
         * => getName() => name
         * */
        if (field.getType().equals(Boolean.class) || field.getType().equals(boolean.class)) {
            prefix = "is";
        } else {
            prefix = "get";
        }
        name = prefix + name.substring(0, 1).toUpperCase() + name.substring(1);

        /*
         * invoke()
         * => Obj nào gọi hàm của Obj đấy
         * => danh sách tham số
         * */
        try {
            Method method = instance.getClass().getDeclaredMethod(name);
            return method.invoke(instance);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    public static <T> void set(Field field, T instance,Object value) {
        String name = field.getName();
        String prefix = "set";
        name = "is" + name.substring(0, 1).toUpperCase() + name.substring(1);

        try {
            Method method = instance.getClass().getDeclaredMethod(name);
            method.invoke(instance, value);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new OrmException(e.getMessage());
        }

//        // vi phạm chính sách về bảo mật của java
//        // setAccessible() => từ thằng bên ngoài truy cập vào bên trong
//        // => không nên làm như vậy
//        field.setAccessible(true);
//        field.set(instance, value);
    }

    public static <T> T mapToEntity(ResultSet resultSet, Class<T> tClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final T t = tClass.getDeclaredConstructor().newInstance();
        Field[] fields = tClass.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            String columnName;
            if (!field.isAnnotationPresent(Id.class)) {
                columnName = getColumnName(tClass, field.getName());
            } else {
                columnName = primaryColumn(tClass, field.getName());
            }

            try {
                set(field, t, resultSet.getObject(columnName));
            } catch (SQLException e) {
                throw new OrmException(e.getMessage());
            }
        });

        return t;
    }
}
