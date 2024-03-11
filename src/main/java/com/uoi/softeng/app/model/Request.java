package com.uoi.softeng.app.model;

import com.uoi.softeng.app.dto.RequestDTO;
import jakarta.persistence.*;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer sellerID;
    private Integer buyerID;
    private Integer bookID;
    private String type;        // Either REQUEST, or OFFER

    public Request(){}

    public Request(RequestDTO requestDTO){
        this.sellerID = requestDTO.sellerID;
        this.buyerID = requestDTO.buyerID;
        this.bookID = requestDTO.bookID;
        this.type = requestDTO.type;
    }

    public Integer getSellerID(){
        return sellerID;
    }

    public Integer getBuyerID(){
        return buyerID;
    }

    public Integer getBookID(){
        return bookID;
    }

    public String getType(){
        return type;
    }

    public void setSeller(Integer sellerID){
        this.sellerID = sellerID;
    }

    public void setBuyer(Integer buyerID){
        this.buyerID = buyerID;
    }

    public void setBook(Integer bookID){
        this.bookID = bookID;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }
}
