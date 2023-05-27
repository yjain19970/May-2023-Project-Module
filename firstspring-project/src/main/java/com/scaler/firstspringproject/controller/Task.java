package com.scaler.firstspringproject.controller;

public class Task {
    private Integer taskId;
    private String taskName;
    private String taskDescription;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Task(Integer taskId, String taskName, String taskDescription) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }
}
