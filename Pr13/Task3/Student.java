package Pr13.Task3;

public class Student {
    private final int id;
    private final String name;
    private double rate;

    Student(int id, String name, double rate){
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
