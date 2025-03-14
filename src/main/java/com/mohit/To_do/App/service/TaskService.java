package com.mohit.To_do.App.service;

import com.mohit.To_do.App.dao.TaskDao;
import com.mohit.To_do.App.model.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //We are using the id to fetch the record from DB and update it.
    // we can  directly update it if we have id in the body but to avoid that we are using this way to update
    //This approach helps prevent mistakes where the ID in the request body
    // might accidentally be different from the ID in the URL
    public ResponseEntity<String> updateTaskById(Tasks task, Integer id) {
        Tasks taskstemp=taskdao.findById(id).get();
        taskstemp.setTaskId(id);
        taskstemp.setTaskDescription(task.getTaskDescription());
        taskstemp.setLocalDate(task.getLocalDate());

        System.out.println(taskstemp.getTaskDescription());
        taskdao.save(taskstemp);
        return new ResponseEntity<>("Updated",HttpStatus.OK);
    }
}
