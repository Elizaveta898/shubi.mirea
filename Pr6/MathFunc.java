package Pr6;

public class MathFunc implements MathCalculable {

    // Реализация метода возведения в степень
    @Override
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Реализация метода вычисления модуля комплексного числа
    @Override
    public double complexModulus(double real, double imaginary) {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    // Метод для вычисления длины окружности
    public double circleLength(double radius) {
        // Используем PI из интерфейса
        return 2 * MathCalculable.PI * radius;
    }

    // Метод для вычисления площади круга
    public double circleArea(double radius) {
        // Используем PI из интерфейса и метод power
        return MathCalculable.PI * power(radius, 2);
    }

    // Дополнительный метод для демонстрации работы с комплексными числами
    public void displayComplexInfo(double real, double imaginary) {
        double modulus = complexModulus(real, imaginary);
        System.out.printf("Комплексное число: %.2f + %.2fi\n", real, imaginary);
        System.out.printf("Модуль: %.2f\n", modulus);
    }
}