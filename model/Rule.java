package com.hostelmate.model;

public class Rule {

    private String category;
    private String dept;
    private String priority;

    public Rule(String category, String dept, String priority) {
        this.category = category;
        this.dept = dept;
        this.priority = priority;
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