package Pr5.Task10;

public class Processor {
    private String model;
    private double frequency; // в GHz
    private int cores;

    public Processor(String model, double frequency, int cores) {
        this.model = model;
        this.frequency = frequency;
        this.cores = cores;
    }

    // Геттеры
    public String getModel() { return model; }
    public double getFrequency() { return frequency; }
    public int getCores() { return cores; }

    @Override
    public String toString() {
        return model + " " + frequency + "GHz (" + cores + " ядер)";
    }
}