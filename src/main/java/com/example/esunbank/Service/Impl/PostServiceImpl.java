package com.example.esunbank.Service.Impl;


import com.example.esunbank.Dao.Impl.PostDaoImpl;
import com.example.esunbank.Model.Post;
import com.example.esunbank.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostDaoImpl postDao;

    @Override
    public List<Post> getAllPosts() {
        List<Post> getAllPosts = postDao.getAllPosts();
        return getAllPosts;
    }

    @Override
    public Post getPostById(int id) {
        Post getPostById = postDao.getPostById(id);
        return getPostById;
    }

    @Override
    public String addPost(Post post) {
        String addPost = postDao.addPost(post);
        return addPost;
    }

    @Override
    public Integer updatePost(Post post) {
        Integer updatePost = postDao.updatePost(post);
        return updatePost;
    }

    @Override
    public Integer deletePost(int id) {
        Integer deletePost = postDao.deletePost(id);
        return deletePost;
    }
}
