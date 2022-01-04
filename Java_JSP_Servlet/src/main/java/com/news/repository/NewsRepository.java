package com.news.repository;

import com.news.autowire.annotation.Repository;
import com.news.model.entity.News;
import com.news.orm.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
