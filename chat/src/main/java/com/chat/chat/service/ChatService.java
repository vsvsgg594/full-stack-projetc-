package com.chat.chat.service;
import com.chat.chat.model.Chat;
import com.chat.chat.model.User;
import java.util.List;
public interface ChatService {

    public Chat createChat(User user1,User user2);

    public Chat findChatById(Integer chatId) throws Exception;

    public List<Chat> findUsersChat(Integer userId);
    
    
}
