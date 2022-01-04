package com.news.orm.paging;

import com.news.orm.paging.impl.PageImpl;

import java.util.List;
import java.util.function.Function;

public interface Page<T> {
    int getPage();

    int getSize();

    long getTotal();

    long getTotalPage();

    List<T> getData();

    <Q> List<Q> map(Function<T, Q> map);
}
