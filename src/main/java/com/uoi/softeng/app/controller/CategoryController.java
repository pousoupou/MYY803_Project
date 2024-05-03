package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.model.Category;
import com.uoi.softeng.app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cat")
public class CategoryController {

    @Autowired
    private CategoryRepository catRepo;

    @GetMapping("/add")
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category){
        catRepo.save(category);
        return "redirect:/cat/add";
    }

}
