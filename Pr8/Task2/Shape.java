package Pr8.Task2;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
    protected Color color;
    protected int x;
    protected int y;

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    // Абстрактный метод для отрисовки фигуры
    public abstract void draw(Graphics g);

    // Геттеры
    public Color getColor() { return color; }
    public int getX() { return x; }
    public int getY() { return y; }

    // Сеттеры
    public void setColor(Color color) { this.color = color; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}