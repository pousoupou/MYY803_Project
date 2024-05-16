package com.uoi.softeng.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryid;

    private String categoryName;

    @OneToMany(mappedBy = "bookCategory")
//    @JoinTable(
//            name = "book_categories",
//            joinColumns = @JoinColumn(name = "category_id"),
//            inverseJoinColumns = @JoinColumn(name = "book_id")
//    )
    private List<Book> books;

    @ManyToMany(mappedBy = "favoriteBookCategories")
    private List<UserProfile> users;


    public BookCategory(String categoryName, List<Book> books) {
        this.categoryName = categoryName;
        this.books = books;
    }


    public BookCategory() {

    }
}
