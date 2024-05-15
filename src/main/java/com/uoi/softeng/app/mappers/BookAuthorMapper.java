package com.uoi.softeng.app.mappers;

import com.uoi.softeng.app.model.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookAuthorMapper extends JpaRepository<BookAuthor, String> {

        List<BookAuthor> findByName(String name);
}
