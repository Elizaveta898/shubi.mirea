package Pr13.Task1;

public class TestStudent {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(1, "Геннадий Коркин");
        students[1] = new Student(34, "Анастасия Кулкина");
        students[2] = new Student(5, "Максим Кошкин");
        System.out.println("Students:");
        print(students);
        sort(students);
        System.out.println("Sorted students:");
        print(students);
    }

    public static void sort(Student[] students){
        for (int i = 1; i < students.length; ++i){
            Student temp = students[i];
            int j = i;

            while (j > 0 && students[j - 1].compareTo(temp) > 0){
                students[j] = students[j - 1];
                j--;
            }
            students[j] = temp;
        }
    }

    public static void print(Student[] students){
        for (Student student : students){
            System.out.printf("%-5s%30s\n", (student.getId() + ":"), student.getName());
        }
        System.out.println();
    }
}