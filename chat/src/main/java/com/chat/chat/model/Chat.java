package com.chat.chat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
public class Chat {
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String chat_name;
    @ManyToMany
    private List<User> user=new ArrayList<>(); 
    @OneToMany(mappedBy = "chat")
    private List<Message> messages=new ArrayList<>();
    private LocalDateTime timestamp;
    public Chat() {
    }
    public Chat(String chat_name, List<User> user, List<Message> messages, LocalDateTime timestamp) {
        this.chat_name = chat_name;
        this.user = user;
        this.messages = messages;
        this.timestamp = timestamp;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getChat_name() {
        return chat_name;
    }
    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }
    public List<User> getUser() {
        return user;
    }
    public void setUser(List<User> user) {
        this.user = user;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    



    
}
