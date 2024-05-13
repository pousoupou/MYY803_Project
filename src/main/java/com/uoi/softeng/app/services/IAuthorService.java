package com.uoi.softeng.app.services;

import com.uoi.softeng.app.entity.AuthorDTO;
import com.uoi.softeng.app.model.Author;

public interface IAuthorService {
    boolean exists(String name);

    Author getAuthorByName(String name);

    void addAuthor(AuthorDTO authorDTO);

    void addAuthorByName(String name);

    void updateAuthor(String id, AuthorDTO authorDTO);
}
