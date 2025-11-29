package Pr13.Task1;

public class Student implements Comparable{
    private final int id;
    private final String name;

    Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        return this.getId() - ((Student) o).getId();
    }
}