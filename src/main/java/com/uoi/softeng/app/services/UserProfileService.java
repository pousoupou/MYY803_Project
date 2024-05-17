package com.uoi.softeng.app.services;

import java.util.List;

public interface UserProfileService {

    <UserProfileFormData> UserProfileFormData retrieve(String username);
    <UserProfileFormData> void save(UserProfileFormData userProfileFormData);
    <BookFormData> List<BookFormData> retrieveBookOffers(String username);
    <BookFormData> void addBookOffer(String username, BookFormData bookFormData);
    <SearchFormData, BookFormData> List<BookFormData> searchBooks(SearchFormData searchFormData);
    <RecommendationsFormData, BookFormData> List<BookFormData> recommendedBooks(String username , RecommendationsFormData recomFormData);
    void requestBook(int bookId, String username);
    <BookFormData> List<BookFormData> retrieveBookRequests(String username);
    <UserProfileFormData> List<UserProfileFormData> retrieveRequestingUsers(int bookId);
    void deleteBookOffer(String username , int bookId);
    void deleteBookRequest(String username , int bookId);
}
