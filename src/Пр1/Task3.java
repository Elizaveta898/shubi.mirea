package Пр1;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Первые 10 чисел гармонического ряда:");

        for (int i = 1; i <= 10; i++) {
            double harmonicNumber = 1.0 / i;
            // Форматированный вывод с 4 знаками после запятой
            System.out.printf("H(%d) = %.4f%n", i, harmonicNumber);
        }
    }
}