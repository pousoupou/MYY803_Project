package com.uoi.softeng.app.services;

import com.uoi.softeng.app.dto.BookDTO;
import com.uoi.softeng.app.model.Book;
import com.uoi.softeng.app.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookService implements IBookService{
    @Autowired
    BookRepository bookRepo;

    @Override
    public List<Book> getAllBooks(){
        return (List<Book>) bookRepo.findAll();
    }

    @Override
    public void addBook(BookDTO bookDTO){
        Book existing = this.getBookByISBN(bookDTO.isbn);

        if(existing == null){
            Book book = new Book(bookDTO);
            bookRepo.save(book);
        } else {
            existing.increaseQuantity();
            bookRepo.save(existing);
        }
    }

    @Override
    public Book getBookByISBN(Integer isbn){
        return bookRepo.findBookByIsbn(isbn);
    }

    @Override
    public void deleteBookByISBN(Integer isbn){
        Book book = bookRepo.findBookByIsbn(isbn);

        if(book != null){
            bookRepo.delete(book);
        } else {
            throw new RuntimeException("Book does not exist");
        }
    }

    @Override
    public void deleteBook(Book book){
        bookRepo.delete(book);
    }
}
