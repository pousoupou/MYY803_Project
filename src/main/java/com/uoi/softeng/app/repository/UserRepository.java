package com.uoi.softeng.app.repository;

import com.uoi.softeng.app.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<User, String> {
    @Query(value = "SELECT * FROM user WHERE email = :email AND password = :password", nativeQuery = true)
    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    //@Query(value = "INSERT INTO user (name, surname, email, password, address, zipcode) VALUES (:name, :surname, :email, :password, :address, :zipcode)", nativeQuery = true)


}
