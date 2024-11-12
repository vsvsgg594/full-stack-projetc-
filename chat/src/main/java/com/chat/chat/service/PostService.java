package com.chat.chat.service;

import java.util.List;

import com.chat.chat.model.Post;

public interface PostService {
    Post createdNewPost(Post post,Integer userId) throws Exception;

    String deletePost(Integer postId,Integer userId) throws Exception;

    List<Post> findPostByUserId(Integer userId);

    Post findPostById(Integer postId) throws Exception;

    List<Post> findAllPost();

    Post postSave(Integer postId,Integer userId) throws Exception;
    
    Post likePost(Integer postId,Integer userId) throws Exception;

}
