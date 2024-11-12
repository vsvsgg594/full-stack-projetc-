package com.chat.chat.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chat.chat.model.Story;
import com.chat.chat.model.User;
import com.chat.chat.repository.StoryRepository;

@Service
public class StoryServiceImplemation implements StoryService{

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private UserService userService;


    @Override
    public Story createStory(Story story, Integer UserId) throws Exception {
        User user=userService.getUserById(UserId);
        Story createdStory=new Story();
        createdStory.setCaption(story.getCaption());
        createdStory.setUser(story.getUser());
        createdStory.setCaption((story.getCaption()));
        createdStory.setTimestap(story.getTimestap());
        return storyRepository.save(createdStory);
      
    }

    @Override
    public List<Story> findStoryByUserId(Integer UserId) throws Exception{

        User user=userService.getUserById(UserId);
        return storyRepository.findByUserId(UserId);
        
    }

    @Override
    public String deleteStory(Story story, Integer userId) {

        storyRepository.deleteById(userId);
        return "Story successfully deleted";
        
    }
    
}
