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
    private String fullName;
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
    private List<BookCategory> favouriteBookCategories;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "user_profile_book_author", // Name of the join table
        joinColumns = @JoinColumn(name = "user_profile_id"), // Column name for UserProfile
        inverseJoinColumns = @JoinColumn(name = "book_author_id") // Column name for BookAuthor
    )
    private List<BookAuthor> favoriteBookAuthors;




    public UserProfile(String username, String fullName, int age, List<Book> bookOffers, List<BookCategory> favouriteBookCategories, List<BookAuthor> favoriteBookAuthors) {
        this.username = username;
        this.fullName = fullName;
        this.age = age;
        this.bookOffers = bookOffers;
        this.favouriteBookCategories = favouriteBookCategories;
        this.favoriteBookAuthors = favoriteBookAuthors;
    }


    public UserProfile() {

    }
}
