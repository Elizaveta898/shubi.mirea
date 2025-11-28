package Pr5.Task13;

public interface StringBuilderObservable {
    void addObserver(StringBuilderObserver observer);
    void removeObserver(StringBuilderObserver observer);
    void notifyObservers(String operation, String oldValue, String newValue);
}