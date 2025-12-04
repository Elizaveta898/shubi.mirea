package Pr9.Task1;

public class F {
    int i;
    static String s;

    void imethod() {
        System.out.println("imethod called");
    }

    static void smethod() {
        System.out.println("smethod called");
    }

    public static void main(String[] args) {
        F f = new F();

        // 1. System.out.println(f.i);
        System.out.println("1: " + f.i);

        // 2. System.out.println(f.s);
        System.out.println("2: " + f.s);

        // 3. f.imethod();
        f.imethod();

        // 4. f.smethod();
        f.smethod();

        // 5. System.out.println(F.i);  // ошибка компиляции
        // System.out.println(F.i); // нельзя: i не static

        // 6. System.out.println(F.s);
        System.out.println("6: " + F.s);

        // 7. F.imethod();  // ошибка компиляции
        // F.imethod(); // нельзя: imethod не static

        // 8. F.smethod();
        F.smethod();
    }
}