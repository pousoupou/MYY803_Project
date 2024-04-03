package com.uoi.softeng.app.repository;

import com.uoi.softeng.app.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, String> {
    Author findByName(String name);
}
