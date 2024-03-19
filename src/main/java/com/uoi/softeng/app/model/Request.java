package com.uoi.softeng.app.model;

import com.uoi.softeng.app.dto.RequestDTO;
import jakarta.persistence.*;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "requester_id")
    private User requester;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private User recipient;

    @OneToOne(mappedBy = "request")
    private Book book;

    private String type;        // Either REQUEST, or OFFER

    public Request(){}

    public Request(RequestDTO requestDTO){
        this.requester = requestDTO.requester;
        this.recipient = requestDTO.recipient;
        this.book = requestDTO.book;
        this.type = requestDTO.type;
    }

    public Integer getId(){
        return id;
    }

    public User getRequester(){
        return requester;
    }

    public User getRecipient(){
        return recipient;
    }

    public Book getBook(){
        return book;
    }

    public String getType(){
        return type;
    }
}
