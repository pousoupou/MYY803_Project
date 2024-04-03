package com.uoi.softeng.app.repository;

import com.uoi.softeng.app.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends CrudRepository<Book, String> {
//    @Query(value = "SELECT * FROM book WHERE isbn = :isbn LIMIT 1", nativeQuery = true)
    Book findBookByIsbn(@Param("isbn") Integer isbn);

    Book findBookByTitle(String title);
}
