package com.chat.chat.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="gender")
    private String genders;
    @Column(name="followers")
    private List<Integer> followers=new ArrayList<>();
    @Column(name="followings")
    private List<Integer> followings=new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    private List<Post> savePost=new ArrayList<>();

    public User(){

    }
    

   
   



    public User(int id, String firstName, String lastName, String email, String password, String genders,
            List<Integer> followers, List<Integer> followings, List<Post> savePost) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.genders = genders;
        this.followers = followers;
        this.followings = followings;
        this.savePost = savePost;
    }
    







    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public String getGenders() {
        return genders;
    }



    public void setGenders(String genders) {
        this.genders = genders;
    }



    public List<Integer> getFollowers() {
        return followers;
    }



    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }



    public List<Integer> getFollowings() {
        return followings;
    }



    public void setFollowings(List<Integer> followings) {
        this.followings = followings;
    }



    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
                + "]";
    }







    public List<Post> getSavePost() {
        return savePost;
    }







    public void setSavePost(List<Post> savePost) {
        this.savePost = savePost;
    }
    

}
