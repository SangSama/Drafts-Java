package com.news.repository.impl;

import com.news.autowire.annotation.Repository;
import com.news.model.entity.News;
import com.news.repository.NewsRepository;
import com.news.orm.impl.BaseRepository;

@Repository
public class NewsRepositoryImpl extends BaseRepository<News, Long> implements NewsRepository {
}
