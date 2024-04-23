package com.uoi.softeng.app.services;

import com.uoi.softeng.app.dto.BookDTO;
import com.uoi.softeng.app.model.Author;
import com.uoi.softeng.app.model.Book;
import com.uoi.softeng.app.model.Category;
import com.uoi.softeng.app.model.User;
import com.uoi.softeng.app.repository.AuthorRepository;
import com.uoi.softeng.app.repository.BookRepository;
import com.uoi.softeng.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookService implements IBookService{
    @Autowired
    BookRepository bookRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    IAuthorService authorService;

    @Autowired
    ICategoryService categoryService;

    @Override
    public List<Book> getAllBooks(){
        return (List<Book>) bookRepo.findAll();
    }

    @Override
    public List<User> getAllOwners(){
        return null;
    }

    @Override
    public void addOwner(User user){

    }

    @Override
    public void addBook(BookDTO bookDTO){
        Book book = this.getBookByISBN(bookDTO.isbn);
        List<Category> categories = new ArrayList<>();

        if(book == null){
            Book newBook = new Book(bookDTO);

            if(!authorService.exists(bookDTO.author)){
                authorService.addAuthorByName(bookDTO.author);
            }

            newBook.setAuthor(authorService.getAuthorByName(bookDTO.author));

            for(String cat : bookDTO.categories){
                Category category = new Category(cat);
                category.addBook(newBook);
                categoryService.addCategory(category);
                categories.add(category);
            }

            newBook.setCategories(categories);

            bookRepo.save(newBook);
        } else {
            book.increaseQuantity();
            bookRepo.save(book);
        }
    }

    @Override
    public void addBook(Book book){
        Book existing = this.getBookByISBN(book.getIsbn());
        if(existing == null){
            if(!authorService.exists(book.getAuthor().getName())){
                authorService.addAuthorByName(book.getAuthor().getName());
            }
            book.setAuthor(authorService.getAuthorByName(book.getAuthor().getName()));
            bookRepo.save(book);
        } else {
            existing.increaseQuantity();
            bookRepo.save(existing);
        }
    }

    @Override
    public Book getBookByISBN(Integer isbn){
        return bookRepo.findBookByIsbn(isbn);
    }

    @Override
    public void updateBookById(String id, BookDTO bookDTO){
        Optional<Book> book = bookRepo.findById(id);

        updateBook(book.get(), bookDTO);
    }

    @Override
    public void updateBookByISBN(Integer isbn, BookDTO bookDTO){
        Book book = bookRepo.findBookByIsbn(isbn);

        updateBook(book, bookDTO);
    }

    @Override
    public void updateBookByTitle(String name, BookDTO bookDTO){
        Book book = bookRepo.findBookByTitle(bookDTO.title);

        updateBook(book, bookDTO);
    }

    @Override
    public void deleteBookByISBN(Integer isbn){
        Book book = bookRepo.findBookByIsbn(isbn);

        if(book != null){
            bookRepo.delete(book);
        } else {
            throw new RuntimeException("Book does not exist");
        }
    }

    @Override
    public void deleteBook(Book book){
        bookRepo.delete(book);
    }

    @Override
    public void updateBook(Book book){
//        Book temp = bookRepo.findBookByIsbn(book.getIsbn());
//
//        if(temp == null){
//            throw new RuntimeException("Book does not exist");
//        } else if(!temp.getTitle().equals(book.getTitle())){
//            throw new RuntimeException("Book title does not match");
//        } else if(!temp.getAuthor().getName().equals(book.getAuthor().getName())){
//            throw new RuntimeException("Author does not match");
//        } else {
////            book.setId(temp.getId());
//            temp.setAuthor(authorService.getAuthorByName(book.getAuthor().getName()));
//            bookRepo.save(temp);
//        }
        bookRepo.save(book);
    }

    // Prepei prwta na broume to biblio sthn db kai meta na to kanoume update
    private void updateBook(Book book, BookDTO bookDTO){
//        if(book != null){
//            if(bookDTO.isbn != null){
//                book.setIsbn(bookDTO.isbn);
//            }
//            if(bookDTO.title != null){
//                book.setTitle(bookDTO.title);
//            }
//            if(bookDTO.quantity != null){
//                book.setQuantity(bookDTO.quantity);
//            }
//            if(bookDTO.author != null){
//                book.setAuthor(authorService.getAuthorByName(bookDTO.author));
//            }
//            if(!bookDTO.users.isEmpty()){
//                for(User user : bookDTO.users){
//                    if(!book.getUsers().contains(user)){
//                        book.getUsers().add(user);
//                    }
//                }
//            }
//            if(!bookDTO.categories.isEmpty()){
//                for(Category cat : bookDTO.categories){
//                    if(!book.getCategories().contains(cat)){
//                        book.getCategories().add(cat);
//                    }
//                }
//            }
//            bookRepo.save(book);
//        }
    }
}
