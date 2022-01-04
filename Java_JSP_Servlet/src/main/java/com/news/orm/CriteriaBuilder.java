package com.news.orm;

import java.util.function.Predicate;

public interface CriteriaBuilder<T> {
    Predicate<T> eq(Expression<T> expression, Object value);

    Predicate<T> notEq(Expression<T> expression, Object value);

    Predicate<T> gt(Expression<? extends Number> var1, Number var2);

    Predicate<T> ge(Expression<? extends Number> var1, Number var2);

    Predicate<T> lt(Expression<? extends Number> var1, Number var2);

    Predicate<T> le(Expression<? extends Number> var1, Number var2);

    Predicate<T> like(Expression<String> var1, String var2);

    Predicate<T> notLike(Expression<String> var1, String var2);
}
