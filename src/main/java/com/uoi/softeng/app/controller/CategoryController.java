package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.model.Category;
import com.uoi.softeng.app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cat")
public class CategoryController {

    @Autowired
    private CategoryRepository catRepo;

    @PostMapping("/add")
    public @ResponseBody String addCategory(@RequestBody String category) {
        Category cat = new Category(category);
        catRepo.save(cat);

        return "ADDED";
    }

}
