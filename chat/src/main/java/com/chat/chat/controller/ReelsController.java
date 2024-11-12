package com.chat.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.chat.chat.model.Reels;
import com.chat.chat.service.ReelsService;
import com.chat.chat.service.UserService;
import com.chat.chat.model.User;
import java.util.List;

@RestController
public class ReelsController {

    @Autowired
    private ReelsService reelsService;
    @Autowired
    private UserService userService;
    

    @PostMapping("/create/reels")
    public Reels newcreateReels(@RequestBody Reels reels,@RequestBody User user) throws Exception{
        // User user1=userService.getUserById(userId);

        Reels newCreatedReels=reelsService.createReels(reels,user);
        return newCreatedReels;
    }
    @GetMapping("/reels/find")
    public List<Reels> findReels(@PathVariable Integer userId){
        List<Reels> reels=reelsService.findAllReesl();
        return reels;

    }
    @GetMapping("/reels/user/{userId}")
    public List<Reels> findUserReels(@PathVariable Integer userId) throws Exception{
        List<Reels> reels=reelsService.findUsersReels(userId);
        return reels;

    }

    
}
