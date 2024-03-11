package com.uoi.softeng.app.dto;

import java.util.ArrayList;

public class BookDTO {
    public String isbn;
    public String title;
    public String author;
    public ArrayList<Integer> categories;

    public String getIsbn(){
        return isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public ArrayList<Integer> getCategories(){
        return categories;
    }

    public void setCategories(ArrayList<Integer> categories){
        this.categories = categories;
    }
}
