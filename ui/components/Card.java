package com.hostelmate.ui.components;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import com.hostelmate.util.AppTheme;

public class Card extends JPanel {

    public Card(String title) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

        setBorder(
            new CompoundBorder(
                new LineBorder(AppTheme.LINE, 1, true),
                new EmptyBorder(14, 16, 14, 16)
            )
        );

        if (title != null) {
            JLabel label = new JLabel(title);
            label.setFont(new Font("SansSerif", Font.BOLD, 15));

            add(label);
            add(Box.createVerticalStrut(8));
        }
    }
}