package com.uoi.softeng.app.mappers;

import com.uoi.softeng.app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookMapper extends JpaRepository<Book, String> {


    List<Book> findByTitle(String title);
    List<Book> findByTitleContaining(String title);


}
