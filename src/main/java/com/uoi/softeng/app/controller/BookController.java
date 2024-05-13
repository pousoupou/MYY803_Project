package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.entity.BookDTO;
import com.uoi.softeng.app.model.Book;
import com.uoi.softeng.app.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    public @ResponseBody Book getBookByIsbn(@PathVariable("isbn") Integer isbn){
        Book book = iBookService.getBookByISBN(isbn);

        return iBookService.getBookByISBN(isbn);
    }

    @GetMapping("/get")
    public @ResponseBody List<Book> getAllBooks(){
        return iBookService.getAllBooks();
    }

//
//    @GetMapping("/add")
//    public String addBookForm(Model model) {
//        model.addAttribute("book", new BookDTO());
//
//        return "addBook";
//    }

    @PostMapping("/add")
    public @ResponseBody String addBook(@RequestBody BookDTO bookDTO){
        iBookService.addBook(bookDTO);

        return "ADDED";
    }

    @DeleteMapping("/delete/{isbn}")
    public @ResponseBody String deleteBookByIsbn(@PathVariable("isbn") Integer isbn){
        Book book = iBookService.getBookByISBN(isbn);
        if(book.decreaseQuantity() <= 0){
            iBookService.deleteBook(book);
        }

        return "DELETED";
    }
}
