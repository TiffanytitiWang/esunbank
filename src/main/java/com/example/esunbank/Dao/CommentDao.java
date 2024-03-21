package com.example.esunbank.Dao;

import com.example.esunbank.Model.Comment;

import java.util.List;


public interface CommentDao {


    List<Comment> getAllComments();

    Comment getCommentById(int id);

    String addComment(Comment comment);

    int updateComment(Comment comment);

    int deleteComment(int id);

}
