package com.uoi.softeng.app.services;

import com.uoi.softeng.app.mappers.BookAuthorMapper;
import com.uoi.softeng.app.mappers.BookCategoryMapper;
import com.uoi.softeng.app.mappers.BookMapper;
import com.uoi.softeng.app.mappers.UserProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileImpl implements UserProfileService{



    @Autowired
    private UserProfileMapper userProfileMapper;

    @Autowired
    private BookAuthorMapper bookAuthorMapper;

    @Autowired
    private BookCategoryMapper bookCategoriesMapper;

    @Autowired
    private BookMapper  bookMapper;


    @Override
    public <UserProfileFormData> UserProfileFormData retrieve(String username) {
        return null;
    }

    @Override
    public <UserProfileFormData> void save(UserProfileFormData userProfileFormData) {

    }

    @Override
    public <BookFormData> List<BookFormData> retrieveBookOffers(String username) {
        return List.of();
    }

    @Override
    public <BookFormData> void addBookOffer(String username, BookFormData bookFormData) {

    }

    @Override
    public <SearchFormData, BookFormData> List<BookFormData> searchBooks(SearchFormData searchFormData) {
        return List.of();
    }

    @Override
    public <RecommendationsFormData, BookFormData> List<BookFormData> recommendedBooks(String username, RecommendationsFormData recomFormData) {
        return List.of();
    }

    @Override
    public void requestBook(int bookId, String username) {

    }

    @Override
    public <BookFormData> List<BookFormData> retrieveBookRequests(String username) {
        return List.of();
    }

    @Override
    public <UserProfileFormData> List<UserProfileFormData> retrieveRequestingUsers(int bookId) {
        return List.of();
    }

    @Override
    public void deleteBookOffer(String username, int bookId) {

    }

    @Override
    public void deleteBookRequest(String username, int bookId) {

    }
}
