package Pr8.Task2;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
}