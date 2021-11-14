package com.news.utils;

import com.news.exception.OrmException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
        name = "is" + name.substring(0, 1).toUpperCase() + name.substring(1);

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
}
