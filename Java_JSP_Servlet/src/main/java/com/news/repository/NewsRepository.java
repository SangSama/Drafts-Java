package com.news.repository;

import com.news.model.entity.News;
import com.test.orm.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
