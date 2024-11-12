package com.chat.chat.repository;

import com.chat.chat.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface userRepository extends JpaRepository<User,Integer> {


    public User findUserById(Integer userId);
    @Query("select u from User u where u.firstName Like %:query% OR u.lastName LIKE %:query% OR u.email LIKE %:query%")
    public List<User> searchUser(@Param("query") String query);
    // @Query("select u from User where u.email=:email")
    // public User findByEmail(@Param("email")String email);
    
}
