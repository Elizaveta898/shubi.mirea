package Pr5.Task5;

public class MovablePoint implements Movable {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        y -= ySpeed;
    }

    @Override
    public void moveDown() {
        y += ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }

    // Геттеры
    public int getX() { return x; }
    public int getY() { return y; }
    public int getXSpeed() { return xSpeed; }
    public int getYSpeed() { return ySpeed; }

    // Сеттеры
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setXSpeed(int xSpeed) { this.xSpeed = xSpeed; }
    public void setYSpeed(int ySpeed) { this.ySpeed = ySpeed; }

    @Override
    public String toString() {
        return "(" + x + "," + y + ") speed=(" + xSpeed + "," + ySpeed + ")";
    }
}