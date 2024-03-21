package com.example.esunbank.Controller;


import com.example.esunbank.Model.Post;
import com.example.esunbank.Model.User;
import com.example.esunbank.Service.PostService;
import com.example.esunbank.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = { "/register"}, method = RequestMethod.POST)
    public String registerUser(@RequestBody User user) {
        String result = userService.registerUser(user);
        return result ;
    }


    @RequestMapping(value = { "/login"}, method = RequestMethod.POST)
    public String loginUser(@RequestBody User user) {
        String result = userService.loginUser(user.getPhone(), user.getPassword());
        return result;
    }

}
