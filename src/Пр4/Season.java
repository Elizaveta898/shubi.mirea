package Пр4;

enum Season {
    Весна(15),
    Лето(30),
    Осень(20),
    Зима(0);

    private int averageTemperature;

    // Конструктор для установки средней температуры
    Season(int averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    // Метод для получения средней температуры
    public int getAverageTemperature() {
        return averageTemperature;
    }

    // Метод для получения описания времени года
    public String getDescription() {
        if (this == Лето) {
            return "Теплое время года";
        } else {
            return "Холодное время года";
        }
    }
}