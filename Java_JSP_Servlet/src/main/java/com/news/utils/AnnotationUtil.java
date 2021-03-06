package com.news.utils;

import com.news.exception.OrmException;
import com.news.orm.annotation.Column;
import com.news.orm.annotation.Entity;
import com.news.orm.annotation.Id;
import com.news.utils.StringUtil;

public class AnnotationUtil {
    private AnnotationUtil() {}

    public static <T> String getClassName(Class<T> tClass) {
        String name = tClass.getAnnotation(Entity.class).name();

        if (com.test.utils.StringUtil.isEmpty(name)) {
            return com.test.utils.StringUtil.convertToRuleDatabaseName(tClass.getSimpleName());
        }

        return name;
    }

    public static <T> String getColumnName(Class<T> tClass, String fieldName) {
        try {
            String name = tClass.getDeclaredField(fieldName).getAnnotation(Column.class).name();
            if (com.test.utils.StringUtil.isEmpty(name)) {
                return com.test.utils.StringUtil.convertToRuleDatabaseName(fieldName);
            }

            return name;
        } catch (NoSuchFieldException e) {
            throw new OrmException(e.getMessage());
        }
    }

    public static <T> boolean isAutoIncrement(Class<T> tClass, String fieldName) {
        try {
            return tClass.getDeclaredField(fieldName).getAnnotation(Id.class).autoIncrement();
        } catch (NoSuchFieldException e) {
            throw new OrmException(e.getMessage());
        }
    }

    public static <T> String primaryColumn(Class<T> tClass, String fieldName) {
        try {
            String name = tClass.getDeclaredField(fieldName).getAnnotation(Id.class).name();
            if (com.test.utils.StringUtil.isEmpty(name)) {
                return StringUtil.convertToRuleDatabaseName(fieldName);
            }

            return name;
        } catch (NoSuchFieldException e) {
            throw new OrmException(e.getMessage());
        }
    }
}
