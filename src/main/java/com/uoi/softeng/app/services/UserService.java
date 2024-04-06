package com.uoi.softeng.app.services;

import com.uoi.softeng.app.dto.LoginDTO;
import com.uoi.softeng.app.dto.UserDTO;
import com.uoi.softeng.app.model.Book;
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

    @Autowired
    IBookService bookService;


    @Autowired
    public UserService(UserRepository userRepo, IBookService bookService){
        this.userRepo = userRepo;
        this.bookService = bookService;
    }

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
    public void registerUser(UserDTO userDTO){
        User existing = this.getUserByEmail(userDTO.email);

        if(existing == null){
            User user = new User(userDTO);
            List<Book> allBooks = bookService.getAllBooks();
//            for(Book book : userDTO.ownedBooks){
//                if(allBooks.contains(book)){
//                    book.getUsers().add(user);
//                    bookService.updateBook(book);
//                } else {
//                    Book newBook = new Book(book);
//                    newBook.getUsers().add(user);
//                    bookService.addBook(newBook);
//                }
//            }
//            userRepo.save(user);
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
