package com.hostelmate.service;

import com.hostelmate.model.Rule;

public class ComplaintService {

    public Rule detect(String issue) {

        String text = issue.toLowerCase();

        if (text.contains("water") || text.contains("tap")) {
            return new Rule(
                "Water Problem",
                "Plumbing Department",
                "High"
            );
        }

        if (text.contains("electricity")
                || text.contains("light")
                || text.contains("fan")) {

            return new Rule(
                "Electrical Problem",
                "Electrical Department",
                "High"
            );
        }

        if (text.contains("clean")
                || text.contains("garbage")) {

            return new Rule(
                "Cleaning Problem",
                "Housekeeping Department",
                "Medium"
            );
        }

        if (text.contains("food")
                || text.contains("mess")) {

            return new Rule(
                "Food Problem",
                "Mess Department",
                "Medium"
            );
        }

        return new Rule(
            "General Complaint",
            "Hostel Administration",
            "Normal"
        );
    }
}