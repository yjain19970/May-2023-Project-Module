package com.example.todoapp.task.dto;

public class CreateTaskRequestDTO {
    private String taskName;
    private String taskDescription;

    public CreateTaskRequestDTO(String taskName, String taskDescription) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
