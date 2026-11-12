package com.hostelmate.model;

import java.util.List;

public class PlanDay {

    public String dateLabel;
    public int hours;
    public List<String> topics;

    public PlanDay(String dateLabel, int hours, List<String> topics) {
        this.dateLabel = dateLabel;
        this.hours = hours;
        this.topics = topics;
    }
}