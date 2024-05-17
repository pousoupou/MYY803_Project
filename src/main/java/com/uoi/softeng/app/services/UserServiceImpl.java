package com.uoi.softeng.app.services;

import com.uoi.softeng.app.mappers.UserMapper;
import com.uoi.softeng.app.model.Role;
import com.uoi.softeng.app.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserMapper userDAO;

    @Override
    public void saveUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userDAO.save(user);
    }

    @Override
    public boolean isUserPresent(User user) {
        Optional<User> storedUser = Optional.ofNullable(userDAO.findByUsername(user.getUsername()));
        return storedUser.isPresent();
    }

    @Override
    public User findById(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public User findByEmail(String email){
        return userDAO.findByUsername(email);
    }

    @Override
    public void register(User user) {
        // Step 1: Validate the user data (this is a simplified example)
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("User, username, and password cannot be null");
        }
        if (isUserPresent(user)) {
            throw new IllegalArgumentException("User already exists");
        }

        // Step 2: Encode the password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // Step 3: Save the user
        try {
            user.setRole(Role.ROLE_USER);
            userDAO.save(user);
        } catch (Exception e) {
            // Step 4: Handle exceptions
            log.error("Error registering user: {}", e.getMessage());
            throw new RuntimeException("The user could not be registered");
        }
    }

    @Override
    public <BookFormData> void saveBookOffer(BookFormData bookFormData) {

    }

    @Override
    public void requestBook(int bookId) {

    }

    @Override
    public void acceptBookRequest(String username, int bookId) {

    }

    @Override
    public void deleteBookRequest(String username, int bookId) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRoleToAuthority(user.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthority(Role role) {
        return Collections.singleton(new SimpleGrantedAuthority(role.name()));
    }

    // Method defined in Spring Security UserDetailsService interface
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // orElseThrow method of Optional container that throws an exception if Optional result  is null
//        return userDAO.findByUsername(username).orElseThrow(
//                ()-> new UsernameNotFoundException(
//                        String.format("USER_NOT_FOUND %s", username)
//                ));
//    }


}
