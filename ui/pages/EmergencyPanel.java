package com.hostelmate.ui.pages;

import com.hostelmate.data.AppData;
import com.hostelmate.model.*;
import com.hostelmate.service.ComplaintService;
import com.hostelmate.util.UIUtils;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.time.format.*;

public class EmergencyPanel extends JPanel {

    public EmergencyPanel(AppData d) {
        setLayout(new BorderLayout());

        JPanel p = UIUtils.page(
            "Emergency Mode",
            "Create an urgent issue report. For immediate danger, contact local emergency services/warden directly."
        );

        JPanel c = UIUtils.card("Report an emergency");

        JTextField room = UIUtils.field(12);
        JTextArea issue = new JTextArea(4, 25);
        JTextArea out = new JTextArea(8, 35);

        out.setEditable(false);

        JButton send = UIUtils.button("Analyze report");

        c.add(new JLabel("Room / block"));
        c.add(room);
        c.add(new JLabel("Describe issue"));
        c.add(new JScrollPane(issue));
        c.add(send);
        c.add(new JScrollPane(out));

        send.addActionListener(e -> {

            if (issue.getText().isBlank()) {
                return;
            }

            Rule r = new ComplaintService().detect(issue.getText());

            Ticket t = new Ticket(
                "EM-" + (1000 + (int)(Math.random() * 9000)),
                LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("dd/MM/yyyy, hh:mm a")
                ),
                room.getText().isBlank() ? "Not specified" : room.getText(),
                issue.getText(),
                r.category(),
                r.dept(),
                r.priority()
            );

            d.emergencyLog.add(t);
            d.lastEmergency = t;

           out.setText(
                "Ticket: " + t.id() +
                "\nCategory: " + t.category() +
                "\nDepartment: " + t.dept() +
                "\nPriority: " + t.priority() +
                "\nNote: This app only records the report locally; it does not actually send it to the warden."
            );
        });

        p.add(c);
        add(new JScrollPane(p));
    }
}