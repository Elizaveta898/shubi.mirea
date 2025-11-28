package Pr5.Task13;

public class LengthLimitObserver implements StringBuilderObserver {
    private int maxLength;

    public LengthLimitObserver(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void update(ObservableStringBuilder stringBuilder, String operation, String oldValue, String newValue) {
        if (newValue.length() > maxLength) {
            System.out.println("🚫 ПРЕВЫШЕНИЕ ЛИМИТА: Текущая длина " + newValue.length() +
                    " превышает максимальную " + maxLength);
            // Можно добавить автоматическое обрезание:
            // stringBuilder.delete(maxLength, stringBuilder.length());
        }
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
}