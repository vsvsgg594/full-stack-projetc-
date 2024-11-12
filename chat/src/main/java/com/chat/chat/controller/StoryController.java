package com.chat.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.chat.model.Story;
import com.chat.chat.service.StoryService;
import com.chat.chat.service.UserService;
import com.chat.chat.model.User;
import java.util.List;

@RestController
public class StoryController {
    @Autowired
    private StoryService storyService;
    @Autowired
    private  UserService userService;
     
    @PostMapping("/create/story/{userId}")
    public Story createNewStory(@RequestBody Story story,@PathVariable Integer userId) 
    throws Exception{

        User user=userService.getUserById(userId);
        Story newStory=storyService.createStory(story,userId);

        return newStory;
    }
    
    @GetMapping("/create/story/get/{userId}")
    public List<Story> findStory(@PathVariable Integer userId) throws Exception
    {
            List<Story> list=storyService.findStoryByUserId(userId);
            return list;
    }
    
    
}
