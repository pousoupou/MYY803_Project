package com.uoi.softeng.app.model;

import com.uoi.softeng.app.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String surname;
    private String email;
    private String password;
    private String address;
    private Integer zipcode;

    @OneToMany(mappedBy = "user")
    private List<Book> ownedBooks;

    @OneToMany(mappedBy = "user")
    private List<Category> favouriteCategories;

    @OneToMany(mappedBy = "user")
    private List<Author> favouriteAuthors;

    @OneToMany(mappedBy = "requester")
    private List<Request> requestsAsRequester;

    @OneToMany(mappedBy = "recipient")
    private List<Request> requestsAsRecipient;

    public User(){}

    public User(UserDTO userDTO){
        this.name = userDTO.name;
        this.surname = userDTO.surname;
        this.email = userDTO.email;
        this.password = userDTO.password;
        this.address = userDTO.address;
        this.zipcode = userDTO.zipcode;
        this.ownedBooks = userDTO.ownedBooks;
        this.favouriteCategories = userDTO.favouriteCategories;
        this.favouriteAuthors = userDTO.favouriteAuthors;
//        this.requests = userDTO.requests;
    }

    public void updateData(UserDTO userDTO){
        this.name = userDTO.name;
        this.surname = userDTO.surname;
        this.email = userDTO.email;
        this.password = userDTO.password;
        this.address = userDTO.address;
        this.zipcode = userDTO.zipcode;
        this.ownedBooks = userDTO.ownedBooks;
        this.favouriteCategories = userDTO.favouriteCategories;
        this.favouriteAuthors = userDTO.favouriteAuthors;
//        this.requests = userDTO.requests;
    }

    public User omitPrivateData(){
        User privateUser = new User();

        privateUser.name = this.name;
        privateUser.surname = this.surname;
        privateUser.email = this.email;
        privateUser.address = this.address;
        privateUser.zipcode = this.zipcode;

        return privateUser;
    }
}
