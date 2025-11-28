package Pr7;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        try {
            System.out.println("Введите дату для сравнения (формат: дд.мм.гггг чч:мм):");
            String userInput = scanner.nextLine();

            // Парсим введенную дату
            Date userDate = dateFormat.parse(userInput);

            // Получаем текущую дату
            Date currentDate = new Date();

            System.out.println("\n=== РЕЗУЛЬТАТЫ СРАВНЕНИЯ ===");
            System.out.println("Введенная дата: " + dateFormat.format(userDate));
            System.out.println("Текущая дата: " + dateFormat.format(currentDate));

            // Сравниваем даты
            if (userDate.equals(currentDate)) {
                System.out.println("Даты совпадают!");
            } else if (userDate.before(currentDate)) {
                System.out.println("Введенная дата РАНЬШЕ текущей");
                long diff = currentDate.getTime() - userDate.getTime();
                long days = diff / (24 * 60 * 60 * 1000);
                long hours = (diff % (24 * 60 * 60 * 1000)) / (60 * 60 * 1000);
                System.out.printf("Разница: %d дней %d часов\n", days, hours);
            } else {
                System.out.println("Введенная дата ПОЗЖЕ текущей");
                long diff = userDate.getTime() - currentDate.getTime();
                long days = diff / (24 * 60 * 60 * 1000);
                long hours = (diff % (24 * 60 * 60 * 1000)) / (60 * 60 * 1000);
                System.out.printf("Разница: %d дней %d часов\n", days, hours);
            }

        } catch (ParseException e) {
            System.out.println("Ошибка: неверный формат даты!");
        } finally {
            scanner.close();
        }
    }
}