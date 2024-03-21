package com.example.esunbank.Dao.Impl;

import com.example.esunbank.Dao.PostDao;
import com.example.esunbank.Model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;


@Repository
public class PostDaoImpl implements PostDao {


    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Post> getAllPosts() {

        String sqlfind = " SELECT id, user_id, content, image, created_at FROM post ";
        List<Post> result = jdbcTemplate.query(sqlfind, new BeanPropertyRowMapper<>(Post.class));

        return result;
    }

    @Override
    public Post getPostById(int id) {

        String sqlfind = " SELECT id, user_id, content, image, created_at " +
                " FROM post " +
                " WHERE id = ?";
        Post result = jdbcTemplate.queryForObject(sqlfind, new Object[]{id}, new BeanPropertyRowMapper<>(Post.class));
        return result;
    }

    @Override
    public String addPost(Post post) {
        String sqlCreat = " insert into post " +
                "(user_id, content, image)"
                + " values (?, ?)";

        int resultCreat = this.jdbcTemplate.update(sqlCreat,post.getUser().getId(), post.getContent(),post.getImage());

        if (resultCreat != 0) {
            System.out.println(resultCreat);
            return "success";
        } else {
            return "false";
        }
    }

    @Override
    public int updatePost(Post post) {
        String sqlUpdate = " UPDATE post "
                + " SET "
                + " content = ?, image = ? "
                + " WHERE id = ? " ;

        int Updatesuccess = this.jdbcTemplate.update(sqlUpdate, post.getContent(),post.getImage(), post.getId());
        return Updatesuccess;

    }

    @Override
    public int deletePost(int id) {
        String sqlDelete = "DELETE FROM post WHERE id = ?";
        int result = jdbcTemplate.update(sqlDelete, id);
        return result;
    }
}