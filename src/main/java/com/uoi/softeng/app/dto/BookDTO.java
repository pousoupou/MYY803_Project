package com.uoi.softeng.app.dto;

import com.uoi.softeng.app.model.Author;
import com.uoi.softeng.app.model.Category;

import java.util.List;

public class BookDTO {
    public Integer isbn;
    public String title;
    public Author author;
    public List<Category> categories;
}
