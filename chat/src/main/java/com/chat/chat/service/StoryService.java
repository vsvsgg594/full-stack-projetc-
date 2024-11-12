package com.chat.chat.service;

import java.util.List;

import com.chat.chat.model.Story;

public interface StoryService {
    public Story createStory(Story story,Integer UserId) throws Exception;

    public List<Story> findStoryByUserId(Integer UserId) throws Exception;

    public String deleteStory(Story story,Integer UserId);
    
    
}
