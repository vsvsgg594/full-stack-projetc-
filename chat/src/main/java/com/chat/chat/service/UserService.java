package com.chat.chat.service;
import java.util.List;
import com.chat.chat.model.*;

public interface UserService {
    public List<User> getAllUser();
    public User getUserById(Integer userId) throws Exception;
    public User registerUser(User user);
    public User updateUser(User user,Integer UserId) throws Exception;
    public String deleteUserById(Integer userId) throws Exception; 
    public User followUser(Integer id1,Integer id2);
    public List<User> searchUser(String query);
    // public User findByEmail(String email);
}
