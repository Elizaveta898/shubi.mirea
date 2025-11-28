package Pr8.Task2;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {
    private int size;

    public Triangle(int x, int y, int size, Color color) {
        super(x, y, color);
        this.size = size;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int[] xPoints = {x, x - size/2, x + size/2};
        int[] yPoints = {y, y + size, y + size};
        g.fillPolygon(xPoints, yPoints, 3);
    }

    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }
}
