package Pr5.Task13;

public interface StringBuilderObserver {
    void update(ObservableStringBuilder stringBuilder, String operation, String oldValue, String newValue);
}
