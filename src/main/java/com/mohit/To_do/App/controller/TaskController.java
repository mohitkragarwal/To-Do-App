package com.mohit.To_do.App.controller;

import com.mohit.To_do.App.model.Tasks;
import com.mohit.To_do.App.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskservice;


    @GetMapping("home")
    public ResponseEntity<List<Tasks>> getAllTask(){
        return taskservice.getAllTasks();
    }

    @PostMapping("add")
    public ResponseEntity<String> addTask(@RequestBody Tasks task){
       return taskservice.addTask(task);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateTaskById(@RequestBody Tasks task, @PathVariable Integer id)
    {
        return taskservice.updateTaskById(task,id);
    }


}
