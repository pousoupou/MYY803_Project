package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.entity.BookDTO;
import com.uoi.softeng.app.model.Book;
import com.uoi.softeng.app.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class BookController {
    @Autowired
    private IBookService iBookService;


    @RequestMapping("/offer-book")
    public String showOfferBookForm(Model model) {
        model.addAttribute("bookDTO", new BookDTO());
        return "offerBook"; // This is the name of the Thymeleaf template for offering a book
    }


}
