package com.uoi.softeng.app.repository;

import com.uoi.softeng.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;




public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query(value = "SELECT * FROM users WHERE user_name = :username AND password = :password", nativeQuery = true)




    User findByUsername(String username);
}
