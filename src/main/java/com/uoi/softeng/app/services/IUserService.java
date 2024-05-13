package com.uoi.softeng.app.services;

import com.uoi.softeng.app.entity.LoginDTO;
import com.uoi.softeng.app.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();

    String userLogin(LoginDTO loginDTO);

    Optional<User> getUserByEmail(String email);

    void saveUser(User user);

    //void updateUser(String uuid, UserDTO userDTO);

    void deleteUser(String uuid);

    public boolean isUserPresent(User user);

//    UserDTO getUser(String uuid);
}
