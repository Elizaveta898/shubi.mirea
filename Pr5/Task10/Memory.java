package Pr5.Task10;

public class Memory {
    private int size; // в GB
    private String type;
    private double frequency; // в MHz

    public Memory(int size, String type, double frequency) {
        this.size = size;
        this.type = type;
        this.frequency = frequency;
    }

    // Геттеры
    public int getSize() { return size; }
    public String getType() { return type; }
    public double getFrequency() { return frequency; }

    @Override
    public String toString() {
        return size + "GB " + type + " " + frequency + "MHz";
    }
}