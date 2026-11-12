package com.hostelmate.model;

public class LaundryItem {

    public String itemName;
    public String status;
    public String date;

    // Constructor with one parameter
    public LaundryItem(String itemName) {
        this.itemName = itemName;
        this.status = "Pending";
        this.date = "Not specified";
    }

    // Constructor with three parameters
    public LaundryItem(String itemName, String status, String date) {
        this.itemName = itemName;
        this.status = status;
        this.date = date;
    }

    public String getItemName() {
        return itemName;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }
}