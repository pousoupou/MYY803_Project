package com.uoi.softeng.app.dto;

import com.uoi.softeng.app.model.Author;
import com.uoi.softeng.app.model.Category;
import com.uoi.softeng.app.model.User;

import java.util.List;

public class BookDTO {
    public Integer isbn;
    public String title;
    public Integer quantity;
    public String author;
    public List<User> users;
    public List<Category> categories;
}
