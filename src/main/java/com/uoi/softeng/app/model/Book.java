package com.uoi.softeng.app.model;

import com.uoi.softeng.app.dto.BookDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Integer isbn;

    private String title;

    private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Category> categories;

    @ManyToMany(mappedBy = "ownedBooks", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToOne
    @JoinColumn(name = "request_id")
    private Request request;

    public Book(){
        this.quantity = 1;
        this.users = new ArrayList<>();
    }

    public Book(Book book){
        this.id = book.id;
        this.isbn = book.isbn;
        this.title = book.title;
        this.quantity = book.quantity;
        this.author = book.author;
        this.categories = book.categories;
        this.users = book.users;
        this.request = book.request;
    }

    public Book(BookDTO bookDTO){
        this.isbn = bookDTO.isbn;
        this.title = bookDTO.title;
        this.quantity = 1;
        this.categories = bookDTO.categories;
    }

    public void updateData(BookDTO bookDTO){
        this.isbn = bookDTO.isbn;
        this.title = bookDTO.title;
        this.quantity = bookDTO.quantity;
        this.categories = bookDTO.categories;
    }

    public Integer increaseQuantity(){
        return this.quantity ++;
    }

    public Integer decreaseQuantity(){
        return this.quantity --;
    }

    public void addUser(User user){
        this.users.add(user);
    }
}
