package com.chat.chat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chat.chat.model.Post;

@Repository
public interface postRepository extends JpaRepository<Post,Integer> {
    @Query("select p from Post p where p.user.id=:userId")
    List<Post> findPostByUserId(Integer userId);
} 
