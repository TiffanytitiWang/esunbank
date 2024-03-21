package com.example.esunbank.Dao.Impl;


import com.example.esunbank.Dao.PostDao;
import com.example.esunbank.Dao.UserDao;
import com.example.esunbank.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findByPhone(String phone) {
        return null;
    }
}
