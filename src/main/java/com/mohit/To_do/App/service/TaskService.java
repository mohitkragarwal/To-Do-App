package com.mohit.To_do.App.service;

import com.mohit.To_do.App.dao.TaskDao;
import com.mohit.To_do.App.model.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskDao taskdao;


    public List<Tasks> getAllTasks() {

        return taskdao.findAll();

    }
}
