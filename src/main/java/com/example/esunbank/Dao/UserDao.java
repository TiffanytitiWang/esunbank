package com.example.esunbank.Dao;

import com.example.esunbank.Model.Post;
import com.example.esunbank.Model.User;


public interface UserDao {

    User findByPhone(String phone);

    String addUser(User user);
}
