package com.news.repository;

import com.news.model.entity.User;
import com.test.orm.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
