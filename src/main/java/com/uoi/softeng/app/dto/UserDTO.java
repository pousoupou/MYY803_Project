package com.uoi.softeng.app.dto;

import com.uoi.softeng.app.model.Author;
import com.uoi.softeng.app.model.Book;
import com.uoi.softeng.app.model.Category;
import com.uoi.softeng.app.model.Request;

import java.util.List;

public class UserDTO {
    public String name;
    public String surname;
    public String email;
    public String password;
    public String address;
    //public Integer zipcode;
    //public List<Book> ownedBooks;
    public List<Category> favouriteCategories;
    //public List<Author> favouriteAuthors;
    public List<Request> requests;
}
