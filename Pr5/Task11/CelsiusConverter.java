package Pr5.Task11;

public class CelsiusConverter implements Convertable {
    private double celsius;

    public CelsiusConverter(double celsius) {
        this.celsius = celsius;
    }

    @Override
    public double convert() {
        // По умолчанию конвертируем в Кельвины
        return celsius + 273.15;
    }

    // Метод для конвертации в Кельвины
    public double toKelvin() {
        return celsius + 273.15;
    }

    // Метод для конвертации в Фаренгейты
    public double toFahrenheit() {
        return (celsius * 9/5) + 32;
    }

    // Геттеры и сеттеры
    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }
}