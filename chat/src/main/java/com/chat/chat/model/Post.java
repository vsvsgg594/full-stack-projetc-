package com.chat.chat.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name="Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "caption")
    private String caption;
    @Column(name="image")
    private String image;
    @Column(name = "video")
    private String video;
    @Column(name="createdPostDate")
    private LocalDateTime createdAt;
    @ManyToOne
    private User user;
    private List<String> commnents=new ArrayList<>();
    @OneToMany 
    private List<User> liked=new ArrayList<>();
    @OneToMany
    
    private List<Comment> comments=new ArrayList<>();


    public Post() {
    }
    
  
    

    

    


    public Post(int id, String caption, String image, String video, LocalDateTime createdAt, User user,
            List<String> commnents, List<User> liked, List<Comment> comments) {
        this.id = id;
        this.caption = caption;
        this.image = image;
        this.video = video;
        this.createdAt = createdAt;
        this.user = user;
        this.commnents = commnents;
        this.liked = liked;
        this.comments = comments;
    }









    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCaption() {
        return caption;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getVideo() {
        return video;
    }
    public void setVideo(String video) {
        this.video = video;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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




    public List<String> getCommnents() {
        return commnents;
    }




    public void setCommnents(List<String> commnents) {
        this.commnents = commnents;
    }









    public List<Comment> getComments() {
        return comments;
    }









    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    


    
}
