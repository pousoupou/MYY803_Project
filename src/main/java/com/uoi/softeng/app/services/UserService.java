package com.uoi.softeng.app.services;

import com.uoi.softeng.app.entity.LoginDTO;
import com.uoi.softeng.app.model.User;
import com.uoi.softeng.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepo;

    @Autowired
    IBookService bookService;

    @Autowired
    ICategoryService catService;

    @Override
    public List<User> getAllUsers(){
        return (List<User>) userRepo.findAll();
    }

    @Override
    public String userLogin(LoginDTO loginDTO){
        return userRepo.findByEmailAndPassword(loginDTO.email, loginDTO.password).getId();
    }

    @Override
    public Optional<User> getUserByEmail(String email){
        return userRepo.findByEmail(email);
    }


//    @Override
//    public void updateUser(String uuid, UserDTO userDTO){
//        if(userRepo.findById(uuid).isPresent()){
//            User user = userRepo.findById(uuid).get();
//            user.updateData(userDTO);
//            userRepo.save(user);
//        } else {
//            throw new RuntimeException("USER NOT FOUND");
//        }
//    }

    @Override
    public void deleteUser(String uuid){
        userRepo.deleteById(uuid);
    }


//
//    @Override
//    public UserDTO getUser(String uuid) {
//        return null;
//    }




    @Override
    public void saveUser(User user) {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);

    }

    @Override
    public boolean isUserPresent(User user) {
        Optional<User> storedUser = userRepo.findByEmail(user.getUsername());
        return storedUser.isPresent();
    }

    // Method defined in Spring Security UserDetailsService interface
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // orElseThrow method of Optional container that throws an exception if Optional result  is null
        return userRepo.findByEmail(username).orElseThrow(
                ()-> new UsernameNotFoundException(
                        String.format("USER_NOT_FOUND %s", username)
                ));
    }


}
