package com.chat.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.chat.model.Message;
import com.chat.chat.model.User;
import com.chat.chat.repository.MessageRepository;
import com.chat.chat.model.Chat;

@Service
public class MessageServiceImplemanation implements MessageService{
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ChatService chatService;


    @Override
    public Message createMessage(User user, Integer chatId, Message message) throws Exception {
        Chat chat=chatService.findChatById(chatId);

        Message newMessage=new Message();
        newMessage.setChat(chat);
        newMessage.setConten(message.getConten());
        newMessage.setImage(message.getImage());
        newMessage.setUser(user);

        return messageRepository.save(newMessage);

    }

    @Override
    public List<Message> findChatMessages(Integer chatId) throws Exception {
       Chat chat=chatService.findChatById(chatId);

       List<Message> messages=messageRepository.findChatsById(chatId);
       
       return messageRepository.findChatsById(chatId);
    }
    
}
