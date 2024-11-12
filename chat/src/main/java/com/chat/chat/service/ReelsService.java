package com.chat.chat.service;

import com.chat.chat.model.Reels;
import com.chat.chat.model.User;
import java.util.List;

public interface ReelsService {

    public Reels createReels(Reels reels,User user);
    public List<Reels> findAllReesl();

    public List<Reels> findUsersReels(Integer userId) throws Exception;
    
}
