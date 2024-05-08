package com.uoi.softeng.app.dto;

import com.uoi.softeng.app.model.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    public String name;
    public String surname;
    public String email;
    public String password;
    public String address;
    public Integer zipcode;
    public Role role;
    public List<Book> ownedBooks;
    public List<Category> favouriteCategories;
    public List<Author> favouriteAuthors;
    public List<Request> requests;
}
