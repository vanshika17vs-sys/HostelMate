package com.hostelmate.data;

import com.hostelmate.model.*;
import java.util.*;

public class AppData {

    public final List<String> roommates =
        new ArrayList<>(List.of("you", "Rohit", "Aman", "Vikram"));

    public final List<Meal> meals = new ArrayList<>();

    public final List<Expense> expenses = new ArrayList<>();

    public final List<LaundryItem> laundry = new ArrayList<>();

    public final List<Chore> chores = new ArrayList<>();

    public final List<Ticket> complaints = new ArrayList<>();

    public final List<Ticket> emergencyLog = new ArrayList<>();

    public StudyPlan studyPlan;

    public Double budgetResult;

    public Ticket lastComplaint;

    public Ticket lastEmergency;
}