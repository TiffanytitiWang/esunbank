package com.example.esunbank.Controller;

import com.example.esunbank.Model.Post;
import com.example.esunbank.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(value = { "/post"}, method = RequestMethod.GET)
    public List<Post> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return posts;
    }

    @RequestMapping(value = { "/post/{id}"}, method = RequestMethod.GET)
    public Post getPostById(@PathVariable("id") int id) {
        Post post = postService.getPostById(id);
        return post;
    }

    @RequestMapping(value = { "/post"}, method = RequestMethod.POST)
    public String addPost(@RequestBody Post post) {
        String result = postService.addPost(post);
        return result;
    }

    @RequestMapping(value = { "/post"}, method = RequestMethod.PUT)
    public boolean updatePost(@RequestBody Post post) {
        int updateCount = postService.updatePost(post);
        boolean result = false;
        if(updateCount > 0){
            result = true;
        } else {
            System.out.println("Cannot find post(id): " + post.getId() + "to update.");
        }
        return result;
    }

    @RequestMapping(value = { "/post/{id}"}, method = RequestMethod.DELETE)
    public int deletePost(@PathVariable("id") int id) {
        int result = postService.deletePost( id );
        return result;
    }

}
