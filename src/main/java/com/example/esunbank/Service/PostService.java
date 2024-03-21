package com.example.esunbank.Service;


import com.example.esunbank.Model.Post;
import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    Post getPostById(int id);

    String addPost(Post post);

    Integer updatePost(Post post);

    Integer deletePost(int id);

}
