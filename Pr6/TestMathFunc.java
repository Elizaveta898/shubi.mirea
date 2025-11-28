package Pr6;

public class TestMathFunc  {
    public static void main(String[] args) {
        // Правильное создание объекта - через реализацию интерфейса
        MathCalculable mc1 = new MathFunc();

        // Ошибка - нельзя создавать экземпляр интерфейса
        // MathCalculable mc2 = new MathCalculable(); // Эта строка вызовет ошибку компиляции

        // Создаем объект MathFunc для тестирования
        MathFunc mathFunc = new MathFunc();

        // Тестирование вычисления длины окружности
        double radius = 5.0;
        double length = mathFunc.circleLength(radius);
        System.out.printf("Длина окружности с радиусом %.2f = %.2f\n", radius, length);

        // Тестирование вычисления площади круга
        double area = mathFunc.circleArea(radius);
        System.out.printf("Площадь круга с радиусом %.2f = %.2f\n", radius, area);

        // Тестирование возведения в степень
        double base = 2.0;
        double exponent = 3.0;
        double powerResult = mathFunc.power(base, exponent);
        System.out.printf("%.2f в степени %.2f = %.2f\n", base, exponent, powerResult);

        // Тестирование вычисления модуля комплексного числа
        double real = 3.0;
        double imaginary = 4.0;
        mathFunc.displayComplexInfo(real, imaginary);

        // Демонстрация работы через интерфейсную ссылку
        System.out.println("\nРабота через интерфейсную ссылку:");
        System.out.printf("2^4 = %.2f\n", mc1.power(2, 4));
        System.out.printf("Модуль числа 1+1i = %.2f\n", mc1.complexModulus(1, 1));
        System.out.printf("Значение PI из интерфейса: %.6f\n", MathCalculable.PI);
    }
}