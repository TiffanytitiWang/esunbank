package com.example.esunbank.Controller;


import com.example.esunbank.Model.Comment;
import com.example.esunbank.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = { "/comment"}, method = RequestMethod.GET)
    public List<Comment> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        return comments;
    }

    @RequestMapping(value = { "/comment/{id}"}, method = RequestMethod.GET)
    public Comment getCommentById(@PathVariable("id") int id) {
        Comment comment = commentService.getCommentById(id);
        return comment;
    }

    @RequestMapping(value = { "/comment"}, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addComment(@RequestBody Comment comment) {
        String result = commentService.addComment(comment);
        return result;
    }

    @RequestMapping(value = { "/comment"}, method = RequestMethod.PUT)
    public boolean updateComment(@RequestBody Comment comment) {
        int updateCount = commentService.updateComment(comment);
        boolean result = false;
        if(updateCount > 0){
            result = true;
        } else {
            System.out.println("Cannot find comment(id): " + comment.getId() + "to update.");
        }
        return result;
    }

    @RequestMapping(value = { "/comment/{id}"}, method = RequestMethod.DELETE)
    public int deleteComment(@PathVariable("id") int id) {
        int result = commentService.deleteComment( id );
        return result;
    }
}
