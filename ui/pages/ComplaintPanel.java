package com.hostelmate.ui.pages;

import com.hostelmate.data.AppData;
import com.hostelmate.model.*;
import com.hostelmate.service.ComplaintService;
import com.hostelmate.util.UIUtils;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.time.format.*;

public class ComplaintPanel extends JPanel {

    public ComplaintPanel(AppData d) {
        setLayout(new BorderLayout());

        JPanel p = UIUtils.page(
            "Complaint Generator",
            "Describe an issue and create a formatted complaint"
        );

        JPanel c = UIUtils.card("Describe the issue");

        JTextField room = UIUtils.field(12);
        JTextArea issue = new JTextArea(4, 25);

        JButton gen = UIUtils.button("Generate complaint");

        JTextArea output = new JTextArea(8, 35);
        output.setEditable(false);

        c.add(new JLabel("Block / room"));
        c.add(room);
        c.add(new JLabel("Issue"));
        c.add(new JScrollPane(issue));
        c.add(gen);
        c.add(new JScrollPane(output));

        gen.addActionListener(e -> {

            if (issue.getText().isBlank()) {
                JOptionPane.showMessageDialog(
                    this, "Please describe the issue."
                );
                return;
            }

            Rule r = new ComplaintService().detect(issue.getText());

            Ticket t = new Ticket(
                "HM-" + (1000 + (int)(Math.random() * 9000)),
                LocalDate.now().format(
                    DateTimeFormatter.ofPattern("dd/MM/yyyy")
                ),
                room.getText().isBlank() ? "Not specified" : room.getText(),
                issue.getText(),
                r.category(),
                r.dept(),
                r.priority()
            );

            d.complaints.add(t);
            d.lastComplaint = t;

           output.setText(
                "Ticket: " + t.id() +
                "\nDate: " + t.date() +
                "\nRoom: " + t.room() +
                "\nCategory: " + t.category() +
                "\nRouted to: " + t.dept() +
                "\nPriority: " + t.priority() +
                "\nIssue: " + t.issue()
);
        });

        p.add(c);
        add(new JScrollPane(p));
    }
}