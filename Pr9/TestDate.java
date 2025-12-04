package Pr9;

public class TestDate {
    public static void main(String[] args) {
        java.util.Date[] dates = new java.util.Date[10];

        // Инициализируем элементы массива
        for (int i = 0; i < dates.length; i++) {
            dates[i] = new java.util.Date(); // Создаем новый объект Date
        }
        // Теперь можно вызывать методы
        System.out.println(dates[0].toString());
    }
}