package Pr7;

import java.util.Date;
import java.util.Calendar;

public class Task3StudentTest {
    public static void main(String[] args) {
        // Используем Calendar для корректного создания даты
        Calendar cal = Calendar.getInstance();
        cal.set(2004, Calendar.MAY, 24);
        Date birthDate = cal.getTime();

        Task3Student Task3Student = new Task3Student("Елизавета Шубина", birthDate);

        System.out.println("=== ФОРМАТЫ ДАТЫ РОЖДЕНИЯ (24.05.2004) ===");
        System.out.println("Короткий формат: " + Task3Student.formatBirthDate("SHORT"));
        System.out.println("Средний формат: " + Task3Student.formatBirthDate("MEDIUM"));
        System.out.println("Полный формат: " + Task3Student.formatBirthDate("LONG"));
        System.out.println("Метод toString(): " + Task3Student.toString());
    }
}