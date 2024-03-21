package com.example.esunbank.Service;

import com.example.esunbank.Model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();

    Comment getCommentById(int id);

    String addComment(Comment comment);

    Integer updateComment(Comment comment);

    Integer deleteComment(int id);

}
