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

    @ManyToMany
    @JoinTable(
            name = "book_book_author",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;


    @ManyToMany(mappedBy = "favoriteBookAuthors")
    private List<UserProfile> users;

    public BookAuthor(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public BookAuthor() {
    }
}