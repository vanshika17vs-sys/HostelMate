package com.hostelmate.model;

public class Expense {

    public final String name;
    public final double amount;
    public final String paidBy;

    public Expense(String name, double amount, String paidBy) {
        this.name = name;
        this.amount = amount;
        this.paidBy = paidBy;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public String name() {
        return name;
    }

    public double amount() {
        return amount;
    }

    public String paidBy() {
        return paidBy;
    }
}