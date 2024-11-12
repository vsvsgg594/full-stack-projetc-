package com.chat.chat.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.chat.chat.model.User;
import com.chat.chat.model.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Integer>{

    public List<Chat> findByUserId(Integer userId);
    
    @Query("select c from Chat c where :user1 Member of c.user And :user2  Member of c.user ")
    public Chat findChatByUserId(@Param("user1") User user1,@Param("user2") User user2);

    
}
