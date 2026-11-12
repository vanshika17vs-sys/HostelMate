package com.hostelmate.ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Btn extends JButton {

    public Btn(String text, ActionListener action) {
        super(text);

        setFocusPainted(false);
        setBackground(new Color(0xFFA630));
        addActionListener(action);
    }
}