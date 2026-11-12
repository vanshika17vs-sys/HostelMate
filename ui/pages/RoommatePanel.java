package com.hostelmate.ui.pages;

import com.hostelmate.data.AppData;
import com.hostelmate.model.*;
import com.hostelmate.util.UIUtils;

import javax.swing.*;
import java.awt.*;

public class RoommatePanel extends JPanel {

    public RoommatePanel(AppData d) {
        setLayout(new BorderLayout());

        JPanel p = UIUtils.page(
            "Roommate Manager",
            "Manage roommates and shared chores"
        );

        JPanel c = UIUtils.card("Roommates");

        JTextField name = UIUtils.field(12);
        JButton add = UIUtils.button("Add roommate");

        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));

        Runnable refresh = () -> {
            list.removeAll();

            for (String r : d.roommates) {
                list.add(new JLabel("• " + r));
            }

            list.revalidate();
            list.repaint();
        };

        add.addActionListener(e -> {
            String n = name.getText().trim();

            if (!n.isEmpty() && !d.roommates.contains(n)) {
                d.roommates.add(n);
                refresh.run();
            }
        });

        c.add(name);
        c.add(add);
        c.add(list);

        JPanel chores = UIUtils.card("Shared chores");

        JTextField task = UIUtils.field(12);

        JComboBox<String> who = new JComboBox<>(
            d.roommates.toArray(new String[0])
        );

        JButton assign = UIUtils.button("Assign chore");

        JPanel choreList = new JPanel();
        choreList.setLayout(
            new BoxLayout(choreList, BoxLayout.Y_AXIS)
        );

        assign.addActionListener(e -> {
            if (!task.getText().isBlank() &&
                who.getSelectedItem() != null) {

                d.chores.add(
                    new Chore(
                        task.getText(),
                        (String) who.getSelectedItem()
                    )
                );

                choreList.add(
                    new JCheckBox(
                        task.getText() + " — " + who.getSelectedItem()
                    )
                );

                choreList.revalidate();
            }
        });

        chores.add(task);
        chores.add(who);
        chores.add(assign);
        chores.add(choreList);

        refresh.run();

        p.add(c);
        p.add(chores);

        add(new JScrollPane(p));
    }
}