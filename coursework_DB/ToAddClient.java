package coursework_DB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ToAddClient extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblNewLabel_1;
    private JTextField textField_1;
    private JLabel lblNewLabel_2;
    private JTextField textField_2;
    private JButton btnNewButton;
    private JTextField textField_3;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JTextField textField_4;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private String lastSelectedTable;

    // Додаткові поля для збереження інформації про вибраний рядок (для редагування)
    private String selectedTableName;
    private String selectedFieldName;
    private String selectedRecord;

    // Конструктор для відображення даних для редагування
    public ToAddClient(String tableName, String fieldName, String record) {
        this();
        selectedTableName = tableName;
        selectedFieldName = fieldName;
        selectedRecord = record;

        // Встановлення текстових полів для редагування інформації
        textField.setText(tableName);
        textField_1.setText(fieldName);
        textField_2.setText(record);
    }

    /**
     * Create the frame.
     */
    public ToAddClient() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Client_ID");
        lblNewLabel.setBounds(100, 13, 56, 16);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(42, 30, 168, 22);
        contentPane.add(textField);
        textField.setColumns(10);

        lblNewLabel_1 = new JLabel("Surname");
        lblNewLabel_1.setBounds(294, 13, 56, 16);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(264, 30, 116, 22);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        lblNewLabel_2 = new JLabel("Name");
        lblNewLabel_2.setBounds(100, 79, 56, 16);
        contentPane.add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setBounds(63, 98, 116, 22);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        lblNewLabel_3 = new JLabel("Phone number");
        lblNewLabel_3.setBounds(294, 79, 56, 16);
        contentPane.add(lblNewLabel_3);

        textField_3 = new JTextField();
        textField_3.setBounds(264, 98, 116, 22);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        lblNewLabel_4 = new JLabel("Address");
        lblNewLabel_4.setBounds(177, 145, 56, 16);
        contentPane.add(lblNewLabel_4);

        textField_4 = new JTextField();
        textField_4.setBounds(153, 164, 116, 22);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        btnNewButton = new JButton("Зберегти");
        btnNewButton.setBounds(158, 215, 97, 25);
        contentPane.add(btnNewButton);

        // Додавання слухача подій для кнопки "Зберегти"
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Отримання даних з текстових полів
                String clientID = textField.getText();
                String surname = textField_1.getText();
                String name = textField_2.getText();
                String phoneNumber = textField_3.getText();
                String address = textField_4.getText();

                try {
                    // Формування SQL-запиту для вставки нового запису або оновлення існуючого
                    String sqlQuery;
                    if (selectedTableName != null && selectedFieldName != null && selectedRecord != null) {
                        // Якщо обрано рядок для редагування, то формуємо SQL-запит на оновлення
                        sqlQuery = "UPDATE \"" + selectedTableName + "\" SET \"Surname\" = ?, \"Name\" = ?, \"Phone number\" = ?, \"Address\" = ? WHERE \"Client_ID\" = ?";
                    } else {
                        // Інакше формуємо SQL-запит для вставки нового запису
                        sqlQuery = "INSERT INTO \"" + selectedTableName + "\" (\"Client_ID\", \"Surname\", \"Name\", \"Phone number\", \"Address\") VALUES (?, ?, ?, ?, ?)";
                    }

                    // Використання PreparedStatement для уникнення SQL-ін'єкцій та покращення читабельності
                    try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Eco-productsStore", "postgres", "12kOsta71");
                         PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

                        // Встановлення значень параметрів PreparedStatement
                        preparedStatement.setString(1, surname);
                        preparedStatement.setString(2, name);
                        preparedStatement.setString(3, phoneNumber);
                        preparedStatement.setString(4, address);
                        preparedStatement.setString(5, clientID);

                        // Виконання SQL-запиту
                        preparedStatement.executeUpdate();
                    }

                    // Закриваємо вікно після завершення обробки
                    dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
