package com.uoi.softeng.app.services;

import com.uoi.softeng.app.entity.BookDTO;
import com.uoi.softeng.app.model.Book;
import com.uoi.softeng.app.model.User;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();

    List<User> getAllOwners();

    void addOwner(User user);

    void addBook(BookDTO bookDTO);

    void addBook(Book book);

    Book getBookByISBN(Integer isbn);

    void updateBook(Book book);

    void updateBookById(String id, BookDTO bookDTO);

    void updateBookByISBN(Integer isbn, BookDTO bookDTO);

    void updateBookByTitle(String name, BookDTO bookDTO);

    void deleteBookByISBN(Integer isbn);

    void deleteBook(Book book);
}
