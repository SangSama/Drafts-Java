package com.news.orm.impl;

import com.news.orm.Expression;
import com.news.orm.Query;

import java.util.List;

public class QueryImpl<T> implements Query<T> {
    private String condition;
    private Object value;
    private List<Object> values;

    public QueryImpl(String condition, Expression expression, Object value) {
        this.condition = condition + expression.expression() + "?";
        this.value = value;
    }

    public QueryImpl(String condition, Expression expression) {
        this.condition = condition + expression.expression();
    }

    public QueryImpl(String condition, List<Object> values){
        this.condition = condition;
        this.values = values;
    }

    public QueryImpl(String condition, Object value) {
        this.condition = condition;
        this.value = value;
    }

    @Override
    public String condition() {
        return condition;
    }

    @Override
    public Object value() {
        return value;
    }

    @Override
    public List<Object> values() {
        return this.values;
    }
}
