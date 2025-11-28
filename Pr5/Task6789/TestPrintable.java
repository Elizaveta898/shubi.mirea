package Pr5.Task6789;

public class TestPrintable {
    public static void main(String[] args) {
        // Создаем массив типа Printable
        Printable[] printables = {
                new Book("Уличный кот по имени Боб", "Джеймс Боуэн", 2013),
                new Shop("National Geographic", "National Geographic Society", 245),
                new Book("1984", "Джордж Оруэлл", 1949),
                new Shop("Forbes", "Forbes Media", 156),
                new Book("Клатбище домашних жывотных", "Стивен Кинг", 1983)
        };
        for (Printable printable : printables) {
            printable.print();
        }
    }
}