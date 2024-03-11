package com.uoi.softeng.app.model;

import jakarta.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String category;

    public Category(){}

    public Integer getId(){
        return Id;
    }
}
