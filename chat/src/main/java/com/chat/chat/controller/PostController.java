package com.chat.chat.controller;

import java.io.ObjectInputFilter.Status;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.chat.model.Post;
import com.chat.chat.response.ApiResponse;
import com.chat.chat.service.PostService;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/posts/{userId}")
    public ResponseEntity<Post> createdPost(@RequestBody Post post,@PathVariable Integer userId) throws Exception{
        Post creatPost=postService.createdNewPost(post, userId);
        return new ResponseEntity<>(creatPost,HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("/posts/{postId}/users/{userId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId,@PathVariable Integer userId) throws Exception{
        String message=postService.deletePost(postId, userId);
        ApiResponse apiResponse=new ApiResponse(message,true);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
    }
    @GetMapping("/posts/get/{postId}")
    public ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postId) throws Exception{
        Post post=postService.findPostById(postId);
        return new ResponseEntity<Post>(post,HttpStatus.OK);

    }

    @GetMapping("/posts/users/{postId}")
    public ResponseEntity<List<Post>> findUserById(@PathVariable Integer postId){
        List<Post> post=postService.findPostByUserId(postId);

        return new ResponseEntity<List<Post>>(post,HttpStatus.OK);
    }

    @GetMapping("/posts/get")
    public ResponseEntity<List<Post>> findAllPosts(){
        List<Post> post=postService.findAllPost();
        return new ResponseEntity<List<Post>>(post,HttpStatus.OK);

    }
    @PutMapping("/posts/{postId}/users/{userId}")
    public ResponseEntity<Post> savePost(@PathVariable Integer postId,@PathVariable Integer userId) throws Exception{
        Post post=postService.postSave(postId, userId);
        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
    }
    @PutMapping("/posts/likes/{postId}/users/{userId}")
    public ResponseEntity<Post> likedPostHandler(@PathVariable Integer postId,@PathVariable Integer userId) throws Exception{
        Post post=postService.likePost(postId, userId);
        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
    }
}
