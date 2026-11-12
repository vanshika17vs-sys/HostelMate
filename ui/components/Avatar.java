package com.hostelmate.ui.components;

import javax.swing.*;
import java.awt.*;

public class Avatar extends JLabel {

    public Avatar(String name) {
        super(
            name.isEmpty() ? "?" :
            name.substring(0, 1).toUpperCase(),
            SwingConstants.CENTER
        );

        setOpaque(true);
        setBackground(new Color(0xFFE9D0));
        setForeground(new Color(0x8A4B08));
        setPreferredSize(new Dimension(30, 30));
    }
}
