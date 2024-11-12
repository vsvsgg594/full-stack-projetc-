package com.chat.chat.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chat.chat.model.Reels;

@Repository
public interface reelsRepository extends JpaRepository<Reels,Integer>{

    public List<Reels> findByUserId(Integer userId);
    
}
