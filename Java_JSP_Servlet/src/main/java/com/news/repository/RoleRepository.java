package com.news.repository;

import com.news.autowire.annotation.Repository;
import com.news.model.entity.Role;
import com.news.orm.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
