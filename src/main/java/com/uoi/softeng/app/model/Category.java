package com.uoi.softeng.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    private String categoryName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_categories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

    @ManyToMany(mappedBy = "favouriteCategories", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<User> users;

    public Category(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public Category(String categoryName){
        this.categoryName = categoryName;
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book){
        this.books.add(book);
    }
}
