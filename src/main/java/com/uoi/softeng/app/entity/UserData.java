package com.uoi.softeng.app.entity;

import com.uoi.softeng.app.model.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserData {
    public String name;
    public String surname;
    public String email;
    public String password;
    public String address;
    public Integer zipcode;
    public List<Book> ownedBooks;
    public List<Category> favouriteCategories;
    public List<Author> favouriteAuthors;
    public List<Request> requests;



    public UserData(){
    }

    public UserData(String name , String surname , String email , String password , String address , Integer zipcode , List<Book> ownedBooks , List<Category> favouriteCategories , List<Author> favouriteAuthors , List<Request> requests){
        super();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.zipcode = zipcode;
        this.ownedBooks = ownedBooks;
        this.favouriteCategories = favouriteCategories;
        this.favouriteAuthors = favouriteAuthors;
        this.requests = requests;
    }


    @Override
    public String toString() {
        return "UserData [name=" + name + ", email=" + email + ", " +
                          "password=" + password + " , address=" + address + " , " +
                          "zipcode=" + zipcode + " , ownedBooks=" + ownedBooks + " , favouriteCategories=" + favouriteCategories + " , favouriteAuthors=" + favouriteAuthors + " , requests=" + requests
                + "]";
    }



























}
