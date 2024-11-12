package com.chat.chat.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.chat.model.Chat;
import com.chat.chat.model.User;
import com.chat.chat.repository.ChatRepository;

@Service
public class ChatServiceImplematation  implements ChatService{
    
    @Autowired
    private ChatRepository chatRepository;


    @Override
    public Chat createChat(User user1, User user2) {
        Chat isExit=chatRepository.findChatByUserId(user1,user2);
        if(isExit!=null){
            return isExit;
        }
        Chat chat=new Chat();
        chat.getUser().add(user2);
        chat.getUser().add(user1);
        chat.setTimestamp(LocalDateTime.now());
         

        return chatRepository.save(chat);
    }

    @Override
    public Chat findChatById(Integer chatId) throws Exception {
       Optional<Chat> opt=chatRepository.findById(chatId);
       if(opt.isEmpty()){
          throw new Exception("chat is not present");

       }
       return opt.get();
    }

    @Override
    public List<Chat> findUsersChat(Integer userId) {
         return chatRepository.findByUserId(userId);
    }
    
    
}
