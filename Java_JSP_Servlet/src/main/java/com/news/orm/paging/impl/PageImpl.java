package com.news.orm.paging.impl;

import com.news.orm.paging.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PageImpl<T> implements Page<T> {
    private int page;
    private int size;
    private long total;
    private long totalPage;
    private List<T> data;

    private PageImpl(int page, int size, long total, List<T> data) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.data = data;
    }

    // <T> tại thời điểm Compie --- <T> tại thời điểm Runtime => phải định nghĩa kiểu <T>
    public static <T> Page<T> of(int page, int size, long total, List<T> data) {
        return new PageImpl<>(page, size, total, data);
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public long getTotal() {
        return total;
    }

    @Override
    public long getTotalPage() {
        if (size == 0) return 0;

        if (total <= size) return 1;

        return (total / size) + 1;
    }

    @Override
    public List<T> getData() {
        return data;
    }

    @Override
    public <Q> List<Q> map(Function<T, Q> map) {
        return data.stream().map(map::apply).collect(Collectors.toList());
    }
}
