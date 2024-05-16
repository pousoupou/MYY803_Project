package com.uoi.softeng.app.services;


import com.uoi.softeng.app.model.Book;


import com.uoi.softeng.app.repository.BookRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class BookService implements IBookService{


    private final BookRepository bookRepo;

    @Autowired
    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }



    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepo.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepo.findById(String.valueOf(id)).orElse(null);
    }

    @Override
    public Book save(Book book) {
        return bookRepo.save(book);
    }


    @Override
    public void deleteBook(Book book){
        bookRepo.delete(book);
    }




}
