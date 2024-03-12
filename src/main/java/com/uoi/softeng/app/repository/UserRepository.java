package com.uoi.softeng.app.repository;

import com.uoi.softeng.app.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "select * from user where email = :email", nativeQuery = true)
    User findUserByEmail(String email);
}
