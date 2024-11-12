package com.chat.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.chat.chat.model.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story,Integer> {
    public List<Story> findByUserId(Integer userId);
    
}
