package com.uoi.softeng.app.model;

import com.uoi.softeng.app.dto.UserDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String surname;
    private String email;
    private String password;
    private String address;
    private Integer zipcode;

    @ElementCollection
    private List<Integer> ownedBooks;

    @ElementCollection
    private List<Integer> favouriteCategories;

    @ElementCollection
    private List<Integer> favouriteAuthors;

    @ElementCollection
    private List<Integer> requests;

    public User(){}

    public User(UserDTO userDTO){
        this.name = userDTO.name;
        this.surname = userDTO.surname;
        this.email = userDTO.email;
        this.address = userDTO.address;
        this.zipcode = userDTO.zipcode;
        this.ownedBooks = userDTO.ownedBooks;
        this.favouriteCategories = userDTO.favouriteCategories;
        this.favouriteAuthors = userDTO.favouriteAuthors;
        this.requests = userDTO.requests;
    }

    public void updateUserData(UserDTO userDTO){
        this.name = userDTO.name;
        this.surname = userDTO.surname;
        this.email = userDTO.email;
        this.address = userDTO.address;
        this.zipcode = userDTO.zipcode;
        this.ownedBooks = userDTO.ownedBooks;
        this.favouriteCategories = userDTO.favouriteCategories;
        this.favouriteAuthors = userDTO.favouriteAuthors;
        this.requests = userDTO.requests;
    }

    public User omitPrivateData(){
        User privateUser = new User();

        privateUser.name = this.name;
        privateUser.surname = this.surname;
        privateUser.email = this.email;
        privateUser.address = this.address;
        privateUser.zipcode = this.zipcode;

        return privateUser;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getAddress(){
        return address;
    }

    public Integer getZipcode(){
        return zipcode;
    }

    public List<Integer> getOwnedBooks(){
        return ownedBooks;
    }

    public List<Integer> getFavouriteCategories(){
        return favouriteCategories;
    }

    public List<Integer> getFavouriteAuthors(){
        return favouriteAuthors;
    }

    public List<Integer> getRequests(){
        return requests;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setZipcode(Integer zipcode){
        this.zipcode = zipcode;
    }

    public void setOwnedBooks(List<Integer> ownedBooks){
        this.ownedBooks = ownedBooks;
    }

    public void setFavouriteCategories(List<Integer> favouriteCategories){
        this.favouriteCategories = favouriteCategories;
    }

    public void setFavouriteAuthors(List<Integer> favouriteAuthors){
        this.favouriteAuthors = favouriteAuthors;
    }

    public void setRequests(List<Integer> requests){
        this.requests = requests;
    }
}
