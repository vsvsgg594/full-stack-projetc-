package com.chat.chat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chat.chat.model.Comment;

@Repository
public interface commentsRepository extends JpaRepository<Comment,Integer> {

    
} 

