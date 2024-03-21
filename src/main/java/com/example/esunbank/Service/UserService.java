package com.example.esunbank.Service;


import com.example.esunbank.Model.User;


public interface UserService {

    String registerUser(User user);
    String loginUser(String phone, String password);
}
