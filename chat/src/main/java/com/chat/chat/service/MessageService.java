package com.chat.chat.service;

import com.chat.chat.model.Message;
import com.chat.chat.model.User;
import java.util.List;

public interface MessageService {
    public Message createMessage(User user,Integer chatId,Message message) throws Exception;
    public List<Message> findChatMessages(Integer chatId) throws Exception;
}
