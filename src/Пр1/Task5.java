package Пр1;

public class Task5 {

    // Метод для вычисления факториала
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал определен только для неотрицательных чисел");
        }

        long result = 1;

        // Вычисление факториала с помощью цикла for
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        // Проверка работы метода
        System.out.println("Проверка метода вычисления факториала:");

        for (int i = 0; i <= 10; i++) {
            long fact = factorial(i);
            System.out.println(i + "! = " + fact);
        }

        // Дополнительная проверка
        System.out.println("\nДополнительные проверки:");
        int[] testNumbers = {5, 7, 10};
        for (int num : testNumbers) {
            System.out.println("Факториал " + num + " = " + factorial(num));
        }
    }
}