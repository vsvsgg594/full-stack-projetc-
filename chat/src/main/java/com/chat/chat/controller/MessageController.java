package com.chat.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.chat.model.Message;
import com.chat.chat.model.User;
import com.chat.chat.service.MessageService;
import com.chat.chat.service.UserService;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/message/create/{chatId}")
    public Message createMessages(@PathVariable Integer userid ,@PathVariable Integer chatId,@RequestBody Message message) throws Exception{
        User user=userService.getUserById(userid);

        Message newMessage=messageService.createMessage(user, chatId, message);
        return newMessage;
        
    }


    @GetMapping("/message/chat/find/{chatId}")
    public List<Message> findChatsMessages(@PathVariable Integer chatId) throws Exception{
        List<Message> messages=messageService.findChatMessages(chatId);
        return messages;
    }
}
