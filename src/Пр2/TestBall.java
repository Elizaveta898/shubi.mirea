package Пр2;

public class TestBall {
    public static void main(String[] args) {
        Ball b1 = new Ball(300, 300);
        System.out.println(b1);
        b1.move(60, 30);
        System.out.println(b1);
    }
}