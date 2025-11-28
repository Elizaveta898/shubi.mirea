package Pr5.Task13;

public class StatisticsObserver implements StringBuilderObserver {
    private int operationCount;
    private int totalCharactersAdded;
    private int totalCharactersRemoved;

    public StatisticsObserver() {
        this.operationCount = 0;
        this.totalCharactersAdded = 0;
        this.totalCharactersRemoved = 0;
    }

    @Override
    public void update(ObservableStringBuilder stringBuilder, String operation, String oldValue, String newValue) {
        operationCount++;

        int lengthChange = newValue.length() - oldValue.length();
        if (lengthChange > 0) {
            totalCharactersAdded += lengthChange;
        } else if (lengthChange < 0) {
            totalCharactersRemoved += Math.abs(lengthChange);
        }

        System.out.printf("📊 Статистика: Операций: %d | Добавлено: %d | Удалено: %d | Текущая длина: %d%n",
                operationCount, totalCharactersAdded, totalCharactersRemoved, newValue.length());
    }

    public void reset() {
        operationCount = 0;
        totalCharactersAdded = 0;
        totalCharactersRemoved = 0;
    }

    // Геттеры
    public int getOperationCount() { return operationCount; }
    public int getTotalCharactersAdded() { return totalCharactersAdded; }
    public int getTotalCharactersRemoved() { return totalCharactersRemoved; }
}
