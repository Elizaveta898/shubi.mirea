package Pr5;

public class TestUndoableStringBuilder {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация UndoableStringBuilder ===");

        UndoableStringBuilder usb = new UndoableStringBuilder();

        // Последовательность операций
        usb.append("Hello");
        System.out.println("После append('Hello'): " + usb);

        usb.append(" World");
        System.out.println("После append(' World'): " + usb);

        usb.insert(5, ",");
        System.out.println("После insert(5, ','): " + usb);

        usb.replace(6, 11, "Java");
        System.out.println("После replace(6, 11, 'Java'): " + usb);

        usb.reverse();
        System.out.println("После reverse(): " + usb);

        System.out.println("\n=== Выполняем undo ===");

        usb.undo();
        System.out.println("После undo (отмена reverse): " + usb);

        usb.undo();
        System.out.println("После undo (отмена replace): " + usb);

        usb.undo();
        System.out.println("После undo (отмена insert): " + usb);

        usb.undo();
        System.out.println("После undo (отмена append ' World'): " + usb);

        usb.undo();
        System.out.println("После undo (отмена append 'Hello'): " + usb);

        System.out.println("\n=== Выполняем redo ===");

        usb.redo();
        System.out.println("После redo (повтор append 'Hello'): " + usb);

        usb.redo();
        System.out.println("После redo (повтор append ' World'): " + usb);

        System.out.println("\n=== Новая последовательность операций ===");

        usb.delete(5, 11);
        System.out.println("После delete(5, 11): " + usb);

        usb.append("!");
        System.out.println("После append('!'): " + usb);

        usb.insert(0, "Message: ");
        System.out.println("После insert(0, 'Message: '): " + usb);

        System.out.println("\n=== Множественные undo ===");

        while (usb.canUndo()) {
            usb.undo();
            System.out.println("После undo: " + usb);
        }

        System.out.println("\n=== Проверка граничных условий ===");

        try {
            usb.insert(100, "test"); // Должно бросить исключение
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        // Демонстрация с числами и другими типами
        usb.append(123);
        System.out.println("После append(123): " + usb);

        usb.append(true);
        System.out.println("После append(true): " + usb);

        usb.undo();
        System.out.println("После undo (отмена append(true)): " + usb);
    }
}