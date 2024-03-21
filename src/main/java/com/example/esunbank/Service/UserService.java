package com.example.esunbank.Service;


import com.example.esunbank.Model.Post;
import com.example.esunbank.Model.User;


public interface UserService {

    User findByUsername(String username);
    User findByPhone(String phone);
}
