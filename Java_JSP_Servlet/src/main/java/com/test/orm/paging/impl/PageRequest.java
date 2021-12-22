package com.test.orm.paging.impl;

import com.test.orm.paging.PageAble;

public class PageRequest implements PageAble {
    private int page;
    private int size;

    public PageRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public static PageAble of(int page, int size) {
        return new PageRequest(page, size);
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public int getSize() {
        return size;
    }

    /*
    *   SELECT * FROM Student
    *   LIMIT 10 OFFSET 21
    * => nghĩa là từ phần tử 21 đến phần tử 30
    * */
    @Override
    public int getOffset() {
        return (page == 1 || page == 0) ? 0 : (page - 1)*size;
    }
}
