package Pr7;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Task1 {
    public static void main(String[] args) {
        // Получаем дату и время получения задания (текущее время)
        Date receiveDate = new Date();

        // Имитируем задержку для даты сдачи (например, +2 часа)
        long submitTimeMillis = System.currentTimeMillis() + 2 * 60 * 60 * 1000;
        Date submitDate = new Date(submitTimeMillis);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        System.out.println("=== ИНФОРМАЦИЯ О ВЫПОЛНЕНИИ ЗАДАНИЯ ===");
        System.out.println("Фамилия разработчика: Шубина");
        System.out.println("Дата и время получения задания: " + dateFormat.format(receiveDate));
        System.out.println("Дата и время сдачи задания: " + dateFormat.format(submitDate));


    }
}