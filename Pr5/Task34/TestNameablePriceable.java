package Pr5.Task34;

public class TestNameablePriceable {
    public static void main(String[] args) {
        Nameable planet = new Planet("Меркурий");
        Nameable car = new Car("Honda Accord");
        Nameable animal = new Animal("Рысь");

        System.out.println("Имя планеты: " + planet.getName());
        System.out.println("Имя машины: " + car.getName());
        System.out.println("Имя животного: " + animal.getName());

        Priceable carr = new Carr(1100000.0);
        Priceable education = new Education(800000.0);

        System.out.println("Цена машины: " + carr.getPrice() + " ₽");
        System.out.println("Цена квартиры: " + education.getPrice() + " ₽");
    }
}