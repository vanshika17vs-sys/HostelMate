package com.hostelmate.model;

public class Ticket {

    private String id;
    private String date;
    private String room;
    private String issue;
    private String category;
    private String dept;
    private String priority;

    public Ticket(String id, String date, String room,
                  String issue, String category,
                  String dept, String priority) {

        this.id = id;
        this.date = date;
        this.room = room;
        this.issue = issue;
        this.category = category;
        this.dept = dept;
        this.priority = priority;
    }

    public String id() {
        return id;
    }

    public String date() {
        return date;
    }

    public String room() {
        return room;
    }

    public String issue() {
        return issue;
    }

    public String category() {
        return category;
    }

    public String dept() {
        return dept;
    }

    public String priority() {
        return priority;
    }
}