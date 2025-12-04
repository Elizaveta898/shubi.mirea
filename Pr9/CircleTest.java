package Pr9;


import java.util.Random;

public class CircleTest {
    public static void main(String[] args) {
        // Создаем массив из 5 объектов Circle
        Circle[] circles = new Circle[5];

        // Инициализируем массив случайными радиусами
        Random random = new Random();
        for (int i = 0; i < circles.length; i++) {
            double radius = 1 + random.nextDouble() * 10; // радиус от 1 до 11
            circles[i] = new Circle(radius);
        }

        // Выводим все круги
        System.out.println("Все круги в массиве:");
        for (int i = 0; i < circles.length; i++) {
            System.out.println("  " + (i+1) + ": " + circles[i]);
        }

        // Находим круг с максимальной площадью
        Circle largestCircle = findLargestCircle(circles);

        // Выводим результат
        if (largestCircle != null) {
            System.out.println("\nКруг с самой большой площадью:");
            System.out.println(largestCircle);
        }
    }

    // Метод для поиска круга с максимальной площадью
    public static Circle findLargestCircle(Circle[] circles) {
        if (circles == null || circles.length == 0) {
            return null;
        }

        Circle largest = circles[0];
        for (int i = 1; i < circles.length; i++) {
            if (circles[i].getArea() > largest.getArea()) {
                largest = circles[i];
            }
        }
        return largest;
    }
}