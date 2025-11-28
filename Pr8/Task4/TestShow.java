package Pr8.Task4;

public class TestShow {
    public static void main(String[] args) {
        // Создаем экземпляр Show в отдельном потоке
        Show animation = new Show();

        // Запускаем анимацию в новом потоке, чтобы не блокировать основной поток
        Thread animationThread = new Thread(animation);
        animationThread.start();
    }
}