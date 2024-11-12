package com.chat.chat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
public class Comment{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String content;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<User> liked=new ArrayList<>();
    private LocalDate craetedAt;
    public Comment() {
    }
    public Comment(Integer id, String content, User user, List<User> liked, LocalDate craetedAt) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.liked = liked;
        this.craetedAt = craetedAt;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public List<User> getLiked() {
        return liked;
    }
    public void setLiked(List<User> liked) {
        this.liked = liked;
    }
    public LocalDate getCraetedAt() {
        return craetedAt;
    }
    public void setCraetedAt(LocalDate craetedAt) {
        this.craetedAt = craetedAt;
    }
    

    
}