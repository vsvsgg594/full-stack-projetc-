package com.chat.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.chat.service.ChatService;
import com.chat.chat.service.UserService;
import com.chat.chat.ChatData.CreateChat;
import com.chat.chat.model.Chat;
import com.chat.chat.model.User;

import java.util.List;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;
    
    @PostMapping("/chats/create")
    public Chat createChat(@RequestBody CreateChat che){
        Chat chat=chatService.createChat(che.getUser1(),che.getUser2());


        
        return chat;
    }

    @GetMapping("/chats/user/{userId}")
    public List<Chat> findUsersChat(@PathVariable Integer userId) throws Exception{
        User user=userService.getUserById(userId);
        List<Chat> list=chatService.findUsersChat(user.getId());
        return list;

    }

    @GetMapping("/chats/chat/{chatId}")
    public Chat findChatById(@PathVariable Integer chatId) throws Exception{
        Chat chat=chatService.findChatById(chatId);
        return chat;

    }
    
}
