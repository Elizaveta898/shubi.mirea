package Pr5.Task10;

import java.util.List;
import java.util.Scanner;

public class TestComputerShop {
    public static void main(String[] args) {
        Shopp shopp = new Shopp();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Интернет-магазин компьютерной техники ===");

        // Заполнение магазина данными
        shopp.fillShopFromInput();

        // Главное меню
        while (true) {
            System.out.println("\n=== Главное меню ===");
            System.out.println("1. Показать все компьютеры");
            System.out.println("2. Поиск компьютера");
            System.out.println("3. Удалить компьютер");
            System.out.println("4. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    shopp.displayAllComputers();
                    break;

                case 2:
                    System.out.println("\n=== Поиск компьютера ===");
                    System.out.print("Бренд (или Enter для пропуска): ");
                    String brandInput = scanner.nextLine();
                    ComputerBrand brand = null;
                    if (!brandInput.isEmpty()) {
                        try {
                            brand = ComputerBrand.valueOf(brandInput.toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Неверный бренд!");
                            break;
                        }
                    }

                    System.out.print("Максимальная цена (0 для пропуска): $");
                    double maxPrice = scanner.nextDouble();
                    System.out.print("Минимальный объем памяти GB (0 для пропуска): ");
                    int minMemory = scanner.nextInt();
                    System.out.print("Минимальный размер экрана (0 для пропуска): ");
                    double minScreen = scanner.nextDouble();
                    scanner.nextLine();

                    List<Computer> results = shopp.searchComputers(brand, maxPrice, minMemory, minScreen);
                    if (results.isEmpty()) {
                        System.out.println("Компьютеры не найдены!");
                    } else {
                        System.out.println("=== Результаты поиска ===");
                        for (int i = 0; i < results.size(); i++) {
                            System.out.println((i + 1) + ". " + results.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n=== Удаление компьютера ===");
                    System.out.print("Введите бренд: ");
                    String delBrand = scanner.nextLine();
                    System.out.print("Введите модель: ");
                    String delModel = scanner.nextLine();

                    try {
                        ComputerBrand delComputerBrand = ComputerBrand.valueOf(delBrand.toUpperCase());
                        shopp.removeComputer(delComputerBrand, delModel);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Неверный бренд!");
                    }
                    break;

                case 4:
                    System.out.println("До свидания!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}