package com.uoi.softeng.app.dto;

import java.util.List;

public class UserDTO {
    public String name;
    public String surname;
    public String email;
    public String address;
    public Integer zipcode;
    public List<Integer> ownedBooks;
    public List<Integer> favouriteCategories;
    public List<Integer> favouriteAuthors;
    public List<Integer> requests;

    public UserDTO(){}

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public Integer getZipcode(){
        return zipcode;
    }

    public void setZipcode(Integer zipcode){
        this.zipcode = zipcode;
    }

    public List<Integer> getOwnedBooks(){
        return ownedBooks;
    }

    public void setOwnedBooks(List<Integer> ownedBooks){
        this.ownedBooks = ownedBooks;
    }

    public List<Integer> getFavouriteCategories(){
        return favouriteCategories;
    }

    public void setFavouriteCategories(List<Integer> favouriteCategories){
        this.favouriteCategories = favouriteCategories;
    }

    public List<Integer> getFavouriteAuthors(){
        return favouriteAuthors;
    }

    public void setFavouriteAuthors(List<Integer> favouriteAuthors){
        this.favouriteAuthors = favouriteAuthors;
    }

    public List<Integer> getRequests(){
        return requests;
    }

    public void setRequests(List<Integer> requests){
        this.requests = requests;
    }
}
