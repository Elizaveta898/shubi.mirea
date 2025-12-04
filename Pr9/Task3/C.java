package Pr9.Task3;

public class C {
    Circle c = new Circle(); // Объявление поля должно быть в начале класса

    public static void main(String[] args) {
        C obj = new C(); // Создаем объект класса C
        obj.method1();   // Вызываем method1 через объект
    }

    public void method1() {
        method2(); // Можно вызвать статический метод из нестатического
    }

    public static void method2() {
        // Нельзя обратиться к c напрямую из статического метода
        // Нужно создать объект класса C
        C obj = new C();
        System.out.println("What is area " + obj.c.getArea());
    }
}

// Предполагаем, что класс Circle существует
class Circle {
    public double getArea() {
        return 0.0; // Заглушка для примера
    }
}