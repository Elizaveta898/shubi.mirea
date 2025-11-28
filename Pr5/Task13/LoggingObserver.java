package Pr5.Task13;

public class LoggingObserver implements StringBuilderObserver {
    private String name;

    public LoggingObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(ObservableStringBuilder stringBuilder, String operation, String oldValue, String newValue) {
        System.out.printf("[%s] Операция: %s | Было: '%s' | Стало: '%s' | Длина: %d%n",
                name, operation, oldValue, newValue, newValue.length());
    }

    public String getName() {
        return name;
    }
}
