package com.uoi.softeng.app.model;

import com.uoi.softeng.app.model.BookCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Setter
@Getter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookid;

    private String title;


    @ManyToMany(mappedBy = "books")
//    @JoinTable(
//            name = "book_author",
//            joinColumns = @JoinColumn(name = "book_id"),
//            inverseJoinColumns = @JoinColumn(name = "author_id")
//    )
    private List<BookAuthor> bookAuthors;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private BookCategory bookCategory;


    @ManyToOne
    @JoinColumn(name = "offered_by_user_id")
    private UserProfile offeredByUser;

    @ManyToMany(mappedBy = "requestedBooks")
    private List<UserProfile> requestingUsers;


    @OneToOne(mappedBy = "book")
    private Request requests;

    public Book(String title, List<BookAuthor> bookAuthors, BookCategory bookCategory, List<UserProfile> requestingUsers) {
        this.title = title;
        this.bookAuthors = bookAuthors;
        this.bookCategory = bookCategory;
        this.requestingUsers = requestingUsers;
    }


    public Book() {

    }
}
