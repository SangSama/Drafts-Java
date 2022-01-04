package com.news.repository;

import com.news.model.entity.User;
import com.news.orm.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
