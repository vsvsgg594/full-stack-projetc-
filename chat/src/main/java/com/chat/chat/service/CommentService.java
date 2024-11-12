package com.chat.chat.service;
import com.chat.chat.model.Post;
import com.chat.chat.model.Comment;
import java.util.List;
import com.chat.chat.model.User;

public interface CommentService {
   public  Comment createComment(Comment comment,Integer postId,Integer userId) throws Exception;
   public Comment likeComment(Integer commentId,Integer userId) throws Exception;
   public Comment findCommentById(Integer commentId) throws Exception;
    
}
