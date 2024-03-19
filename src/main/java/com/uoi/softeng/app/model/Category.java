package com.uoi.softeng.app.model;

import jakarta.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String category;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Category(){}

    public Category(String category){
        this.category = category;
    }

    public Integer getId(){
        return Id;
    }

    public String getCategory(){
        return category;
    }
}
