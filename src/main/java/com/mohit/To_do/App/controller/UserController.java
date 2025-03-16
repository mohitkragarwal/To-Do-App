package com.mohit.To_do.App.controller;

import com.mohit.To_do.App.model.Users;
import com.mohit.To_do.App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    @PostMapping("register")
    public Users register(@RequestBody Users users){
        users.setPassword(encoder.encode(users.getPassword()));
        System.out.println(users.getPassword());
        return userService.register(users);
    }

}
