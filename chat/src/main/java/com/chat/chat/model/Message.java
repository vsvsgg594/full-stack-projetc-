package com.chat.chat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String conten;
    private String image;
    @ManyToOne
    private User user;
    @ManyToOne
    private Chat chat;
    public Message() {
    }
    public Message(Integer id, String conten, String image, User user, Chat chat) {
        this.id = id;
        this.conten = conten;
        this.image = image;
        this.user = user;
        this.chat = chat;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getConten() {
        return conten;
    }
    public void setConten(String conten) {
        this.conten = conten;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Chat getChat() {
        return chat;
    }
    public void setChat(Chat chat) {
        this.chat = chat;
    }
    
    
}
