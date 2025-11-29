package Pr13.Task3;

public class Test {
    public static void main(String[] args) {
        Student[] students1 = new Student[2];
        Student[] students2 = new Student[2];

        students1[0] = new Student(1, "Геннадий Коркин", 5.0);
        students1[1] = new Student(34, "Анастасия Кулкина", 3.65);
        students2[0] = new Student(5, "Максим Кошкин", 4.4);
        students2[1] = new Student(89, "Никита Трубкин", 2.99);

        System.out.println("Students from first class:");
        print(students1);
        System.out.println("Students from second class:");
        print(students2);

        StudentComparator comparator = new StudentComparator();
        Student[] students = comparator.sort(students1, students2);

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