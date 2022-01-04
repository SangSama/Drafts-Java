package com.news.repository.impl;

import com.news.autowire.annotation.Repository;
import com.news.model.entity.Category;
import com.news.orm.impl.BaseRepository;
import com.news.repository.CategoryRepository;

@Repository
public class CategoryRepositoryImpl extends BaseRepository<Category, Long> implements CategoryRepository {
}
