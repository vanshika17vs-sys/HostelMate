package com.hostelmate.ui.pages;

import com.hostelmate.data.AppData;
import com.hostelmate.model.*;
import com.hostelmate.service.StudyPlannerService;
import com.hostelmate.util.UIUtils;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.util.*;

public class StudyPanel extends JPanel {

    public StudyPanel(AppData d) {
        setLayout(new BorderLayout());

        JPanel p = UIUtils.page(
            "Study Planner",
            "Exam date + topics = day-wise preparation plan"
        );

        JPanel c = UIUtils.card("Plan your preparation");

        JTextField date = UIUtils.field(12);
        JTextField topics = UIUtils.field(25);

        JSpinner hours = new JSpinner(
            new SpinnerNumberModel(4, 1, 16, 1)
        );

        JTextArea output = new JTextArea(12, 35);
        output.setEditable(false);

        c.add(new JLabel("Exam date (YYYY-MM-DD)"));
        c.add(date);

        c.add(new JLabel("Hours per day"));
        c.add(hours);

        c.add(new JLabel("Topics separated by commas"));
        c.add(topics);

        JButton make = UIUtils.button("Generate plan");
        c.add(make);
        c.add(new JScrollPane(output));

        make.addActionListener(e -> {
            try {
                java.util.List<String> list = Arrays.stream(
                    topics.getText().split(",")
                )
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();

                d.studyPlan = new StudyPlannerService().generate(
                    LocalDate.parse(date.getText().trim()),
                    list,
                    (Integer) hours.getValue()
                );

                StringBuilder sb = new StringBuilder();

                for (PlanDay day : d.studyPlan.plan) {
                    sb.append(day.dateLabel)
                      .append(" — ")
                      .append(day.hours)
                      .append(" hours — ")
                      .append(String.join(", ", day.topics))
                      .append("\n");
                }

                output.setText(sb.toString());

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                    this,
                    "Check the date (YYYY-MM-DD) and enter topics. Exam date cannot be in the past."
                );
            }
        });

        p.add(c);
        add(new JScrollPane(p));
    }
}