package institute;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Proba {

    public static void main(String[] args) {
        // Дані для таблиці
        Object[][] data = {
                {"Рядок 1", "Дані 1"},
                {"Рядок 2", "Дані 2"},
                {"Рядок 3", "Дані 3"},
                {"Рядок 4", "Дані 4"},
                {"Рядок 5", "Дані 5"}
        };

        // Заголовки стовпців
        String[] columnNames = {"Колонка 1", "Колонка 2"};

        // Створення таблиці
        JTable table = new JTable(data, columnNames);

        // Створення панелі з прокруткою для таблиці
        JScrollPane scrollPane = new JScrollPane(table);

        // Створення вікна
        JFrame frame = new JFrame("Приклад таблиці в Java");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Додавання панелі з прокруткою до вікна
        frame.getContentPane().add(scrollPane);

        // Встановлення розміру вікна
        frame.setSize(300, 200);

        // Відображення вікна
        frame.setVisible(true);
    }
}
