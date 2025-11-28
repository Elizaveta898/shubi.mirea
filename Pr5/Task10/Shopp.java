package Pr5.Task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shopp {
    private List<Computer> computers;

    public Shopp() {
        this.computers = new ArrayList<>();
    }

    // Добавление компьютера
    public void addComputer(Computer computer) {
        computers.add(computer);
        System.out.println("Компьютер добавлен в магазин!");
    }

    // Удаление компьютера
    public boolean removeComputer(ComputerBrand brand, String model) {
        for (Computer computer : computers) {
            if (computer.getBrand() == brand && computer.getModel().equalsIgnoreCase(model)) {
                computers.remove(computer);
                System.out.println("Компьютер удален из магазина!");
                return true;
            }
        }
        System.out.println("Компьютер не найден!");
        return false;
    }

    // Поиск компьютера по критериям
    public List<Computer> searchComputers(ComputerBrand brand, double maxPrice,
                                          int minMemory, double minScreenSize) {
        List<Computer> results = new ArrayList<>();

        for (Computer computer : computers) {
            boolean matches = true;

            if (brand != null && computer.getBrand() != brand) {
                matches = false;
            }
            if (maxPrice > 0 && computer.getPrice() > maxPrice) {
                matches = false;
            }
            if (minMemory > 0 && computer.getMemory().getSize() < minMemory) {
                matches = false;
            }
            if (minScreenSize > 0 && computer.getMonitor().getSize() < minScreenSize) {
                matches = false;
            }

            if (matches) {
                results.add(computer);
            }
        }

        return results;
    }

    // Показать все компьютеры
    public void displayAllComputers() {
        if (computers.isEmpty()) {
            System.out.println("Магазин пуст!");
            return;
        }

        System.out.println("=== Все компьютеры в магазине ===");
        for (int i = 0; i < computers.size(); i++) {
            System.out.println((i + 1) + ". " + computers.get(i));
        }
    }

    // Метод для заполнения магазина данными с клавиатуры
    public void fillShopFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Добавление компьютеров в магазин ===");

        while (true) {
            System.out.println("\nВведите данные о компьютере:");

            // Ввод бренда
            System.out.println("Доступные бренды:");
            for (ComputerBrand brand : ComputerBrand.values()) {
                System.out.print(brand + " ");
            }
            System.out.print("\nВыберите бренд: ");
            String brandInput = scanner.nextLine().toUpperCase();
            ComputerBrand brand;
            try {
                brand = ComputerBrand.valueOf(brandInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный бренд! Попробуйте снова.");
                continue;
            }

            // Ввод модели
            System.out.print("Введите модель: ");
            String model = scanner.nextLine();

            // Ввод цены
            System.out.print("Введите цену: $");
            double price = scanner.nextDouble();
            scanner.nextLine(); // очистка буфера

            // Ввод данных процессора
            System.out.println("=== Процессор ===");
            System.out.print("Модель процессора: ");
            String procModel = scanner.nextLine();
            System.out.print("Частота (GHz): ");
            double procFreq = scanner.nextDouble();
            System.out.print("Количество ядер: ");
            int procCores = scanner.nextInt();
            scanner.nextLine();
            Processor processor = new Processor(procModel, procFreq, procCores);

            // Ввод данных памяти
            System.out.println("=== Память ===");
            System.out.print("Объем памяти (GB): ");
            int memSize = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Тип памяти (DDR4, DDR5): ");
            String memType = scanner.nextLine();
            System.out.print("Частота памяти (MHz): ");
            double memFreq = scanner.nextDouble();
            scanner.nextLine();
            Memory memory = new Memory(memSize, memType, memFreq);

            // Ввод данных монитора
            System.out.println("=== Монитор ===");
            System.out.print("Размер (дюймы): ");
            double screenSize = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Разрешение (1920x1080): ");
            String resolution = scanner.nextLine();
            System.out.print("Тип матрицы (IPS, TN, VA): ");
            String panelType = scanner.nextLine();
            Monitor monitor = new Monitor(screenSize, resolution, panelType);

            // Создание и добавление компьютера
            Computer computer = new Computer(brand, model, price, processor, memory, monitor);
            addComputer(computer);

            System.out.print("Добавить еще компьютер? (y/n): ");
            String continueInput = scanner.nextLine();
            if (!continueInput.equalsIgnoreCase("y")) {
                break;
            }
        }
    }
}