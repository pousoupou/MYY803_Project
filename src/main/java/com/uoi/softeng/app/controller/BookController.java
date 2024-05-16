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



}
