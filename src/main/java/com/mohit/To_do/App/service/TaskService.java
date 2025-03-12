package com.mohit.To_do.App.service;

import com.mohit.To_do.App.dao.TaskDao;
import com.mohit.To_do.App.model.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskDao taskdao;


    public ResponseEntity<List<Tasks>> getAllTasks() {

        return new ResponseEntity<>(taskdao.findAll(), HttpStatus.OK);

    }

    public ResponseEntity<String> addTask(Tasks task) {

        taskdao.save(task);
        System.out.println("Saving task: " + task.getTaskDescription());
        System.out.println("Status: " + task.isStatus());
        System.out.println("Date: " + task.getLocalDate());
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
}
