package com.uoi.softeng.app.model;

import com.uoi.softeng.app.dto.BookDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.text.WordUtils;
import org.hibernate.action.internal.OrphanRemovalAction;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Integer isbn;

    private String title;

    private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Category> categories;

    @ManyToMany(mappedBy = "ownedBooks", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<User> users = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "request_id")
    private Request request;

    public Book(){
        this.quantity = 1;
        this.users = new ArrayList<>();
    }

    public Book(Book book){
        this.id = book.id;
        this.isbn = book.isbn;
        this.title = WordUtils.capitalizeFully(book.title);
        this.quantity = book.quantity;
        this.author = book.author;
        this.categories = book.categories;
        if(book.users == null || book.users.isEmpty()){
            this.users = new ArrayList<>();
        } else {
            this.users = book.users;
        }
        this.request = book.request;
    }

    public Book(BookDTO bookDTO){
        this.isbn = bookDTO.isbn;
        this.title = WordUtils.capitalizeFully(bookDTO.title);
        this.quantity = 1;
        this.categories = bookDTO.categories;
    }

    public void updateData(BookDTO bookDTO){
        this.isbn = bookDTO.isbn;
        this.title = WordUtils.capitalizeFully(bookDTO.title);
        this.quantity = bookDTO.quantity;
        this.categories = bookDTO.categories;
    }

    public void updateData(Book book){
//        this.isbn = book.getIsbn();
//        this.title = book.getTitle();
        this.quantity = book.getQuantity();
//        this.categories = book.getCategories();
    }

    public Integer increaseQuantity(){
        return this.quantity ++;
    }

    public Integer decreaseQuantity(){
        return this.quantity --;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    @Override
    public boolean equals(Object o) {
        boolean ret = false;

        if(o instanceof Book){
            Book book = (Book) o;
            ret = this.isbn.equals(book.isbn);
        }
        return ret;
    }

    @Override
    public int hashCode(){
        return this.isbn.hashCode();
    }
}
