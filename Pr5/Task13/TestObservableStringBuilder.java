package Pr5.Task13;

public class TestObservableStringBuilder {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация ObservableStringBuilder ===");

        // Создаем наблюдаемый StringBuilder
        ObservableStringBuilder observableSB = new ObservableStringBuilder();

        // Создаем и регистрируем наблюдателей
        LoggingObserver logger1 = new LoggingObserver("Основной логгер");
        LoggingObserver logger2 = new LoggingObserver("Детальный логгер");
        StatisticsObserver stats = new StatisticsObserver();
        CensorshipObserver censor = new CensorshipObserver();
        LengthLimitObserver lengthLimit = new LengthLimitObserver(50);

        // Добавляем запрещенные слова
        censor.addForbiddenWord("плохое");
        censor.addForbiddenWord("запрещено");

        // Регистрируем наблюдателей
        observableSB.addObserver(logger1);
        observableSB.addObserver(stats);
        observableSB.addObserver(censor);
        observableSB.addObserver(lengthLimit);

        System.out.println("Количество наблюдателей: " + observableSB.getObserverCount());

        // Выполняем операции
        System.out.println("\n--- Последовательность операций ---");

        observableSB.append("Hello");
        observableSB.append(" World");
        observableSB.insert(5, ",");
        observableSB.append("! Это тестовое сообщение.");
        observableSB.append(" Здесь может быть плохое слово.");
        observableSB.replace(0, 5, "Hi");
        observableSB.delete(2, 10);
        observableSB.append(" А это очень длинное сообщение которое должно превысить лимит длины в 50 символов.");

        System.out.println("\n--- Финальное состояние ---");
        System.out.println("Строка: " + observableSB);
        System.out.println("Длина: " + observableSB.length());

        // Демонстрация удаления наблюдателя
        System.out.println("\n--- Удаляем детальный логгер ---");
        observableSB.removeObserver(logger1);

        observableSB.append(" После удаления логгера.");
        System.out.println("Количество наблюдателей: " + observableSB.getObserverCount());

        // Демонстрация с разными типами данных
        System.out.println("\n--- Работа с разными типами данных ---");
        observableSB.append(123);
        observableSB.append(true);
        observableSB.append(3.14);

        System.out.println("\n--- Проверка граничных условий ---");
        try {
            observableSB.insert(1000, "error"); // Должно бросить исключение
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        // Демонстрация очистки наблюдателей
        System.out.println("\n--- Очищаем всех наблюдателей ---");
        observableSB.clearObservers();
        observableSB.append(" Это изменение не будет залогировано.");
        System.out.println("Финальная строка: " + observableSB);
    }
}