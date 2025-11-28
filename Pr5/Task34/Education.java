package Pr5.Task34;

class Education implements Priceable {
    private double price;

    public Education(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
