package com.uoi.softeng.app.services;

import com.uoi.softeng.app.dto.LoginDTO;
import com.uoi.softeng.app.dto.UserDTO;
import com.uoi.softeng.app.model.User;
import com.uoi.softeng.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> getAllUsers(){
        return (List<User>) userRepo.findAll();
    }

    @Override
    public String userLogin(LoginDTO loginDTO){
        return userRepo.findByEmailAndPassword(loginDTO.email, loginDTO.password).getId();
    }

    @Override
    public User getUserByEmail(String email){
        return userRepo.findByEmail(email);
    }

    @Override
    public void addUser(UserDTO userDTO){
        User existing = this.getUserByEmail(userDTO.email);

        if(existing == null){
            User user = new User(userDTO);
            userRepo.save(user);
        } else {
            throw new RuntimeException("User Already Exists!");
        }
    }

    @Override
    public void updateUser(String uuid, UserDTO userDTO){
        User existing = userRepo.findById(uuid);

        if(existing != null){
            existing.updateData(userDTO);
            userRepo.save(existing);
        } else {
            throw new RuntimeException("User Does Not Exist!");
        }
    }

    @Override
    public void deleteUser(String uuid){
        userRepo.deleteById(uuid);
    }
}
