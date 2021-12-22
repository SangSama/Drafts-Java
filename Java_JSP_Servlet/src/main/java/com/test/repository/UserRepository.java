package com.test.repository;

import com.test.model.entity.User;
import com.test.orm.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
