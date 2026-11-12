package com.hostelmate.model;

public class Meal {

    public String meal;
    public int rating;
    public String day;
    public String note;

    // Three-parameter constructor
    public Meal(String meal, int rating, String day) {
        this.meal = meal;
        this.rating = rating;
        this.day = day;
        this.note = "";
    }

    // Four-parameter constructor
    public Meal(String day, String meal, String note, int rating) {
        this.day = day;
        this.meal = meal;
        this.note = note;
        this.rating = rating;
    }
}