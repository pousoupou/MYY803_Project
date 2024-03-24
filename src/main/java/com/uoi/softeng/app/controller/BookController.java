package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.dto.BookDTO;
import com.uoi.softeng.app.model.Book;
import com.uoi.softeng.app.repository.BookRepository;
import com.uoi.softeng.app.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping("/get/{isbn}")
    public @ResponseBody Book getBookByIsbn(@PathVariable("isbn") Integer isbn){
        return iBookService.getBookByISBN(isbn);
    }

    @GetMapping("/get")
    public @ResponseBody List<Book> getAllBooks(){
        return iBookService.getAllBooks();
    }

    @PostMapping("/add")
    public @ResponseBody String addBook(@RequestBody BookDTO bookDTO){
        iBookService.addBook(bookDTO);

        return "ADDED";
    }

//    @PutMapping("/update/{id}")
//    public @ResponseBody String updateBook(@PathVariable("id") Integer id, @RequestBody BookDTO bookDTO){
//        Book book = bookRepo.findById(id).get();
//        book.updateData(bookDTO);
//        bookRepo.save(book);
//
//        return "UPDATED";
//    }

    @DeleteMapping("/delete/{isbn}")
    public @ResponseBody String deleteBookByIsbn(@PathVariable("isbn") Integer isbn){
        Book book = iBookService.getBookByISBN(isbn);
        if(book.decreaseQuantity() <= 0){
            iBookService.deleteBook(book);
        }

        return "DELETED";
    }
}
