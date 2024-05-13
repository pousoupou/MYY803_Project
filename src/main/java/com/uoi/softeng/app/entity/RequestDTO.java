package com.uoi.softeng.app.entity;

import com.uoi.softeng.app.model.Book;
import com.uoi.softeng.app.model.User;

public class RequestDTO {
    public User requester;
    public User recipient;
    public Book book;
    public String type;
}
