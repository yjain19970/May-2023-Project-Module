package com.scaler.firstspringproject.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    List<Task> tasks = new ArrayList<>();
    private int nextTaskId = 1;


    @GetMapping("")
    public List<Task> getTasks(){ // all the tasks
        return tasks;
    }

    @GetMapping("/{id}")
    public Task getTaskByID(@PathVariable("id") Integer id){
        return tasks.stream().filter(i-> i.getTaskId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping("")
    public Task creteTask(@RequestBody Task task){
        task.setTaskId(nextTaskId++);
        tasks.add(task);
        System.out.println("Added a task Successfully: " + task);
        return task;
    }



}
