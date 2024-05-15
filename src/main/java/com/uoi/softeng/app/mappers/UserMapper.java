package com.uoi.softeng.app.mappers;

import com.uoi.softeng.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<User, String>{

    User findByUsername(String username);


}
