package Pr5.Task5;

public class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle: Center " + center.toString() + ", Radius " + radius;
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    // Геттеры
    public int getRadius() { return radius; }
    public MovablePoint getCenter() { return center; }
    public int getX() { return center.getX(); }
    public int getY() { return center.getY(); }
    public int getXSpeed() { return center.getXSpeed(); }
    public int getYSpeed() { return center.getYSpeed(); }

    // Сеттеры
    public void setRadius(int radius) { this.radius = radius; }
    public void setCenter(MovablePoint center) { this.center = center; }
}
