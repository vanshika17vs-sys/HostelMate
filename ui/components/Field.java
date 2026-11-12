package com.hostelmate.ui.components;

import javax.swing.*;
import java.awt.*;

public class Field extends JTextField {

    public Field(String placeholder) {
        super(placeholder, 14);

        setBackground(new Color(0xFFF2DC));
        setFont(new Font("SansSerif", Font.PLAIN, 13));
    }
}