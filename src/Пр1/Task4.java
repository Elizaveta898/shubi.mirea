package Пр1;

import java.util.Arrays;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        int size = 10;
        int[] array1 = new int[size];
        int[] array2 = new int[size];

        System.out.println("=== Метод 1: Math.random() ===");

        // Заполнение массива с помощью Math.random()
        for (int i = 0; i < size; i++) {
            array1[i] = (int)(Math.random() * 100); // числа от 0 до 99
        }

        System.out.println("Исходный массив: " + Arrays.toString(array1));

        // Сортировка
        Arrays.sort(array1);
        System.out.println("Отсортированный массив: " + Arrays.toString(array1));

        System.out.println("\n=== Метод 2: Класс Random ===");

        // Заполнение массива с помощью класса Random
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array2[i] = random.nextInt(100); // числа от 0 до 99
        }

        System.out.println("Исходный массив: " + Arrays.toString(array2));

        // Сортировка
        Arrays.sort(array2);
        System.out.println("Отсортированный массив: " + Arrays.toString(array2));
    }
}