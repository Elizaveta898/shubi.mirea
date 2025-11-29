package Pr13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestPerson {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Анна", 65, 98000),
                new Person("Виталия", 23, 63000),
                new Person("Иван", 56, 57000),
                new Person("Дмитрий", 21, 38000)
        );

        System.out.println("До сортировки:");
        people.forEach(System.out::println);

        Collections.sort(people);

        System.out.println("\nПосле сортировки по возрасту:");
        people.forEach(System.out::println);
    }
}