//package com.uoi.softeng.app.controller;
//
//import com.uoi.softeng.app.model.Book;
//import com.uoi.softeng.app.services.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("/home")
//public class HomeController {
//    @Autowired
//    BookService bookService;
//
//    @RequestMapping("")
//    public String homePage(Model model){
//        List<Book> allBooks = bookService.getAllBooks();
//        model.addAttribute("allBooks", allBooks);
//
//        return "home";
//    }
//}
