package com.uoi.softeng.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class BookAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorid;

    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

    @ManyToMany(mappedBy = "favoriteBookAuthors", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<UserProfile> users;

    public BookAuthor(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public BookAuthor() {
    }
}