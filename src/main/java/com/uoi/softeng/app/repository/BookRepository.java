package com.uoi.softeng.app.repository;

import com.uoi.softeng.app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, String> {


    Book findBookByTitle(String title);
}
