package com.uoi.softeng.app.model;

import com.uoi.softeng.app.dto.BookDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Category> categories;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "request_id")
    private Request request;

    public Book(){}

    public Book(BookDTO bookDTO){
        this.isbn = bookDTO.isbn;
        this.title = bookDTO.title;
        this.quantity = 1;
        this.author = bookDTO.author;
        this.categories = bookDTO.categories;
    }

    public void updateData(BookDTO bookDTO){
        this.isbn = bookDTO.isbn;
        this.title = bookDTO.title;
        this.quantity = bookDTO.quantity;
        this.author = bookDTO.author;
        this.categories = bookDTO.categories;
    }

    public Integer increaseQuantity(){
        return this.quantity ++;
    }

    public Integer decreaseQuantity(){
        return this.quantity --;
    }
}
