package Pr5.Task10;

public class Computer {
    private ComputerBrand brand;
    private String model;
    private double price;
    private Processor processor;
    private Memory memory;
    private Monitor monitor;

    public Computer(ComputerBrand brand, String model, double price,
                    Processor processor, Memory memory, Monitor monitor) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
    }

    // Геттеры
    public ComputerBrand getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPrice() { return price; }
    public Processor getProcessor() { return processor; }
    public Memory getMemory() { return memory; }
    public Monitor getMonitor() { return monitor; }

    @Override
    public String toString() {
        return brand + " " + model +
                "\nПроцессор: " + processor +
                "\nПамять: " + memory +
                "\nМонитор: " + monitor +
                "\nЦена: $" + price +
                "\n";
    }
}
