package Pr5.Task12;

public class MovableTest {
    public static void main(String[] args) {
        MovableRectangle rect = new MovableRectangle(0, 0, 10, 5, 2, 3);

        System.out.println("Исходный прямоугольник: " + rect);
        System.out.println("Скорости совпадают: " + rect.hasSameSpeed());

        // Двигаем прямоугольник
        rect.moveRight();
        rect.moveDown();
        System.out.println("После движения вправо и вниз: " + rect);

        // Меняем скорость
        rect.setSpeed(5, 1);
        System.out.println("После изменения скорости: " + rect);

        // Двигаем с новой скоростью
        rect.moveLeft();
        rect.moveUp();
        System.out.println("После движения влево и вверх: " + rect);
    }
}