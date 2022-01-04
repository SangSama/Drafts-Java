package com.news.repository.impl;

import com.news.autowire.annotation.Repository;
import com.news.model.entity.User;
import com.news.orm.impl.BaseRepository;
import com.news.repository.UserRepository;

@Repository
public class UserRepositoryImpl extends BaseRepository<User, Long> implements UserRepository {
}
