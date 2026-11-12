package com.hostelmate.ui.pages;

import com.hostelmate.data.AppData;
import com.hostelmate.model.Food;
import com.hostelmate.service.BudgetFoodService;
import com.hostelmate.util.UIUtils;

import javax.swing.*;
import java.awt.*;

public class BudgetPanel extends JPanel {

    public BudgetPanel(AppData d) {
        setLayout(new BorderLayout());

        JPanel p = UIUtils.page(
            "Budget Food Suggestions",
            "Find food options that fit your budget"
        );

        JPanel c = UIUtils.card("Set your budget");

        JTextField budget = UIUtils.field(10);

        JTextArea out = new JTextArea(8, 35);
        out.setEditable(false);

        JButton go = UIUtils.button("Suggest food");

        c.add(new JLabel("Budget in rupees"));
        c.add(budget);
        c.add(go);
        c.add(new JScrollPane(out));

        go.addActionListener(e -> {
            try {
                double b = Double.parseDouble(budget.getText());

                d.budgetResult = b;

                StringBuilder s = new StringBuilder();

                for (Food f : new BudgetFoodService().suggest(b)) {
                    s.append(f.name())
                     .append(" — ₹")
                     .append(f.min())
                     .append("-₹")
                     .append(f.max())
                     .append(" (")
                     .append(f.tag())
                     .append(")\n");
                }

                out.setText(
                    s.length() == 0
                    ? "No options found. Try a higher budget."
                    : s.toString()
                );

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                    this, "Enter a valid budget."
                );
            }
        });

        p.add(c);
        add(new JScrollPane(p));
    }
}