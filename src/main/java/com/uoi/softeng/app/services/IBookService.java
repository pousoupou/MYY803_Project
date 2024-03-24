package com.uoi.softeng.app.services;

import com.uoi.softeng.app.dto.BookDTO;
import com.uoi.softeng.app.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();

    void addBook(BookDTO book);

    Book getBookByISBN(Integer isbn);

    void deleteBookByISBN(Integer isbn);

    void deleteBook(Book book);
}
