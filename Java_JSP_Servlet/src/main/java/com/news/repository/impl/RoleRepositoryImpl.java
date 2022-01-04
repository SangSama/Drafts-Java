package com.news.repository.impl;

import com.news.autowire.annotation.Repository;
import com.news.model.entity.Role;
import com.news.repository.RoleRepository;
import com.news.orm.impl.BaseRepository;

@Repository
public class RoleRepositoryImpl extends BaseRepository<Role, Long> implements RoleRepository {
}
