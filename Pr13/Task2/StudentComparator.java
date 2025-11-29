package Pr13.Task2;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student student1, Student student2) {
        return Double.compare(student2.getRate(), student1.getRate());
    }

    public void quickSort(Student[] students, int start, int stop) {
        if (start < stop) {
            int index = partition(students, start, stop);

            quickSort(students, start, index - 1);
            quickSort(students, index + 1, stop);
        }
    }

    private int partition(Student[] students, int start, int stop) {
        Student pivot = students[stop];
        int i = start - 1;

        for (int j = start; j < stop; j++) {
            if (compare(students[j], pivot) > 0) {
                i++;

                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }

        Student temp = students[i + 1];
        students[i + 1] = students[stop];
        students[stop] = temp;

        return i + 1;
    }
}