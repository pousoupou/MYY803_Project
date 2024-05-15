package com.uoi.softeng.app.mappers;

import com.uoi.softeng.app.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookCategoryMapper extends JpaRepository<BookCategory, String> {

        List<BookCategory> findByName(String name);
}
