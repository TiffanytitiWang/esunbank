package com.example.esunbank.Service.Impl;


import com.example.esunbank.Dao.Impl.PostDaoImpl;
import com.example.esunbank.Dao.Impl.UserDaoImpl;
import com.example.esunbank.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    UserDaoImpl userDao;

    public User registerUser(User user) {
        return null;
    }

    public User loginUser(String username, String password) {
        return null;
    }


}
