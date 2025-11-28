package Pr5.Task5;

public class TestMovable {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация MovablePoint и MovableCircle ===");

        // Создаем точку
        MovablePoint point = new MovablePoint(0, 0, 2, 3);
        System.out.println("Создана точка: " + point);

        // Двигаем точку
        point.moveRight();
        point.moveUp();
        System.out.println("После движения вправо и вверх: " + point);

        point.moveDown();
        point.moveLeft();
        System.out.println("После движения вниз и влево: " + point);

        System.out.println("\n--- Демонстрация MovableCircle ---");

        // Создаем круг
        MovableCircle circle = new MovableCircle(5, 5, 1, 2, 3);
        System.out.println("Создан круг: " + circle);

        // Двигаем круг
        circle.moveRight();
        circle.moveUp();
        System.out.println("После движения вправо и вверх: " + circle);

        circle.moveDown();
        circle.moveLeft();
        System.out.println("После движения вниз и влево: " + circle);

        System.out.println("\n--- Демонстрация полиморфизма ---");

        // Используем полиморфизм через интерфейс Movable
        Movable[] movableObjects = {
                new MovablePoint(10, 10, 1, 1),
                new MovableCircle(20, 20, 2, 2, 5)
        };

        System.out.println("Двигаем все объекты через интерфейс:");
        for (Movable obj : movableObjects) {
            System.out.println("До движения: " + obj.toString());
            obj.moveRight();
            obj.moveDown();
            System.out.println("После движения: " + obj.toString());
            System.out.println("---");
        }

        System.out.println("\n--- Проверка методов доступа ---");
        System.out.println("Координаты круга: (" + circle.getX() + ", " + circle.getY() + ")");
        System.out.println("Скорость круга: (" + circle.getXSpeed() + ", " + circle.getYSpeed() + ")");
        System.out.println("Радиус круга: " + circle.getRadius());
    }
}