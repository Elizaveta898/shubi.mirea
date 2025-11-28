package Pr5.Task34;

class Carr implements Priceable {
    private double price;

    public Carr(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}