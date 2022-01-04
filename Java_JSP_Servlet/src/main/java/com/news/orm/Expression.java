package com.news.orm;

public interface Expression<T> {
    String expression();

    static String eq(){
        return "=";
    }

    static String notEqual(){
        return "<>";
    }

    static String gt(){
        return ">";
    }

    static String gte(){
        return ">=";
    }

    static String like(){
        return " LIKE ";
    }

    static String lt(){
        return "<";
    }

    static String lte(){
        return "<=";
    }

    static String between(){
        return "BETWEEN";
    }

    static String in(){
        return "in";
    }

    static String isNULL(){
        return " is null";
    }

    static String isNotNull(){
        return " is not null";
    }

    static String and(){
        return " AND ";
    }

    static String or(){
        return " OR ";
    }
}
