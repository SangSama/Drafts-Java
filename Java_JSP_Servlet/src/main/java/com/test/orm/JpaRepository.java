package com.test.orm;

import com.test.orm.paging.Page;
import com.test.orm.paging.PageAble;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface JpaRepository<T, ID extends Serializable> {
    // Repository Pattern

    void save(T t);

    void update(ID id, T t);

    Optional<T> findById(ID id);

    T getOne(ID id);

    Page<T> findAll(PageAble pageAble);

    List<T> findAll();

    long count();

    boolean delete(ID id);

    boolean deleteAll(List<ID> ids);
}
