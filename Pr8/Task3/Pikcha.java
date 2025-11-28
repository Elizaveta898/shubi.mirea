package Pr8.Task3;

import javax.swing.*;
import java.awt.*;

public class Pikcha extends JFrame {
    Pikcha(){
        this.setTitle("Image");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //"files/example.jpg"
        ImageIcon image = new ImageIcon("C:/Users/shubi/OneDrive/Изображения/Котик.jpg");
        this.setSize(image.getIconWidth(), image.getIconHeight() + 50);
        this.setIconImage(image.getImage());
        JLabel display = new JLabel();
        display.setIcon(image);
        getContentPane().add(display, BorderLayout.CENTER);
    }

    public void run() {
        this.setResizable(false);
        this.setVisible(true);
    }
}
