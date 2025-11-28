package Pr8.Task4;

import javax.swing.*;
import java.awt.*;

public class Show implements Runnable {
    private ImageIcon[] frames;
    private JLabel display;
    private int current;

    Show(){
        current = 0;
        frames = new ImageIcon[] {
                new ImageIcon("C://Users//shubi//OneDrive//Изображения//Море.jpg"),
                new ImageIcon("C://Users//shubi//OneDrive//Изображения//Мооре.jpg"),
                new ImageIcon("C://Users//shubi//OneDrive//Изображения//Мооооре.jpg")
        };
        display = new JLabel();

        JFrame frame = new JFrame("Animation");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(display, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void run(){
        while (true) {
            display.setIcon(frames[current++]);
            if (current == frames.length) {
                current = 0;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
