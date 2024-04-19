package com.uoi.softeng.app.services;

import com.uoi.softeng.app.model.Category;
import com.uoi.softeng.app.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    CategoryRepository catRepo;

    @Override
    public List<Category> getAllCategories(){
        return (List<Category>) catRepo.findAll();
    }

    @Override
    public Category getCategoryByName(String name){
        return catRepo.findByCategoryName(name);
    }

    @Override
    public void addCategory(Category category){
        Category existingCat = catRepo.findByCategoryName(category.getCategoryName());
        if(existingCat == null){
            catRepo.save(category);
        } else {
            throw new RuntimeException("Category already exists");
        }
    }

    @Override
    public void addCategory(String categoryName){
        if(catRepo.findByCategoryName(categoryName) == null){
            Category category = new Category(categoryName);
            catRepo.save(category);
        } else {
            throw new RuntimeException("Category already exists");
        }
    }
}
