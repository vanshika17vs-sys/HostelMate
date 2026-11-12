package com.hostelmate.ui.pages;

import com.hostelmate.data.AppData;
import com.hostelmate.model.Expense;
import com.hostelmate.util.UIUtils;

import javax.swing.*;

public class ExpensePanel extends JPanel {

    public ExpensePanel(AppData data) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(UIUtils.page(
            "Expense Tracker",
            "Manage your hostel expenses"
        ));

        JPanel card = UIUtils.card("Add Expense");

        JTextField nameField = UIUtils.field(15);
        JTextField amountField = UIUtils.field(10);

        JButton addButton = UIUtils.button("Add Expense");

        JTextArea output = new JTextArea(8, 30);
        output.setEditable(false);

        card.add(new JLabel("Expense name:"));
        card.add(nameField);

        card.add(new JLabel("Amount:"));
        card.add(amountField);

        card.add(addButton);

        addButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                double amount = Double.parseDouble(amountField.getText());

                data.expenses.add(
                    new Expense(name, amount, "You")
                );

                output.append(name + " : ₹" + amount + "\n");

                nameField.setText("");
                amountField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                    this, "Please enter a valid amount."
                );
            }
        });

        card.add(new JScrollPane(output));
        add(card);
    }
}