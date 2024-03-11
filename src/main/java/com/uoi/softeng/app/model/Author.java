package com.uoi.softeng.app.model;

import jakarta.persistence.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String name;
    private String surname;

    public Author(){}

    public Integer getId(){
        return Id;
    }
}
