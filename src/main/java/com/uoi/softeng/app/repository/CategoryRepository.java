package com.uoi.softeng.app.repository;

import com.uoi.softeng.app.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
