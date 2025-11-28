package Pr8.Task2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestApp extends JFrame {
    private List<Shape> shapes;
    private Random random;

    public TestApp() {
        shapes = new ArrayList<>();
        random = new Random();

        initializeWindow();
        generateRandomShapes(20);
    }

    private void initializeWindow() {
        setTitle("Случайные фигуры");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Создаем панель для отрисовки
        ShapesPanel panel = new ShapesPanel();
        add(panel);
    }

    private void generateRandomShapes(int count) {
        for (int i = 0; i < count; i++) {
            Shape shape = createRandomShape();
            shapes.add(shape);
        }
    }

    private Shape createRandomShape() {
        // Случайная позиция
        int x = random.nextInt(700) + 50;
        int y = random.nextInt(500) + 50;

        // Случайный цвет
        Color color = new Color(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256)
        );

        // Случайный выбор типа фигуры
        int shapeType = random.nextInt(3);

        switch (shapeType) {
            case 0:
                // Круг
                int radius = random.nextInt(50) + 20;
                return new Circle(x, y, radius, color);

            case 1:
                // Прямоугольник
                int width = random.nextInt(80) + 30;
                int height = random.nextInt(80) + 30;
                return new Rectangle(x, y, width, height, color);

            case 2:
                // Треугольник
                int size = random.nextInt(60) + 30;
                return new Triangle(x, y, size, color);

            default:
                return new Circle(x, y, 30, color);
        }
    }

    // Внутренний класс для отрисовки
    private class ShapesPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Заливаем фон
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            // Рисуем все фигуры
            for (Shape shape : shapes) {
                shape.draw(g);
            }

            // Добавляем информационную надпись
            g.setColor(Color.BLACK);
            g.drawString("Количество фигур: " + shapes.size(), 10, 20);
            g.drawString("Круги: " + countShapesByType("Circle"), 10, 40);
            g.drawString("Прямоугольники: " + countShapesByType("Rectangle"), 10, 60);
            g.drawString("Треугольники: " + countShapesByType("Triangle"), 10, 80);
        }

        private long countShapesByType(String typeName) {
            return shapes.stream()
                    .filter(shape -> shape.getClass().getSimpleName().equals(typeName))
                    .count();
        }
    }

    public static void main(String[] args) {
        // Запуск в Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(() -> {
            TestApp window = new TestApp();
            window.setVisible(true);
        });
    }
}