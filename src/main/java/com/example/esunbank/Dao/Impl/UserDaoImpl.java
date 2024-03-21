package com.example.esunbank.Dao.Impl;


import com.example.esunbank.Dao.UserDao;
import com.example.esunbank.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
    public User findByPhone(String phone) {
    try {
        String sqlfind = " SELECT * FROM User where phone = ? ";
        User result = jdbcTemplate.queryForObject(sqlfind, new Object[]{phone}, new BeanPropertyRowMapper<>(User.class));
        return result;
    }catch (Exception e){
        return null;
        }
    }


    @Override
    public String addUser(User user) {
        String sqlCreat = " insert into user " +
                "(username, email, phone, password, image, biography)"
                + " values (?, ?, ?, ?, ?, ?)";

        int resultCreat = this.jdbcTemplate.update(sqlCreat,user.getUsername(), user.getEmail(),user.getPhone(),user.getPassword(), user.getImage(), user.getBiography());

        if (resultCreat != 0) {
            System.out.println(resultCreat);
            return "success";
        } else {
            return "false";
        }
    }
}
