package com.chat.chat.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chat.chat.model.User;
import com.chat.chat.service.UserService;

@RestController
public class UserController {
    @Autowired  
    private UserService userService;

    @GetMapping("/users")   
    public List<User> getUser(){
    
       List<User> user = userService.getAllUser();
       return user;
    }
    
    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") Integer Id) throws Exception{
           User user=userService.getUserById(Id);
           if(user==null){
            throw new Exception("User not exit with Id"+Id);
           }

           return user;

    }

    @PostMapping("/posts")
    public User createUser(@RequestBody User user){
      User user1= userService.registerUser(user);
      return user1;


    }
     
    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User user,@PathVariable Integer userId) throws Exception{
     User user1=userService.updateUser(user,userId);

     return user1;
    
    
        

    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable("userId") Integer id) throws Exception{
           String str=userService.deleteUserById(id);
           if(str.isEmpty()){
            throw new Exception("user not exit with id "+ id);
           }
          
           return str;
        }
        
        @GetMapping("/users/search")
        public List<User> searchUser(@RequestParam("query") String query){
            List<User> list=userService.searchUser(query);
            return list; 
        }

        @PutMapping("/users/follew/{userId1}/{userId2}")
        public User follwerHandeler(@PathVariable Integer userId1,@PathVariable Integer userId2){
            User user=userService.followUser(userId1, userId2);

            return user;
        }   
}