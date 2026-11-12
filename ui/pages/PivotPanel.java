package com.hostelmate.ui.pages;

import com.hostelmate.data.AppData;
import com.hostelmate.service.PivotService;
import com.hostelmate.util.UIUtils;

import javax.swing.*;
import java.awt.*;

public class PivotPanel extends JPanel {

    public PivotPanel(AppData d) {
        setLayout(new BorderLayout());

        JPanel p = UIUtils.page(
            "Pivot Builder",
            "Quick summary of the data stored in HostelMate"
        );

        JPanel c = UIUtils.card("Dataset summary");

        for (String[] row : new PivotService().summary(d)) {
            c.add(new JLabel(row[0] + " : " + row[1]));
        }

        p.add(c);
        add(new JScrollPane(p));
    }
}