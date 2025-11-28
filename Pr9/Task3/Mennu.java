package Pr9.Task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Mennu extends JFrame{
    private JFrame frame = this;
    private JMenuBar menu;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu helpMenu;

    Mennu() {
        this.setTitle("Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFont(new Font("Times new roman", Font.BOLD,18));
        this.setLayout(new GridBagLayout());
        GridBagConstraints layout = new GridBagConstraints();

        this.menu = new JMenuBar();
        this.fileMenu = new JMenu("File");
        this.editMenu = new JMenu("Edit");
        this.helpMenu = new JMenu("Help");

        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem pasteItem = new JMenuItem("Paste");
        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);

        menu.add(fileMenu);
        menu.add(editMenu);
        menu.add(helpMenu);
        this.setJMenuBar(this.menu);

        JTextField text = new JTextField("Input your message:");
        text.setHorizontalAlignment(JTextField.CENTER);
        layout.gridx = 0;
        layout.gridy = 0;
        layout.gridwidth = 3;
        layout.fill = GridBagConstraints.HORIZONTAL;
        this.add(text, layout);

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        layout.gridx = 0;
        layout.gridy = 1;
        layout.gridwidth = 1;
        layout.fill = GridBagConstraints.EAST;
        this.add(button1, layout);
        layout.gridx = 2;
        layout.gridy = 1;
        layout.fill = GridBagConstraints.WEST;
        this.add(button2, layout);

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "FILE WAS SUCCESSFULLY SAVED!", "SAVED",
                        JOptionPane.INFORMATION_MESSAGE);
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