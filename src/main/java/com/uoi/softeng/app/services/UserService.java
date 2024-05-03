package com.uoi.softeng.app.services;

import com.uoi.softeng.app.dto.LoginDTO;
import com.uoi.softeng.app.dto.UserDTO;
import com.uoi.softeng.app.model.Book;
import com.uoi.softeng.app.model.Category;
import com.uoi.softeng.app.model.User;
import com.uoi.softeng.app.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.WordUtils;
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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
    public User getUserByEmail(String email){
        return userRepo.findByEmail(email);
    }

    @Transactional
    @Override
    public void registerUser(UserDTO userDTO){
        userDTO.name = WordUtils.capitalizeFully(userDTO.name);
        userDTO.surname = WordUtils.capitalizeFully(userDTO.surname);
        userDTO.email = userDTO.email.toLowerCase();
        userDTO.address = WordUtils.capitalizeFully(userDTO.address);

        User existing = this.getUserByEmail(userDTO.email);

        if(existing == null){
            if(userDTO.ownedBooks != null){
                for(Book book : userDTO.getOwnedBooks()){
                    Book existingBook = bookService.getBookByISBN(book.getIsbn());
                    if(existingBook == null){
                        bookService.addBook(book);
                    } else {
                        existingBook.increaseQuantity();
                        bookService.updateBook(existingBook);
                        userDTO.ownedBooks.set(userDTO.ownedBooks.indexOf(book), existingBook);
                    }
                }
            }
            System.out.println(userDTO.favouriteCategories == null);
            if(userDTO.favouriteCategories != null){
                for(Category cat : userDTO.favouriteCategories){
                    Category existingCat = catService.getCategoryByName(cat.getCategoryName());
                    if(existingCat == null){
                        System.out.println("Category not found");
                        catService.addCategory(cat);
                    } else {
                        System.out.println("Category found");
                        userDTO.favouriteCategories.set(userDTO.favouriteCategories.indexOf(cat), existingCat);
                    }
                }
            }

            //userDTO.password = bCryptPasswordEncoder.encode(userDTO.password);

            try {
                User user = new User(userDTO);
                userRepo.save(user);
            } catch (Exception e){
                System.out.println("Error: " + e);
            }
        } else {
            System.out.println("Existing user: " + existing.getEmail());
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

    @Override
    public boolean isUserPresent(User user) {
        Optional<User> storedUser = Optional.ofNullable(userRepo.findByEmail(user.getEmail()));
        return storedUser.isPresent();
    }

    @Override
    public UserDTO getUser(String uuid) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(userRepo.findByEmail(username)).orElseThrow(
                ()-> new UsernameNotFoundException(
                        String.format("USER_NOT_FOUND %s", username)
                )
        );
    }
}
