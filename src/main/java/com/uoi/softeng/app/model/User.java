package com.uoi.softeng.app.model;

import com.uoi.softeng.app.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_ownership",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> ownedBooks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Category> favouriteCategories;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Author> favouriteAuthors;

    @OneToMany(mappedBy = "requester", cascade = CascadeType.ALL)
    private List<Request> requestsAsRequester;

    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
    private List<Request> requestsAsRecipient;

    public User(){
        this.ownedBooks = new ArrayList<>();
    }

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
        //this.password = userDTO.password;
        this.address = userDTO.address;
        //this.zipcode = userDTO.zipcode;
        //this.ownedBooks = userDTO.ownedBooks;
        this.favouriteCategories = userDTO.favouriteCategories;
        //this.favouriteAuthors = userDTO.favouriteAuthors;
//        this.requests = userDTO.requests;
    }

    public User omitPrivateData(){
        User privateUser = new User();

        privateUser.name = this.name;
        privateUser.surname = this.surname;
        privateUser.email = this.email;
        privateUser.address = this.address;
        //privateUser.zipcode = this.zipcode;

        return privateUser;
    }

    public void addBook(Book book){
        this.ownedBooks.add(book);
    }
}
