package com.news.repository;

import com.news.autowire.annotation.Repository;
import com.news.model.entity.Category;
import com.news.orm.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
