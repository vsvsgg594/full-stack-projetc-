package com.chat.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.chat.chat.model.Message;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {

    public List<Message> findChatsById(Integer chatId);
    
}
