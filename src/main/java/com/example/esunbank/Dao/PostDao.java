package com.example.esunbank.Dao;



import com.example.esunbank.Model.Post;

import java.util.List;


public interface PostDao {

    List<Post> getAllPosts();

    Post getPostById(int id);

    String addPost(Post post);

    int updatePost(Post post);

    int deletePost(int id);

}
