package com.uoi.softeng.app.repository;

import com.uoi.softeng.app.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
