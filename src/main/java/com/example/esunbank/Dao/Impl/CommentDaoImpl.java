package com.example.esunbank.Dao.Impl;

import com.example.esunbank.Dao.CommentDao;
import com.example.esunbank.Model.Comment;
import com.example.esunbank.Model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;


@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> getAllComments() {

        String sqlfind = " SELECT id, user_id, content, image, created_at FROM comment ";
        List<Comment> result = jdbcTemplate.query(sqlfind, new BeanPropertyRowMapper<>(Comment.class));

        return result;
    }

    @Override
    public Comment getCommentByPostId(int id) {
        String sqlfind = " SELECT id, user_id, content, image, created_at " +
                " FROM comment " +
                " WHERE id = ?" ;
        Comment result = jdbcTemplate.queryForObject(sqlfind, new Object[]{id}, new BeanPropertyRowMapper<>(Comment.class));
        return result;
    }

    @Override
    public String addComment(Comment comment) {
        String sqlCreat = " insert into comment " +
                "(user_id, post_id , content)"
                + " values ( ?, ?, ? ) ";

        int resultCreat = this.jdbcTemplate.update(sqlCreat, comment.getUser().getId(), comment.getPost().getId(), comment.getContent());

        if (resultCreat != 0) {
            System.out.println(resultCreat);
            return "success";
        } else {
            return "false";
        }
    }

    @Override
    public int updateComment(Comment comment) {
        String sqlUpdate = " UPDATE comment "
                + " SET "
                + " content = ? "
                + " WHERE id = ? " ;

        int Updatesuccess = this.jdbcTemplate.update(sqlUpdate, comment.getContent(),comment.getId());
        return Updatesuccess;

    }

    @Override
    public int deleteComment(int id) {
        String sqlDelete = "DELETE FROM comment WHERE id = ?";
        int result = jdbcTemplate.update(sqlDelete,id);
        return result;
    }
}
