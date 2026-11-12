package com.hostelmate.model;

public class Chore {

    public String task;
    public String assignedTo;
    public boolean completed;

    public Chore(String task, String assignedTo) {
        this.task = task;
        this.assignedTo = assignedTo;
        this.completed = false;
    }

    public String getTask() {
        return task;
    }

    public String getAssignedTo() {
        return assignedTo;
    }
}