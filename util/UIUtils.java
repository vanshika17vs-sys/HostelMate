package com.hostelmate.util;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class UIUtils {

    public static JPanel page(String title, String subtitle) {

        JPanel panel = new JPanel();

        panel.setLayout(
            new BoxLayout(panel, BoxLayout.Y_AXIS)
        );

        panel.setBackground(AppTheme.BG);
        panel.setBorder(
            new EmptyBorder(22, 26, 22, 26)
        );

        JLabel heading = new JLabel(title);
        heading.setFont(
            new Font("SansSerif", Font.BOLD, 24)
        );
        heading.setForeground(AppTheme.DEEP);

        JLabel subheading = new JLabel(subtitle);
        subheading.setForeground(AppTheme.MUTED);

        panel.add(heading);
        panel.add(Box.createVerticalStrut(4));
        panel.add(subheading);
        panel.add(Box.createVerticalStrut(18));

        return panel;
    }

    public static JPanel card(String title) {

        JPanel panel = new JPanel();

        panel.setLayout(
            new BoxLayout(panel, BoxLayout.Y_AXIS)
        );

        panel.setBackground(Color.WHITE);

        panel.setBorder(
            new CompoundBorder(
                new LineBorder(AppTheme.LINE, 1, true),
                new EmptyBorder(14, 16, 14, 16)
            )
        );

        if (title != null) {
            JLabel label = new JLabel(title);

            label.setFont(
                new Font("SansSerif", Font.BOLD, 15)
            );

            label.setForeground(AppTheme.INK);

            panel.add(label);
            panel.add(Box.createVerticalStrut(10));
        }

        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        return panel;
    }

    public static JButton button(String text) {

        JButton button = new JButton(text);

        button.setFocusPainted(false);
        button.setBackground(AppTheme.MARIGOLD);
        button.setForeground(AppTheme.INK);

        button.setBorder(
            new EmptyBorder(8, 14, 8, 14)
        );

        return button;
    }

    public static JTextField field(int columns) {

        JTextField field = new JTextField(columns);

        field.setBackground(AppTheme.SURFACE2);

        return field;
    }

    public static void refresh(JPanel panel) {
        panel.revalidate();
        panel.repaint();
    }
}