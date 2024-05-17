package com.uoi.softeng.app.services;

import com.uoi.softeng.app.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void saveUser(User user);

    boolean isUserPresent(User user);

    User findById(String username);

    User findByEmail(String email);

    void register(User user);

    <BookFormData> void saveBookOffer(BookFormData bookFormData);

    void requestBook(int bookId);

    void acceptBookRequest(String username, int bookId);

    void deleteBookRequest(String username, int bookId);
}
