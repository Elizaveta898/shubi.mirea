package Pr13.Task2;


public class TestStudentComparator {
    // Относительное сравнение compareTo и абсолютное compare
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(1, "Геннадий Коркин", 5.0);
        students[1] = new Student(34, "Анастасия Кулкина", 3.65);
        students[2] = new Student(5, "Максим Кошкин", 4.4);
        System.out.println("Students:");
        print(students);

        StudentComparator comparator = new StudentComparator();
        comparator.quickSort(students, 0, students.length - 1);

        System.out.println("Sorted students:");
        print(students);
    }

    public static void print(Student[] students){
        for (Student student : students){
            System.out.printf("%-5s%30s%10.2f\n", (student.getId() + ":"), student.getName(), student.getRate());
        }
        System.out.println();
    }
}