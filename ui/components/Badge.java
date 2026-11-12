package com.hostelmate.ui.components;

import javax.swing.*;
import java.awt.*;

public class Badge extends JCheckBox {

    public Badge(String text) {
        super(text, true);
        setOpaque(false);
        setFont(new Font("SansSerif", Font.PLAIN, 12));
    }
}