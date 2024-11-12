package com.chat.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.chat.service.CommentService;
import com.chat.chat.model.Comment;
import com.chat.chat.model.Post;
import com.chat.chat.repository.commentsRepository;

@RestController
public class CommentController {

    @Autowired
    private  CommentService commentService;
   @PostMapping("/comment/post/{postId}/user/{userId}") 
   public Comment createComments(@RequestBody Comment comment,@PathVariable Integer postId,@PathVariable Integer userId) throws Exception{
    Comment comment2=commentService.createComment(comment, postId, userId);
    return comment2;
   }

   @PostMapping("comments/like/{commentId}/user/{userId}")
   public Comment likeComment(@PathVariable Integer commentId,@PathVariable Integer userId) throws Exception{
    Comment comment=commentService.likeComment(commentId, userId);
    return comment;
   }

   @GetMapping("comments/find/{commentId}")
   public Comment findCommentById(@PathVariable Integer commentId) throws Exception{
    Comment comment=commentService.findCommentById(commentId);
    return comment;
   }


}
