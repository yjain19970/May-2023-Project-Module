package com.example.todoapp.task;


import com.example.todoapp.task.dto.CreateTaskRequestDTO;
import com.example.todoapp.task.dto.TaskDTO;
import com.example.todoapp.task.model.Task;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    ResponseEntity<List<TaskDTO>> getAllTasks(){
        List<Task> tasks= taskService.getAllTasks();
        return ResponseEntity.ok(TaskBuilder.convertTaskListToDTOList(tasks));
    }

    @GetMapping("/{id}")
    ResponseEntity<TaskDTO> getTaskById(@NonNull @PathVariable("id") Integer id)
            throws TaskNotFoundException {
        Task t = taskService.getTaskByTaskID(id);
        return ResponseEntity.ok(TaskBuilder.convertTaskToDTO(t));
    }


    @PostMapping("")
    ResponseEntity<TaskDTO> createTask(@RequestBody CreateTaskRequestDTO taskDTO){
        Task t = taskService.createTask(taskDTO.getTaskName(),
                taskDTO.getTaskDescription());
        return ResponseEntity.ok(TaskBuilder.convertTaskToDTO(t));
    }

    @ExceptionHandler(TaskNotFoundException.class)
    ResponseEntity<String> handleTaskNotFoundException(TaskNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

//    @PatchMapping("")
//    ResponseEntity<TaskDTO> updateStatus(@RequestBody TaskDTO taskDTO){
//        return null;
//    }
//
//    @PutMapping("")
//    ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskDTO){
//        return null;
//    }
//    @DeleteMapping("{id}")
//    ResponseEntity<TaskDTO> deleteTask(){
//        return null;
//    }


}

/**
 *
 *
 * https://www.google.com/search?q=ipl&rlz=1C5GCEM_en&oq=ipl
 * &aqs=chrome.0.0i131i355i433i512j46i131i433i51
 *
 *
 *
 *
 *
 * 4-5 majorly used Request Types in REST:
 * GET / PUT / POST / DELETE / PATCH
 *
 *
 * Format: domain/path?query_param=1?query_param=2....
 *         <www.google.com/
 *
 *   POST vs PUT vs PATCH
 *
 *   POST:
 *     Request1:  "task-name" , "task-description" id: 1
 *     Request2:  "task-name" , "task-description" id: 3
 *
 *     ONLY USED FOR CREATING / DUPLICATE REQUESTS ARE ALLOWED
 *
 *     If you want server to decide the identifier, then go with this
 *
 *
 *  PUT: (idempotent)
 *   (createORUpdate)
 *   if clients sends the id, then server updates the data ELSE it creates
 *   a new identifier (works like POST here)
 *
 *   id: 134
 *      134 --> data will be updated (exists)
 *      134 (X) --> create the entity on server using ID as 134
 *
 *
 *   c1: 134  (it will be created)
 *   c2: 134
 *
 *
 *  PATCH:
 *  update with given id, for a specific field (update for small things)
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */