package com.uoi.softeng.app.model;

import jakarta.persistence.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String name;

    @OneToOne(mappedBy = "author")
    private Book book;

    @ManyToOne
    private User user;

    public Author(){}

    public void updateAuthorData(){

    }

    public Integer getId(){
        return Id;
    }

    public String getName(){
        return name;
    }
}
