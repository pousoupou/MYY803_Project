package com.uoi.softeng.app.model;

import com.uoi.softeng.app.dto.AuthorDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.text.WordUtils;

import java.util.List;

@Getter
@Setter
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public Author(){}

    public Author(AuthorDTO authorDTO){
        this.name = WordUtils.capitalizeFully(authorDTO.name);
        this.books = authorDTO.books;
        this.user = authorDTO.user;
    }

    public Author(String name){
        this.name = WordUtils.capitalizeFully(name);
    }
}
