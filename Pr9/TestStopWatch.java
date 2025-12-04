package Pr9;

public class TestStopWatch {
    public static void main(String[] args) {
        // Создаем секундомер
        StopWatch stopwatch = new StopWatch();

        // Имитируем работу программы
        System.out.println("Секундомер запущен...");

        // Выполняем какую-то операцию (например, сортировку)
        try {
            Thread.sleep(1500); // Пауза 1.5 секунды для имитации работы
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Останавливаем секундомер
        stopwatch.stop();

        // Выводим результаты
        System.out.println("Время начала: " + stopwatch.getStartTime() + " мс");
        System.out.println("Время окончания: " + stopwatch.getEndTime() + " мс");
        System.out.println("Прошедшее время: " + stopwatch.getElapsedTime() + " мс");
        System.out.println(stopwatch);

        // Перезапускаем секундомер
        stopwatch.start();

        // Еще одна операция
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopwatch.stop();
        System.out.println("\nВторой замер: " + stopwatch.getElapsedTime() + " мс");
    }
}