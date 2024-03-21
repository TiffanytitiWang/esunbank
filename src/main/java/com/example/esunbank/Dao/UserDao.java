package com.example.esunbank.Dao;

import com.example.esunbank.Model.User;


public interface UserDao {

    User findByUsername(String username);
    User findByPhone(String phone);
}
