package Pr7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        int n = 100000; // Количество элементов для теста

        // Создаем ArrayList и LinkedList
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Измеряем время выполнения операции добавления в начало
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.add(0, i);
        }
        long endTime = System.nanoTime();
        long arrayListInsertTime = endTime - startTime;
        System.out.println("ArrayList: Время вставки в начало: " + arrayListInsertTime + " наносекунд");

        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.add(0, i);
        }
        endTime = System.nanoTime();
        long linkedListInsertTime = endTime - startTime;
        System.out.println("LinkedList: Время вставки в начало: " + linkedListInsertTime + " наносекунд");

        // ИСПРАВЛЕНИЕ: Создаем новые списки для теста удаления
        // чтобы избежать IndexOutOfBoundsException
        List<Integer> arrayListForRemove = new ArrayList<>();
        List<Integer> linkedListForRemove = new LinkedList<>();

        // Заполняем списки для теста удаления
        for (int i = 0; i < n; i++) {
            arrayListForRemove.add(i);
            linkedListForRemove.add(i);
        }

        // Измеряем время выполнения операции удаления из середины
        startTime = System.nanoTime();
        for (int i = 0; i < n / 10; i++) { // Уменьшаем количество итераций
            arrayListForRemove.remove(arrayListForRemove.size() / 2);
        }
        endTime = System.nanoTime();
        long arrayListRemoveTime = endTime - startTime;
        System.out.println("ArrayList: Время удаления из середины: " + arrayListRemoveTime + " наносекунд");

        startTime = System.nanoTime();
        for (int i = 0; i < n / 10; i++) { // Уменьшаем количество итераций
            linkedListForRemove.remove(linkedListForRemove.size() / 2);
        }
        endTime = System.nanoTime();
        long linkedListRemoveTime = endTime - startTime;
        System.out.println("LinkedList: Время удаления из середины: " + linkedListRemoveTime + " наносекунд");

        // Измеряем время выполнения операции поиска по образцу
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.contains(n / 2);
        }
        endTime = System.nanoTime();
        long arrayListSearchTime = endTime - startTime;
        System.out.println("ArrayList: Время поиска по образцу: " + arrayListSearchTime + " наносекунд");

        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.contains(n / 2);
        }
        endTime = System.nanoTime();
        long linkedListSearchTime = endTime - startTime;
        System.out.println("LinkedList: Время поиска по образцу: " + linkedListSearchTime + " наносекунд");
    }
}