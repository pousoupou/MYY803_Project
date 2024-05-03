package com.uoi.softeng.app.controller;


import com.uoi.softeng.app.dto.BookDTO;
import com.uoi.softeng.app.model.Book;

import com.uoi.softeng.app.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping("/get/{isbn}")
    public String getBookByIsbn(@PathVariable("isbn") Integer isbn, Model model){
        Book book = iBookService.getBookByISBN(isbn);
        model.addAttribute("book" , book);

        return "bookDetails";
    }

    @GetMapping("/get")
    public String getAllBooks(Model model){
        List<Book> books = iBookService.getAllBooks();
        model.addAttribute("books", books);

        return "bookList";
    }


    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new BookDTO());

        return "addBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute BookDTO bookDTO){
        iBookService.addBook(bookDTO);

        return "redirect:/book/get";
    }

    @GetMapping("/delete/{isbn}")
    public String deleteBookByIsbn(@PathVariable("isbn") Integer isbn){
        Book book = iBookService.getBookByISBN(isbn);
        if(book.decreaseQuantity() <= 0){
            iBookService.deleteBook(book);
        }

        return "redirect:/book/get";
    }
}
