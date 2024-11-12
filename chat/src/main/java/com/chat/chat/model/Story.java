package com.chat.chat.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private User user;
    private String caption;
    private LocalDateTime timestap;
    public Story() {
    }
    public Story(Integer id, User user, String caption, LocalDateTime timestap) {
        this.id = id;
        this.user = user;
        this.caption = caption;
        this.timestap = timestap;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getCaption() {
        return caption;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }
    public LocalDateTime getTimestap() {
        return timestap;
    }
    public void setTimestap(LocalDateTime timestap) {
        this.timestap = timestap;
    }
    

    
}
