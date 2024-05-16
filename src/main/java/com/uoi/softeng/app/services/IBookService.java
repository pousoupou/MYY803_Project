package com.uoi.softeng.app.services;

import com.uoi.softeng.app.entity.BookDTO;
import com.uoi.softeng.app.model.Book;
import com.uoi.softeng.app.model.User;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(Long id);

    Book save(Book book);


    void deleteBook(Book book);
}
