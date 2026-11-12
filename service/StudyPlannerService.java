package com.hostelmate.service;

import com.hostelmate.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudyPlannerService {

    public StudyPlan generate(
            LocalDate examDate,
            List<String> topics,
            int hoursPerDay) {

        if (examDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Exam date cannot be in the past.");
        }

        if (topics == null || topics.isEmpty()) {
            throw new IllegalArgumentException("Enter topics.");
        }

        List<PlanDay> days = new ArrayList<>();

        LocalDate currentDate = LocalDate.now();
        int topicIndex = 0;

        while (!currentDate.isAfter(examDate) && topicIndex < topics.size()) {

            List<String> dailyTopics = new ArrayList<>();

            int topicsPerDay = Math.max(1, hoursPerDay / 2);

            for (int i = 0; i < topicsPerDay && topicIndex < topics.size(); i++) {
                dailyTopics.add(topics.get(topicIndex));
                topicIndex++;
            }

            days.add(new PlanDay(
                    currentDate.toString(),
                    hoursPerDay,
                    dailyTopics
            ));

            currentDate = currentDate.plusDays(1);
        }

        return new StudyPlan(days);
    }
}