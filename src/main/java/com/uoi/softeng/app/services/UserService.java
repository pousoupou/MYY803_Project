package com.uoi.softeng.app.services;

import com.uoi.softeng.app.dto.LoginDTO;
import com.uoi.softeng.app.dto.UserDTO;
import com.uoi.softeng.app.model.Book;
import com.uoi.softeng.app.model.User;
import com.uoi.softeng.app.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepo;

    @Autowired
    IBookService bookService;

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

    @Transactional
    @Override
    public void registerUser(UserDTO userDTO){
        User existing = this.getUserByEmail(userDTO.email);

        System.out.println("Existing user: " + existing);


        if(existing == null){
//            for(Book book : userDTO.ownedBooks){
//                Book existingBook = bookService.getBookByISBN(book.getIsbn());
//                if(existingBook == null){
//                    bookService.addBook(book);
//                } else {
//                    existingBook.increaseQuantity();
//                    bookService.updateBook(existingBook);
//                    userDTO.ownedBooks.set(userDTO.ownedBooks.indexOf(book), existingBook);
//                }
//            }
            //System.out.println("UserDTO: " + userDTO);

            try {
                User user = new User(userDTO);
                System.out.println("New user: " + user);

                userRepo.save(user);

                System.out.println("User: " + user);
            } catch (Exception e){
                System.out.println("Error: " + e);
            }



        } else {
            throw new RuntimeException("User Already Exists!");
        }
    }

    @Override
    public void updateUser(String uuid, UserDTO userDTO){
        if(userRepo.findById(uuid).isPresent()){
            User user = userRepo.findById(uuid).get();
            user.updateData(userDTO);
            userRepo.save(user);
        } else {
            throw new RuntimeException("USER NOT FOUND");
        }
    }

    @Override
    public void deleteUser(String uuid){
        userRepo.deleteById(uuid);
    }
}
