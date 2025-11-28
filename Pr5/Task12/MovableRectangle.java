package Pr5.Task12;

// Класс движущегося прямоугольника
public class MovableRectangle implements Movable {
    private MovablePoint topLeft;     // Верхняя левая точка
    private MovablePoint bottomRight; // Нижняя правая точка

    // Конструктор - гарантирует одинаковую скорость
    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    // Метод для проверки одинаковой скорости у точек (требуется по заданию)
    public boolean hasSameSpeed() {
        return topLeft.getXSpeed() == bottomRight.getXSpeed() &&
                topLeft.getYSpeed() == bottomRight.getYSpeed();
    }

    // Реализация методов интерфейса Movable

    @Override
    public void moveUp() {
        topLeft.moveUp();
        bottomRight.moveUp();
    }

    @Override
    public void moveDown() {
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    @Override
    public void moveLeft() {
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }

    @Override
    public void moveRight() {
        topLeft.moveRight();
        bottomRight.moveRight();
    }

    // Геттеры и сеттеры, которые сохраняют одинаковую скорость

    public MovablePoint getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(MovablePoint topLeft) {
        // При установке точки проверяем и синхронизируем скорости
        if (topLeft.getXSpeed() != this.bottomRight.getXSpeed() ||
                topLeft.getYSpeed() != this.bottomRight.getYSpeed()) {
            // Синхронизируем скорость с существующей правой нижней точкой
            topLeft.setXSpeed(this.bottomRight.getXSpeed());
            topLeft.setYSpeed(this.bottomRight.getYSpeed());
        }
        this.topLeft = topLeft;
    }

    public MovablePoint getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(MovablePoint bottomRight) {
        // При установке точки проверяем и синхронизируем скорости
        if (bottomRight.getXSpeed() != this.topLeft.getXSpeed() ||
                bottomRight.getYSpeed() != this.topLeft.getYSpeed()) {
            // Синхронизируем скорость с существующей левой верхней точкой
            bottomRight.setXSpeed(this.topLeft.getXSpeed());
            bottomRight.setYSpeed(this.topLeft.getYSpeed());
        }
        this.bottomRight = bottomRight;
    }

    // Метод для установки скорости обеим точкам (гарантирует одинаковую скорость)
    public void setSpeed(int xSpeed, int ySpeed) {
        topLeft.setXSpeed(xSpeed);
        topLeft.setYSpeed(ySpeed);
        bottomRight.setXSpeed(xSpeed);
        bottomRight.setYSpeed(ySpeed);
    }

    // Метод для получения скорости (можно взять от любой точки, т.к. они одинаковые)
    public int getXSpeed() {
        return topLeft.getXSpeed();
    }

    public int getYSpeed() {
        return topLeft.getYSpeed();
    }

    @Override
    public String toString() {
        return "MovableRectangle[topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                ", sameSpeed=" + hasSameSpeed() + "]";
    }
}