package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.dto.BookDTO;
import com.uoi.softeng.app.model.Book;
import com.uoi.softeng.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepo;

    @GetMapping("/get/{id}")
    public @ResponseBody Book getBookById(@PathVariable("id") Integer id){
        return bookRepo.findById(id).get();
    }

    @GetMapping("/get")
    public @ResponseBody List<Book> getAllBooks(){
        return (List<Book>) bookRepo.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody String addBook(@RequestBody BookDTO bookDTO){
        Book book = new Book(bookDTO);

        bookRepo.save(book);

        return "ADDED";
    }

    @PutMapping("/update/{id}")
    public @ResponseBody String updateBook(@PathVariable("id") Integer id, @RequestBody BookDTO bookDTO){
        Book book = bookRepo.findById(id).get();
        book.updateData(bookDTO);
        bookRepo.save(book);

        return "UPDATED";
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody String deleteBook(@PathVariable("id") Integer id){
        bookRepo.deleteById(id);

        return "DELETED";
    }
}
