package com.news.orm;

import com.news.orm.impl.QueryImpl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class QueryFactory {
    private QueryFactory() {
    }

    public static <T> Query<T> eq(String column, Object value) {
        return new QueryImpl<>(column, Expression::eq, value);
    }

    public static <T> Query<T> notEqual(String column, Object value) {
        return new QueryImpl<>(column, Expression::notEqual, value);
    }

    public static <T> Query<T> gt(String columnName, Object value) {
        return new QueryImpl<>(columnName, Expression::gt, value);
    }

    public static <T> Query<T> gte(String column, Object value) {
        return new QueryImpl<>(column, Expression::gte, value);
    }

    public static <T> Query<T> lt(String column, Object value) {
        return new QueryImpl<>(column, Expression::lt, value);
    }

    public static <T> Query<T> lte(String column, Object value) {
        return new QueryImpl<>(column, Expression::lte, value);
    }

    public static <T> Query<T> like(String column, Object value) {
        return new QueryImpl<>(column, Expression::like, "%" + value + "%");
    }

    public static <T> Query<T> isNull(String column) {
        return new QueryImpl<>(column, Expression::isNULL);
    }

    public static <T> Query<T> isNotNull(String column) {
        return new QueryImpl<>(column, Expression::isNotNull);
    }

    public static <T> Query<T> and(Query<T> query, Query<T> query1) {
        String conditionBuilder = query.condition() + Expression.and() + query1.condition();
        var objects = List.of(query.value(), query1.value());

        return new QueryImpl<>(conditionBuilder, objects);
    }

    public static <T> Query<T> or(Query<T> query1, Query<T> query2) {

        String conditionBuilder = query1.condition() + Expression.or() + query2.condition();
        var objects = List.of(query1.value(), query2.value());

        return new QueryImpl<>(conditionBuilder, objects);
    }

    public static <T> Query<T> and(List<Query<T>> queries) {
        var rs = queries.stream().filter(Objects::nonNull).toList();
        if (rs.size() == 1) {
            return new QueryImpl<>(rs.get(0).condition(), rs.get(0).value());
        }
        var condition = rs.stream().map(Query::condition).collect(Collectors.joining(Expression.and()));
        var objects = rs.stream().map(Query::value).collect(Collectors.toList());

        return new QueryImpl<>(condition, objects);
    }

    public static <T> Query<T> or(List<Query<T>> queries) {
        var rs = queries.stream().filter(Objects::nonNull).toList();
        if (rs.size() == 1) {
            return new QueryImpl<>(rs.get(0).condition(), rs.get(0).value());
        }
        var condition = rs.stream().map(Query::condition).collect(Collectors.joining(Expression.or()));
        var objects = rs.stream().map(Query::value).collect(Collectors.toList());

        return new QueryImpl<>(condition, objects);
    }
}
