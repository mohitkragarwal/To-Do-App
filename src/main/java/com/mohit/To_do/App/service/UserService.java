package com.mohit.To_do.App.service;

import com.mohit.To_do.App.dao.UserRepo;
import com.mohit.To_do.App.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public Users register(Users users) {
        return repo.save(users);
    }
}
