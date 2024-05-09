package com.uoi.softeng.app.services;

import com.uoi.softeng.app.dto.LoginDTO;
import com.uoi.softeng.app.dto.UserDTO;
import com.uoi.softeng.app.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<User> getAllUsers();

    String userLogin(LoginDTO loginDTO);

    User getUserByEmail(String email);

    void registerUser(UserDTO userDTO);

    void updateUser(String uuid, UserDTO userDTO);

    void deleteUser(String uuid);

    public boolean isUserPresent(User user);

    UserDTO getUser(String uuid);
}
