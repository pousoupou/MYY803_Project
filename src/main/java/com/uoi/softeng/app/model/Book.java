package com.uoi.softeng.app.model;

import com.uoi.softeng.app.dto.BookDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer isbn;
    private String title;

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
        this.author = bookDTO.author;
        this.categories = bookDTO.categories;
    }

    public void updateData(BookDTO bookDTO){
        this.isbn = bookDTO.isbn;
        this.title = bookDTO.title;
        this.author = bookDTO.author;
        this.categories = bookDTO.categories;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getIsbn(){
        return isbn;
    }

    public void setIsbn(Integer isbn){
        this.isbn = isbn;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public Author getAuthor(){
        return author;
    }

    public void setAuthor(Author author){
        this.author = author;
    }

    public List<Category> getCategories(){
        return categories;
    }

    public void setCategories(List<Category> categories){
        this.categories = categories;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Request getRequest(){
        return request;
    }

    public void setRequest(Request request){
        this.request = request;
    }
}
