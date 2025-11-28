package Pr9.Task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator extends JFrame {
    private JTextField numberInput1;
    private JTextField numberInput2;
    private JLabel resultLabel;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JPanel buttonsPanel;
    private JPanel numbersPanel;

    Calculator() {
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setFont(new Font("Times new roman", Font.BOLD,18));

        this.resultLabel = new JLabel("Result: None");
        this.resultLabel.setFont(new Font("Times new roman", Font.BOLD,22));
        this.numberInput1 = new JTextField(10);
        this.numberInput2 = new JTextField(10);
        this.addButton = new JButton("ADD");
        this.subtractButton = new JButton("SUBTRACT");
        this.multiplyButton = new JButton("MULTIPLY");
        this.divideButton = new JButton("DIVIDE");

        this.numbersPanel = new JPanel();
        numbersPanel.add(new JLabel("First number"));
        numbersPanel.add(numberInput1);
        numbersPanel.add(new JLabel("Second number"));
        numbersPanel.add(numberInput2);

        this.buttonsPanel = new JPanel();
        this.buttonsPanel.add(this.addButton);
        this.buttonsPanel.add(this.subtractButton);
        this.buttonsPanel.add(this.multiplyButton);
        this.buttonsPanel.add(this.divideButton);

        ActionListener ActionHandler = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();

                try{
                    double number1 = Double.parseDouble(numberInput1.getText().trim());
                    double number2 = Double.parseDouble(numberInput2.getText().trim());
                    double result = 0;
                    switch (command) {
                        case "ADD" -> result = number1 + number2;
                        case "SUBTRACT" -> result = number1 - number2;
                        case "MULTIPLY" -> result = number1 * number2;
                        case "DIVIDE" -> result = number1 / number2;
                    }
                    if (number2 == 0){
                        resultLabel.setText("Division by zero is not allowed!");
                    }
                    else {
                        resultLabel.setText("Result: " + result);
                    }
                }
                catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog( null, "Input correct numbers!","ERROR" , JOptionPane.WARNING_MESSAGE);
                }
            }
        };

        this.addButton.addActionListener(ActionHandler);
        this.subtractButton.addActionListener(ActionHandler);
        this.multiplyButton.addActionListener(ActionHandler);
        this.divideButton.addActionListener(ActionHandler);
    }

    public void run() {
        this.getContentPane().add(BorderLayout.NORTH, numbersPanel);
        this.getContentPane().add(BorderLayout.SOUTH, buttonsPanel);
        this.getContentPane().add(BorderLayout.CENTER, resultLabel);
        this.pack();

        this.setResizable(false);
        this.setVisible(true);
    }
}