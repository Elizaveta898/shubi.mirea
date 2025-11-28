package Pr9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ProgramCalculate extends JFrame implements ActionListener{
    private final String[] buttonsLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
    };

    private JTextField display;
    private JPanel buttonsPanel;

    private double firstNumber;
    private String operator;

    ProgramCalculate() {
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 300);
        this.setFont(new Font("Times new roman", Font.BOLD,18));
        this.setLayout(new BorderLayout());

        this.display = new JTextField();
        this.display.setHorizontalAlignment(JTextField.RIGHT);
        this.display.setEditable(false);
        this.add(display, BorderLayout.NORTH);

        this.buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4, 4, 10, 10));

        for (String buttonsLabel : buttonsLabels){
            JButton button = new JButton(buttonsLabel);
            button.setBorder(new RoundedBorder(25));
            button.addActionListener(this);
            buttonsPanel.add(button);
        }

        this.add(buttonsPanel, BorderLayout.CENTER);
    }

    public void run() {
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("1234567890.".contains(command)){
            display.setText(display.getText() + command);
        }

        else if ("/*-+".contains(command)){
            firstNumber = Double.parseDouble(display.getText());
            operator = command;
            display.setText("");
        }

        else if ("=".equals(command)){
            double secondNumber = Double.parseDouble(display.getText());
            double result = 0;
            switch (operator){
                case "/" -> result = firstNumber / secondNumber;
                case "*" -> result = firstNumber * secondNumber;
                case "-" -> result = firstNumber - secondNumber;
                case "+" -> result = firstNumber + secondNumber;
            }
            display.setText(String.valueOf(result));
        }
    }
}
