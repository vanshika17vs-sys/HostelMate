package com.hostelmate.ui.pages;

import com.hostelmate.data.AppData;
import com.hostelmate.model.Meal;
import com.hostelmate.util.UIUtils;

import javax.swing.*;
import java.time.LocalDate;

public class MessPanel extends JPanel {

    public MessPanel(AppData data) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(UIUtils.page(
            "Mess Tracker",
            "Track your daily mess meals"
        ));

        JPanel card = UIUtils.card("Add Meal");

        JTextField mealField = UIUtils.field(15);
        JTextField ratingField = UIUtils.field(5);

        JButton addButton = UIUtils.button("Add Meal");

        card.add(new JLabel("Meal name:"));
        card.add(mealField);

        card.add(new JLabel("Rating (1-5):"));
        card.add(ratingField);

        card.add(addButton);

        JTextArea output = new JTextArea(8, 30);
        output.setEditable(false);

        addButton.addActionListener(e -> {
            try {
                String name = mealField.getText();
                int rating = Integer.parseInt(ratingField.getText());

                data.meals.add(
                    new Meal(name, rating, LocalDate.now().toString())
                );

                output.append(name + " - Rating: " + rating + "\n");

                mealField.setText("");
                ratingField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                    this, "Please enter a valid rating."
                );
            }
        });

        card.add(new JScrollPane(output));
        add(card);
    }
}