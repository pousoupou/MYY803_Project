package com.uoi.softeng.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String name;
    private String surname;
    private int age;

    @OneToMany(mappedBy = "offeredByUser", cascade = CascadeType.ALL)
    private List<Book> bookOffers;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_profile_requested_books",
            joinColumns = @JoinColumn(name = "user_profile_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> requestedBooks;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_profile_book_category",
            joinColumns = @JoinColumn(name = "user_profile_id"),
            inverseJoinColumns = @JoinColumn(name = "book_category_id")
    )
    private List<BookCategory> favoriteBookCategories;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "user_profile_book_author", // Name of the join table
        joinColumns = @JoinColumn(name = "user_profile_id"), // Column name for UserProfile
        inverseJoinColumns = @JoinColumn(name = "book_author_id") // Column name for BookAuthor
    )
    private List<BookAuthor> favoriteBookAuthors;

    public UserProfile(String username, String name, String surname, int age, List<Book> bookOffers, List<Book> requestedBooks, List<BookCategory> favoriteBookCategories, List<BookAuthor> favoriteBookAuthors) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bookOffers = bookOffers;
        this.requestedBooks = requestedBooks;
        this.favoriteBookCategories = favoriteBookCategories;
        this.favoriteBookAuthors = favoriteBookAuthors;
    }

    public UserProfile() {

    }
}
