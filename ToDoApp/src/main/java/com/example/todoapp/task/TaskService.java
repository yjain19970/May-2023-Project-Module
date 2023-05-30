package com.example.todoapp.task;

import com.example.todoapp.task.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<>();
    private Integer nextTaskId = 1;



    public List<Task> getAllTasks(){
        return tasks;
    }

    public Task getTaskByTaskID(Integer taskId) throws TaskNotFoundException {
        for(Task t : tasks){
            if(t.getId().equals(taskId)){
                return t;
            }
        }
        throw new TaskNotFoundException("not found" + taskId);
    }

    public Task createTask(String taskName, String taskDesc){
        Task t = new Task(nextTaskId++,taskName,taskDesc, "created");
        tasks.add(t);
        return t;
    }

    public Boolean deleteTask(Integer id) throws TaskNotFoundException {
        try {
            Task t = getTaskByTaskID(id);
            tasks.remove(t);
            return true;
        } catch (TaskNotFoundException e) {
            throw e;
        }
    }
}
