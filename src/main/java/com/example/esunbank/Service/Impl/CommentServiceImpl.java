package com.example.esunbank.Service.Impl;


import com.example.esunbank.Dao.Impl.CommentDaoImpl;
import com.example.esunbank.Model.Comment;
import com.example.esunbank.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDaoImpl commentDao;

    public List<Comment> getAllComments() {
        List<Comment> getAllComments = commentDao.getAllComments();
        return getAllComments;
    }

    @Override
    public Comment getCommentById(int id) {
        Comment getCommentById = commentDao.getCommentByPostId(id);
        return getCommentById;
    }

    @Override
    public String addComment(Comment comment) {
        String addComment = commentDao.addComment(comment);
        return addComment;
    }

    @Override
    public Integer updateComment(Comment comment) {
        Integer updateComment = commentDao.updateComment(comment);
        return updateComment;
    }

    @Override
    public Integer deleteComment(int id) {
        Integer deleteComment = commentDao.deleteComment(id);
        return deleteComment;
    }
}
