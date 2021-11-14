package com.news.utils;

import com.news.exception.OrmException;

public class StringUtil {
    private StringUtil() {}

    public static boolean isEmpty(String value) {
        return value == null || value.length() == 0;
    }

    /*
    * class name : SchoolName
    * => school_name
    * attributes : studentName
    * => student_name
    * */
    public static String convertToRuleDatabaseName(String value) {
        if (isEmpty(value)) {
            throw new OrmException("ClassName is empty");
        }
        StringBuilder databaseName = new StringBuilder();
        char[] chars = value.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                if (i == 0) {
                    databaseName.append((char) (chars[i]+32));
                } else {
                    databaseName.append("_").append((char) (chars[i]+32));
                }
            } else {
                databaseName.append(chars[i]);
            }
        }
        return databaseName.toString();
    }
}
