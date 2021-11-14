package com.news.orm;

import com.news.orm.annotation.Id;
import com.news.orm.paging.Page;
import com.news.orm.paging.PageAble;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface JpaRepository<T, ID extends Serializable> {
    void save(T t);

    void update(ID id, T t);

    Optional<T> findById(ID id);

    T getOne();

    Page<T> findAll(PageAble pageAble);

    List<T> findAll();
}
