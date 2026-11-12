package com.hostelmate.ui;

import com.hostelmate.data.AppData;
import com.hostelmate.ui.pages.*;
import com.hostelmate.util.AppTheme;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        super("HostelMate — Hostel Life Manager");

        AppData data = new AppData();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 760);
        setMinimumSize(new Dimension(850, 600));
        setLocationRelativeTo(null);

        getContentPane().setBackground(AppTheme.BG);

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("Dashboard", new DashboardPanel(data));
        tabs.addTab("Mess", new MessPanel(data));
        tabs.addTab("Expenses", new ExpensePanel(data));
        tabs.addTab("Laundry", new LaundryPanel(data));
        tabs.addTab("Complaints", new ComplaintPanel(data));
        tabs.addTab("Study Planner", new StudyPanel(data));
        tabs.addTab("Budget Food", new BudgetPanel(data));
        tabs.addTab("Roommates", new RoommatePanel(data));
        tabs.addTab("Pivot Summary", new PivotPanel(data));
        tabs.addTab("Emergency", new EmergencyPanel(data));

        add(tabs, BorderLayout.CENTER);
    }
}