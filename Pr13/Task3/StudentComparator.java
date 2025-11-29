package Pr13.Task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student student1, Student student2) {
        return Double.compare(student2.getId(), student1.getId());
    }

    public Student[] sort(Student[] students1, Student[] students2){
        Student[] students = Stream.concat(Arrays.stream(students1), Arrays.stream(students2)).toArray(Student[]::new);
        Student[] copy = Arrays.copyOf(students, students.length);
        mergeSort(students, copy, 0, students.length - 1);

        return students;
    }

    private void mergeSort(Student[] students, Student[] copy, int start, int stop){
        if (stop <= start){
            return;
        }

        int middle = (start + ((stop - start) >> 1));
        mergeSort(students, copy, start, middle);
        mergeSort(students, copy, middle + 1, stop);
        merge(students, copy, start, middle, stop);
    }

    private void merge(Student[] students, Student[] copy, int start, int middle, int stop){
        int k = start, i = start, j = middle + 1;

        while (i <= middle && j <= stop){
            if (compare(students[i], students[j]) > 0){
                copy[k++] = students[i++];
            }
            else{
                copy[k++] = students[j++];
            }
        }

        while (i <= middle){
            copy[k++] = students[i++];
        }

        for (i = start; i <= stop; ++i){
            students[i] = copy[i];
        }
    }
}