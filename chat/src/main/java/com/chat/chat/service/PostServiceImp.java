package com.chat.chat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.chat.chat.model.Post;
import com.chat.chat.model.User;
import com.chat.chat.repository.postRepository;
import com.chat.chat.repository.userRepository;


@Service
public class PostServiceImp implements PostService{

    @Autowired
    private postRepository postRepositorys;
    @Autowired
    private UserService userService;
    @Autowired
    private userRepository userrepo;


    @Override
    public Post createdNewPost(Post post, Integer userId) throws Exception {
      User user=userService.getUserById(userId);
      Post newPost=new Post();
      newPost.setCaption(post.getCaption());
      newPost.setImage(post.getImage());
      newPost.setVideo(post.getVideo());
      newPost.setUser(user);

      postRepositorys.save(newPost);
      return newPost;


      
    }

    @Override
    public String deletePost(Integer postId, Integer userId) throws Exception {
        Post post=findPostById(postId);
        User user=userService.getUserById(userId);
        if(post.getUser().getId()!=user.getId()){
            throw new Exception("unauthorized user to deleted the post");

        }
        postRepositorys.delete(post);
        return "post deleted successfully";
        
    }

    @Override
    public List<Post> findPostByUserId(Integer userId) {

        return postRepositorys.findPostByUserId(userId);
       
    }

    @Override
    public Post findPostById(Integer postId) throws Exception {
        Optional<Post> opt=postRepositorys.findById(postId);
        if(opt.isEmpty()){
            throw new Exception("no post have with "+ postId);
        }
        return opt.get();
    }

    @Override
    public List<Post> findAllPost() {
        List<Post> post=postRepositorys.findAll();

        return post;
    }

    @Override
    public Post postSave(Integer postId, Integer userId) throws Exception {
      Post post=findPostById(postId);
      User user=userService.getUserById(userId);
      if(user.getSavePost().contains(post)){
        user.getSavePost().remove(post);
      }else{
        user.getSavePost().add(post);
      }
      userrepo.save(user);
      return post;
    }

    @Override
    public Post likePost(Integer postId, Integer userId) throws Exception {
      Post post=findPostById(postId);
      User user=userService.getUserById(userId);
      
      if(post.getLiked().contains(user)){
        post.getLiked().remove(user);
      }else{
        post.getLiked().add(user);
      }

      
      Post likedPostList=postRepositorys.save(post);
      return likedPostList;
    }
    
}
