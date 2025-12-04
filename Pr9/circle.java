package Pr9;

import java.util.Random;

class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return String.format("Circle[radius=%.2f, area=%.2f]", radius, getArea());
    }
}
