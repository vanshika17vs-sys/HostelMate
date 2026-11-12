package com.hostelmate.service;

import com.hostelmate.data.AppData;
import java.util.ArrayList;
import java.util.List;

public class PivotService {

    public List<String[]> summary(AppData data) {

        List<String[]> rows = new ArrayList<>();

        rows.add(new String[]{"Total Expenses", String.valueOf(data.expenses.size())});
        rows.add(new String[]{"Total Meals Rated", String.valueOf(data.meals.size())});
        rows.add(new String[]{"Laundry Items", String.valueOf(data.laundry.size())});
        rows.add(new String[]{"Total Complaints", String.valueOf(data.complaints.size())});

        return rows;
    }
}