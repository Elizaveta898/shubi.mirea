package Pr8.Task2;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    public int getRadius() { return radius; }
    public void setRadius(int radius) { this.radius = radius; }
}