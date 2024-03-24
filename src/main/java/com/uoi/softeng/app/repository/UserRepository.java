package com.uoi.softeng.app.repository;

import com.uoi.softeng.app.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "SELECT * FROM user WHERE email = :email AND password = :password", nativeQuery = true)
    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    User findById(String uuid);

    void deleteById(String uuid);
}
