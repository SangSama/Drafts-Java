package com.news.repository;

import com.news.model.entity.Category;
import com.test.orm.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
