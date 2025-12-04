package Pr9.Task2;

public class Test {
    int count;

    public static void main(String[] args) { }
    // main должен быть static, т.к. вызывается без создания объекта

    public int getCount() { return count; }
    // без static, т.к. метод обращается к нестатическому полю count

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++)
            result *= i;
        return result;
    }
    // static, т.к. метод не использует нестатические поля/метки класса
}