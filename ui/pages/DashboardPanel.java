package com.hostelmate.ui.pages;

import com.hostelmate.data.AppData;
import com.hostelmate.util.UIUtils;

import javax.swing.*;

public class DashboardPanel extends JPanel {

    public DashboardPanel(AppData data) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(UIUtils.page(
            "Welcome to HostelMate!",
            "Your personal hostel life manager"
        ));

        JPanel card = UIUtils.card("Hostel Overview");

        card.add(new JLabel("Manage your daily hostel activities."));
        card.add(new JLabel("Track mess, expenses and laundry."));
        card.add(new JLabel("Plan your studies and manage your budget."));

        add(card);
    }
}