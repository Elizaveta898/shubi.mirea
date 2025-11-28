package Pr5.Task10;

public class Monitor {
    private double size; // в дюймах
    private String resolution;
    private String panelType;

    public Monitor(double size, String resolution, String panelType) {
        this.size = size;
        this.resolution = resolution;
        this.panelType = panelType;
    }

    // Геттеры
    public double getSize() { return size; }
    public String getResolution() { return resolution; }
    public String getPanelType() { return panelType; }

    @Override
    public String toString() {
        return size + "\" " + resolution + " " + panelType;
    }
}