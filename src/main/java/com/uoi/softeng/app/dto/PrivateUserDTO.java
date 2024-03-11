package com.uoi.softeng.app.dto;

import com.uoi.softeng.app.model.User;

public class PrivateUserDTO {
    private String name;
    private String surname;
    private String email;
    private String address;
    private Integer zipcode;

    public PrivateUserDTO(){}

    public PrivateUserDTO(User user){
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.zipcode = user.getZipcode();
    }

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
}
