package com.uoi.softeng.app.repository;

import com.uoi.softeng.app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, String> {
//    @Query(value = "SELECT * FROM book WHERE isbn = :isbn LIMIT 1", nativeQuery = true)

    Book findBookByTitle(String title);
}
