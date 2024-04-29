package com.uoi.softeng.app.services;

import com.uoi.softeng.app.dto.AuthorDTO;
import com.uoi.softeng.app.model.Author;
import com.uoi.softeng.app.model.Book;
import com.uoi.softeng.app.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class AuthorService implements IAuthorService{
    @Autowired
    AuthorRepository authorRepo;

    @Override
    public boolean exists(String name){
        return authorRepo.findByName(name) != null;
    }

    @Override
    public Author getAuthorByName(String name){
        name = WordUtils.capitalizeFully(name);

        if(this.exists(name)){
            return authorRepo.findByName(name);
        }
        return null;
    }

    @Override
    public void addAuthor(AuthorDTO authorDTO){
        authorDTO.name = WordUtils.capitalizeFully(authorDTO.name);
        Author author = authorRepo.findByName(authorDTO.name);

        if(author == null){
            Author newAuthor = new Author(authorDTO);
            authorRepo.save(newAuthor);
        }
    }

    @Override
    public void addAuthorByName(String name){
        name = WordUtils.capitalizeFully(name);
        Author existing = authorRepo.findByName(name);

        if(existing == null){
            Author author = new Author(name);
            authorRepo.save(author);
        }
    }

    @Override
    public void updateAuthor(String id, AuthorDTO authorDTO){
        Optional<Author> existing = authorRepo.findById(id);

        if(existing.isPresent()){
            if(authorDTO.name != null){
                existing.get().setName(authorDTO.name);
            }
            if(authorDTO.books != null){
                for(Book book : authorDTO.books){
                    if(!existing.get().getBooks().contains(book)){
                        existing.get().getBooks().add(book);
                    }
                }
            }
            if(authorDTO.user != null){
                existing.get().setUser(authorDTO.user);
            }
        }
    }
}
