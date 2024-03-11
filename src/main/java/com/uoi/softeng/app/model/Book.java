package com.uoi.softeng.app.model;

import com.uoi.softeng.app.dto.BookDTO;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String isbn;
    private String title;
    private String author;

    @ElementCollection
    private ArrayList<Integer> categories;

    public Book(){}

    public Book(BookDTO bookDTO){
        this.isbn = bookDTO.isbn;
        this.title = bookDTO.title;
        this.author = bookDTO.author;
        this.categories = bookDTO.categories;
    }

    public Integer getId(){
        return id;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public ArrayList<Integer> getCategories(){
        return categories;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        author = author;
    }

    public void setCategories(ArrayList<Integer> categories){
        this.categories = categories;
    }
}
