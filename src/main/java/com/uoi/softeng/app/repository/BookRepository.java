package com.uoi.softeng.app.repository;

import com.uoi.softeng.app.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
