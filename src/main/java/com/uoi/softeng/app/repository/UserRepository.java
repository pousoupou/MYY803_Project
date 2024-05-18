package com.uoi.softeng.app.repository;

import com.uoi.softeng.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;




public interface UserRepository extends JpaRepository<User, Integer> {





    User findByUsername(String username);
}
