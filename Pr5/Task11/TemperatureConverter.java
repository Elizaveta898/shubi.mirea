package Pr5.Task11;

public class TemperatureConverter implements Convertable {
    public enum TemperatureScale {
        CELSIUS, KELVIN, FAHRENHEIT
    }

    private double value;
    private TemperatureScale fromScale;
    private TemperatureScale toScale;

    public TemperatureConverter(double value, TemperatureScale fromScale, TemperatureScale toScale) {
        this.value = value;
        this.fromScale = fromScale;
        this.toScale = toScale;
    }

    @Override
    public double convert() {
        // Сначала конвертируем в Цельсии, затем в целевую шкалу
        double celsius = toCelsius(value, fromScale);
        return fromCelsius(celsius, toScale);
    }

    // Конвертация в Цельсии из любой шкалы
    private double toCelsius(double value, TemperatureScale scale) {
        switch (scale) {
            case CELSIUS:
                return value;
            case KELVIN:
                return value - 273.15;
            case FAHRENHEIT:
                return (value - 32) * 5/9;
            default:
                return value;
        }
    }

    // Конвертация из Цельсиев в целевую шкалу
    private double fromCelsius(double celsius, TemperatureScale scale) {
        switch (scale) {
            case CELSIUS:
                return celsius;
            case KELVIN:
                return celsius + 273.15;
            case FAHRENHEIT:
                return (celsius * 9/5) + 32;
            default:
                return celsius;
        }
    }

    // Геттеры
    public double getValue() { return value; }
    public TemperatureScale getFromScale() { return fromScale; }
    public TemperatureScale getToScale() { return toScale; }
}