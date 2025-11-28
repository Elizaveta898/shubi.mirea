package Pr5.Task11;

import java.util.Scanner;

public class TestConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Конвертер температур ===");

        while (true) {
            System.out.println("\nВыберите вариант:");
            System.out.println("1. Конвертация из Цельсия в Кельвины и Фаренгейты");
            System.out.println("2. Универсальный конвертер");
            System.out.println("3. Выход");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    convertFromCelsius(scanner);
                    break;
                case 2:
                    universalConverter(scanner);
                    break;
                case 3:
                    System.out.println("До свидания!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }

    // Метод для конвертации из Цельсия
    private static void convertFromCelsius(Scanner scanner) {
        System.out.print("\nВведите температуру в градусах Цельсия: ");
        double celsius = scanner.nextDouble();

        // Создаем конвертер
        CelsiusConverter converter = new CelsiusConverter(celsius);

        // Используем метод convert() из интерфейса (конвертирует в Кельвины)
        double kelvin = converter.convert();
        double fahrenheit = converter.toFahrenheit();

        System.out.println("\nРезультаты конвертации:");
        System.out.println(celsius + " °C = " + kelvin + " K");
        System.out.println(celsius + " °C = " + fahrenheit + " °F");

        // Демонстрация полиморфизма
        System.out.println("\nДемонстрация полиморфизма:");
        Convertable polyConverter = new CelsiusConverter(celsius);
        System.out.println("Через интерфейс Convertable: " + celsius + " °C = " +
                polyConverter.convert() + " K");
    }

    // Метод для универсального конвертера
    private static void universalConverter(Scanner scanner) {
        System.out.println("\n=== Универсальный конвертер ===");

        System.out.println("Выберите исходную шкалу:");
        System.out.println("1. Цельсий");
        System.out.println("2. Кельвин");
        System.out.println("3. Фаренгейт");
        System.out.print("Ваш выбор: ");
        int fromChoice = scanner.nextInt();

        System.out.println("Выберите целевую шкалу:");
        System.out.println("1. Цельсий");
        System.out.println("2. Кельвин");
        System.out.println("3. Фаренгейт");
        System.out.print("Ваш выбор: ");
        int toChoice = scanner.nextInt();

        System.out.print("Введите температуру: ");
        double temperature = scanner.nextDouble();

        TemperatureConverter.TemperatureScale fromScale = getScale(fromChoice);
        TemperatureConverter.TemperatureScale toScale = getScale(toChoice);

        if (fromScale == null || toScale == null) {
            System.out.println("Неверный выбор шкалы!");
            return;
        }

        // Создаем и используем конвертер
        TemperatureConverter converter = new TemperatureConverter(temperature, fromScale, toScale);
        double result = converter.convert();

        System.out.println("\nРезультат конвертации:");
        System.out.println(temperature + " " + getScaleSymbol(fromScale) +
                " = " + result + " " + getScaleSymbol(toScale));

        // Демонстрация использования через интерфейс
        Convertable interfaceConverter = new TemperatureConverter(temperature, fromScale, toScale);
        System.out.println("Через интерфейс: " + temperature + " " + getScaleSymbol(fromScale) +
                " = " + interfaceConverter.convert() + " " + getScaleSymbol(toScale));
    }

    // Вспомогательный метод для получения шкалы по выбору
    private static TemperatureConverter.TemperatureScale getScale(int choice) {
        switch (choice) {
            case 1: return TemperatureConverter.TemperatureScale.CELSIUS;
            case 2: return TemperatureConverter.TemperatureScale.KELVIN;
            case 3: return TemperatureConverter.TemperatureScale.FAHRENHEIT;
            default: return null;
        }
    }

    // Вспомогательный метод для получения символа шкалы
    private static String getScaleSymbol(TemperatureConverter.TemperatureScale scale) {
        switch (scale) {
            case CELSIUS: return "°C";
            case KELVIN: return "K";
            case FAHRENHEIT: return "°F";
            default: return "";
        }
    }
}