package com.uoi.softeng.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToMany(mappedBy = "favouriteCategories", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<User> user;

    public Category(){}

    public Category(String categoryName){
        this.categoryName = categoryName;
    }
}
