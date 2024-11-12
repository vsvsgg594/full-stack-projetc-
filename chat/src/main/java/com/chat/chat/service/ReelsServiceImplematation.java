package com.chat.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.chat.model.Reels;
import com.chat.chat.model.User;
import com.chat.chat.repository.reelsRepository;

@Service
public class ReelsServiceImplematation implements ReelsService{
    @Autowired
    private reelsRepository reelsRepo;
    
    @Autowired
    private UserService userService;

    @Override
    public Reels createReels(Reels reels, User user) {
       Reels createdReels=new Reels();
       createdReels.setId(reels.getId());
       createdReels.setTitle(reels.getTitle());
       createdReels.setUser(reels.getUser());
       createdReels.setVideo(reels.getVideo());
       Reels savereels=reelsRepo.save(createdReels);
       return savereels;
    }

    @Override
    public List<Reels> findAllReesl() {
       return reelsRepo.findAll();
    }

    @Override
    public List<Reels> findUsersReels(Integer userId) throws Exception {
        userService.getUserById(userId);
        return reelsRepo.findByUserId(userId);
    }
    
}
