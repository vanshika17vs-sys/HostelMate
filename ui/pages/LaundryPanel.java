package com.hostelmate.ui.pages;

import com.hostelmate.data.AppData;
import com.hostelmate.model.LaundryItem;
import com.hostelmate.util.UIUtils;

import javax.swing.*;

public class LaundryPanel extends JPanel {

    public LaundryPanel(AppData data) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(UIUtils.page(
            "Laundry Reminder",
            "Keep track of your laundry"
        ));

        JPanel card = UIUtils.card("Add Laundry Reminder");

        JTextField itemField = UIUtils.field(15);

        JButton addButton = UIUtils.button("Add Reminder");

        JTextArea output = new JTextArea(8, 30);
        output.setEditable(false);

        card.add(new JLabel("Laundry item:"));
        card.add(itemField);
        card.add(addButton);

        addButton.addActionListener(e -> {

            String item = itemField.getText().trim();

            if (item.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this, "Enter a laundry item."
                );
                return;
            }

            data.laundry.add(new LaundryItem(item));

            output.append(item + " added to laundry list.\n");

            itemField.setText("");
        });

        card.add(new JScrollPane(output));
        add(card);
    }
}