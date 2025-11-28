package Pr10.Task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Menu extends JFrame {
    private JComboBox<String> menu;
    private JFrame selfFrame = this;

    Menu() {
        this.setTitle("Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setFont(new Font("Times new roman", Font.BOLD,18));

        String[] items = {
                "Australia",
                "China",
                "England",
                "Russia"
        };

        menu = new JComboBox<>(items);
        this.add(menu);

        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = (String) menu.getSelectedItem();
                JOptionPane.showMessageDialog(selfFrame, "Selected: " + command);
            }
        });
    }

    public void run() {
        //this.pack();
        this.setSize(400, 300);

        this.setResizable(false);
        this.setVisible(true);
    }
}