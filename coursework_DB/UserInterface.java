package coursework_DB;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserInterface extends JFrame {

    private JPanel contentPane;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private String lastSelectedTable = "Client";
//    private JPanel panel_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserInterface frame = new UserInterface();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public UserInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 952, 607);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout());
        contentPane.setLayout(null);


        JPanel contentPane = new JPanel();
//        contentPane.setBackground(Color.GRAY);
        contentPane.setBackground(new Color(0, 100, 0));
        contentPane.setLayout(null);

//        JButton fetchButton = new JButton("Витягти дані");
//        fetchButton.setBounds(106, 29, 105, 25);
//        fetchButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//
//            }
//        });
//        contentPane.add(fetchButton);

        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        panel.setBounds(517, 13, 405, 63);
        contentPane.add(panel);
        panel.setLayout(null);


        JPanel panel_1 = new JPanel();
        panel_1.setBounds(12, 331, 910, 216);
//        panel_1.setBackground(new Color(0, 100, 0));
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 0, 278, 116);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(280, 0, 230, 116);
        contentPane.add(panel_3);
        panel_3.setLayout(null);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(12, 31, 116, 22);
        panel_2.add(textField);

        JLabel label = new JLabel("Таблиця");
        label.setBounds(43, 13, 56, 16);
        panel_2.add(label);


        textField_1 = new JTextField();
        textField_1.setBounds(146, 31, 116, 22);
        panel_2.add(textField_1);
        textField_1.setColumns(10);

        JLabel label_1 = new JLabel("Поле");
        label_1.setBounds(173, 13, 56, 16);
        panel_2.add(label_1);

        textField_2 = new JTextField();
        textField_2.setBounds(12, 78, 116, 22);
        panel_2.add(textField_2);
        textField_2.setColumns(10);

        JLabel label_2 = new JLabel("Запис");
        label_2.setBounds(43, 61, 56, 16);
        panel_2.add(label_2);


        JButton btnSearch = new JButton("Пошук");
        btnSearch.setBounds(183, 77, 75, 25);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

//                performSearch();

                try {
                    // Отримання текстів з текстових полів для пошуку
                    String tableName = textField.getText();
                    String fieldName = textField_1.getText();
                    String recordName = textField_2.getText();

                    // Формування SQL-запиту з використанням введених значень
                    String sqlQuery = "SELECT  * FROM \"" + tableName + "\" WHERE \"" + fieldName + "\" LIKE '%" + recordName + "%'";

                    // Виконання запиту та відображення результатів
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Eco-productsStore", "postgres", "12kOsta71");
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery(sqlQuery);

                    JTable table = new JTable();
                    DefaultTableModel model = new DefaultTableModel();

                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    // Додавання імен стовпців до моделі
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        model.addColumn(metaData.getColumnLabel(columnIndex));
                    }

                    // Додавання рядків до моделі
                    while (resultSet.next()) {
                        Object[] row = new Object[columnCount];
                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            row[columnIndex - 1] = resultSet.getObject(columnIndex);
                        }
                        model.addRow(row);
                    }

                    // Встановлення моделі для таблиці
                    table.setModel(model);

                    // Створення прокрутки для таблиці
                    JScrollPane scrollPane = new JScrollPane(table);

                    // Встановлення розташування та додавання таблиці до панелі
                    scrollPane.setBounds(0, 0, 910, 405);
                    panel_1.removeAll(); // Очистка панелі перед додаванням нового компонента
                    panel_1.add(scrollPane);
                    panel_1.revalidate(); // Оновлення панелі
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);


                }

            }
        });
        panel_2.add(btnSearch);


        JLabel label_3 = new JLabel("Таблиця");
        label_3.setBounds(80, 12, 56, 16);
        panel_3.add(label_3);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(55, 28, 116, 22);
        panel_3.add(textField_3);


        JButton btnSort = new JButton("<html>Сортувати<br>за ID </html");
        btnSort.setBounds(65, 77, 90, 35);
        btnSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {


                try {
                    // Отримання текстів з текстових полів для пошуку
                    String tableName = textField_3.getText();

                    // Формування SQL-запиту з використанням введених значень
                    String sqlQuery = "SELECT  * FROM \"" + tableName + "\" ORDER BY \"" + tableName + "_ID" + "\" ASC";

                    // Виконання запиту та відображення результатів
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Eco-productsStore", "postgres", "12kOsta71");
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery(sqlQuery);

                    JTable table = new JTable();
                    DefaultTableModel model = new DefaultTableModel();

                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    // Додавання імен стовпців до моделі
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        model.addColumn(metaData.getColumnLabel(columnIndex));
                    }

                    // Додавання рядків до моделі
                    while (resultSet.next()) {
                        Object[] row = new Object[columnCount];
                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            row[columnIndex - 1] = resultSet.getObject(columnIndex);
                        }
                        model.addRow(row);
                    }

                    // Встановлення моделі для таблиці
                    table.setModel(model);

                    // Створення прокрутки для таблиці
                    JScrollPane scrollPane = new JScrollPane(table);

                    // Встановлення розташування та додавання таблиці до панелі
                    scrollPane.setBounds(0, 0, 910, 405);
                    panel_1.removeAll(); // Очистка панелі перед додаванням нового компонента
                    panel_1.add(scrollPane);
                    panel_1.revalidate(); // Оновлення панелі
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);


                }

            }
        });
        panel_3.add(btnSort);

//        JPanel panel_3 = new JPanel();
//        panel_3.setBounds(290, 0, 215, 116);
//        contentPane.add(panel_3);
//        panel_3.setLayout(null);
//
//        JTextField textField_3 = new JTextField();
//        textField_3.setBounds(47, 30, 116, 22);
//        panel_3.add(textField_3);
//        textField_3.setColumns(10);
//
//        JButton btnNewButton_4 = new JButton("Сортувати");
//        btnNewButton_4.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        btnNewButton_4.setBounds(60, 78, 97, 25);
//        panel_3.add(btnNewButton_4);

        JButton btnNewButton_1 = new JButton("Додати запис");
        btnNewButton_1.setBounds(772, 265, 150, 53);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
//                if ("Client".equals(lastSelectedTable)) {
//                    try {
//                        // Формування SQL-запиту для нового завдання
//
//                        String client = "Client";
//                        String client_ID = "Client_ID";
//                        String order = "Order";
//                        String order_ID = "Order_ID";
//                        String product = "Product";
//                        String product_ID = "Product_ID";
//                        String product_category = "Product_category";
//                        String product_category_ID = "Product_category_ID";
//                        String provider = "Provider";
//                        String provider_ID = "Provider_ID";
//
//                        if (provider.equals(prov)){
//                            sqlQuery = "SELECT * FROM \"Provider\" ORDER BY \"Provider_ID\" ASC";
//                            Class.forName("org.postgresql.Driver");
//                            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Eco-productsStore", "postgres", "12kOsta71");
//                            statement = connection.createStatement();
//                            resultSet = statement.executeQuery(sqlQuery);
//
//                            JTable table = new JTable();
//                            DefaultTableModel model = new DefaultTableModel();
//
//                            ResultSetMetaData metaData = resultSet.getMetaData();
//                            int columnCount = metaData.getColumnCount();
//
//                            // Додавання імен стовпців до моделі
//                            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
//                                model.addColumn(metaData.getColumnLabel(columnIndex));
//                            }
//
//                            // Додавання рядків до моделі
//                            while (resultSet.next()) {
//                                Object[] row = new Object[columnCount];
//                                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
//                                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
//                                }
//                                model.addRow(row);
//                            }
//
//                            // Встановлення моделі для таблиці
//                            table.setModel(model);
//
//                            // Створення прокрутки для таблиці
//                            JScrollPane scrollPane = new JScrollPane(table);
//
//                            // Встановлення розташування та додавання таблиці до панелі
//                            scrollPane.setBounds(0, 0, 910, 405);
//                            panel_1.removeAll(); // Очистка панелі перед додаванням нового компонента
//                            panel_1.add(scrollPane);
//                            panel_1.revalidate(); // Оновлення панелі
//                        }
//
//                            // Хороший запит, думаю можна застосовувати
////                            String sqlQuery = "SELECT * FROM \"Provider\" ORDER BY \"Provider_ID\" ASC";
//
//// Виконання запиту та відображення результатів
//
//
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    } catch (ClassNotFoundException e) {
//                        throw new RuntimeException(e);
//                    }
//                }

            }
        });
        contentPane.add(btnNewButton_1);


        JButton btnNewButton_2 = new JButton("<html>Знайти продукти<br>з категорії Іграшки </html>");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                // Створення об'єкту класу Information
//                    Information informationPanel = new Information();
//
//                    // Створення нового вікна для відображення Information
//                    JFrame infoFrame = new JFrame("Інформація");
//                    infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                    infoFrame.setSize(600, 400);
//                    infoFrame.setLocationRelativeTo(null);
//
//                    // Додавання панелі Information до вікна
//                    infoFrame.getContentPane().add(informationPanel);
//
//                    // Встановлення видимості для вікна
//                    infoFrame.setVisible(true);

                String table1 = "Client";
                String field1 = "Client_ID";
                String table2 = "Product";
                String field2 = "Product_ID";
                String conditionField = "Price";

                try {
                    // Формування SQL-запиту для нового завдання

                    // Хороший запит, думаю можна застосовувати
                    String sqlQuery = "SELECT * FROM \"Product\" WHERE \"Product_ID\" IN " +
                            "(SELECT DISTINCT \"Product_category_ID\" FROM \"Product_category\" WHERE \"Title\" LIKE '%toy%')";

// Виконання запиту та відображення результатів

                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Eco-productsStore", "postgres", "12kOsta71");
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery(sqlQuery);

                    JTable table = new JTable();
                    DefaultTableModel model = new DefaultTableModel();

                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    // Додавання імен стовпців до моделі
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        model.addColumn(metaData.getColumnLabel(columnIndex));
                    }

                    // Додавання рядків до моделі
                    while (resultSet.next()) {
                        Object[] row = new Object[columnCount];
                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            row[columnIndex - 1] = resultSet.getObject(columnIndex);
                        }
                        model.addRow(row);
                    }

                    // Встановлення моделі для таблиці
                    table.setModel(model);

                    // Створення прокрутки для таблиці
                    JScrollPane scrollPane = new JScrollPane(table);

                    // Встановлення розташування та додавання таблиці до панелі
                    scrollPane.setBounds(0, 0, 910, 405);
                    panel_1.removeAll(); // Очистка панелі перед додаванням нового компонента
                    panel_1.add(scrollPane);
                    panel_1.revalidate(); // Оновлення панелі
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        btnNewButton_2.setBounds(772, 89, 150, 43);
        contentPane.add(btnNewButton_2);


        JButton btnNewButton_3 = new JButton("<html>Показати хто є<br>постачальником іграшок</html>");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    // Формування SQL-запиту для нового завдання

                    // це корельований, працює:
                    String sqlQuery = "SELECT * FROM \"Provider\" \"pc\" " +
                            "WHERE \"pc\".\"Company name\" = 'Metro' AND EXISTS (" +
                            "  SELECT 1 FROM \"Product_category\" \"p\" " +
                            "  WHERE \"pc\".\"Provider_ID\" = \"p\".\"Product_category_ID\" " +
                            "  AND \"p\".\"Title\" LIKE '%toy%')";

// Виконання запиту та відображення результатів

                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Eco-productsStore", "postgres", "12kOsta71");
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery(sqlQuery);

                    JTable table = new JTable();
                    DefaultTableModel model = new DefaultTableModel();

                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    // Додавання імен стовпців до моделі
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        model.addColumn(metaData.getColumnLabel(columnIndex));
                    }

                    // Додавання рядків до моделі
                    while (resultSet.next()) {
                        Object[] row = new Object[columnCount];
                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            row[columnIndex - 1] = resultSet.getObject(columnIndex);
                        }
                        model.addRow(row);
                    }

                    // Встановлення моделі для таблиці
                    table.setModel(model);

                    // Створення прокрутки для таблиці
                    JScrollPane scrollPane = new JScrollPane(table);

                    // Встановлення розташування та додавання таблиці до панелі
                    scrollPane.setBounds(0, 0, 910, 405);
                    panel_1.removeAll(); // Очистка панелі перед додаванням нового компонента
                    panel_1.add(scrollPane);
                    panel_1.revalidate(); // Оновлення панелі
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        btnNewButton_3.setBounds(622, 89, 125, 50);
        contentPane.add(btnNewButton_3);

        JButton btnClient = new JButton("Client");
        btnClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                lastSelectedTable = "Client";
                try {
                    // Вибірка даних з таблиці "Client"
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Eco-productsStore", "postgres", "12kOsta71");
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery("SELECT * FROM \"Client\"");

                    // Заповнення моделі для таблиці
                    DefaultTableModel model = new DefaultTableModel();
                    ResultSetMetaData metaData = resultSet.getMetaData();

                    // Отримання кількості стовпців
                    int columnCount = metaData.getColumnCount();

                    // Додавання імен стовпців до моделі
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        model.addColumn(metaData.getColumnLabel(columnIndex));
                    }

                    // Додавання рядків до моделі
                    while (resultSet.next()) {
                        Object[] row = new Object[columnCount];
                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            row[columnIndex - 1] = resultSet.getObject(columnIndex);
                        }
                        model.addRow(row);
                    }

                    // Створення таблиці та встановлення моделі
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);

                    // Встановлення розташування та додавання таблиці до панелі
                    scrollPane.setBounds(0, 0, 910, 405);
                    panel_1.removeAll(); // Очистка панелі перед додаванням нового компонента
                    panel_1.add(scrollPane);
                    panel_1.revalidate(); // Оновлення панелі


                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }

        });
        btnClient.setBounds(1, 9, 66, 25);
        panel.add(btnClient);

        JButton btnOrder = new JButton("Order");

        btnOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    // Вибірка даних з таблиці "Client"
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Eco-productsStore", "postgres", "12kOsta71");
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery("SELECT * FROM \"Order\"");

                    // Заповнення моделі для таблиці
                    DefaultTableModel model = new DefaultTableModel();
                    ResultSetMetaData metaData = resultSet.getMetaData();

                    // Отримання кількості стовпців
                    int columnCount = metaData.getColumnCount();

                    // Додавання імен стовпців до моделі
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        model.addColumn(metaData.getColumnLabel(columnIndex));
                    }

                    // Додавання рядків до моделі
                    while (resultSet.next()) {
                        Object[] row = new Object[columnCount];
                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            row[columnIndex - 1] = resultSet.getObject(columnIndex);
                        }
                        model.addRow(row);
                    }

                    // Створення таблиці та встановлення моделі
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);

                    // Встановлення розташування та додавання таблиці до панелі
                    scrollPane.setBounds(0, 0, 910, 405);
                    panel_1.removeAll(); // Очистка панелі перед додаванням нового компонента
                    panel_1.add(scrollPane);
                    panel_1.revalidate(); // Оновлення панелі


                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }

        });

        btnOrder.setBounds(68, 9, 66, 25);
        panel.add(btnOrder);


        JButton btnProduct = new JButton("Product");

        btnProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    // Вибірка даних з таблиці "Client"
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Eco-productsStore", "postgres", "12kOsta71");
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery("SELECT * FROM \"Product\"");

                    // Заповнення моделі для таблиці
                    DefaultTableModel model = new DefaultTableModel();
                    ResultSetMetaData metaData = resultSet.getMetaData();

                    // Отримання кількості стовпців
                    int columnCount = metaData.getColumnCount();

                    // Додавання імен стовпців до моделі
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        model.addColumn(metaData.getColumnLabel(columnIndex));
                    }

                    // Додавання рядків до моделі
                    while (resultSet.next()) {
                        Object[] row = new Object[columnCount];
                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            row[columnIndex - 1] = resultSet.getObject(columnIndex);
                        }
                        model.addRow(row);
                    }

                    // Створення таблиці та встановлення моделі
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);

                    // Встановлення розташування та додавання таблиці до панелі
                    scrollPane.setBounds(0, 0, 910, 405);
                    panel_1.removeAll(); // Очистка панелі перед додаванням нового компонента
                    panel_1.add(scrollPane);
                    panel_1.revalidate(); // Оновлення панелі


                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }

        });

        btnProduct.setBounds(136, 9, 83, 25);
        panel.add(btnProduct);


        JButton btnProductcategory = new JButton("Product_category");

        btnProductcategory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    // Вибірка даних з таблиці "Client"
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Eco-productsStore", "postgres", "12kOsta71");
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery("SELECT * FROM \"Product_category\"");

                    // Заповнення моделі для таблиці
                    DefaultTableModel model = new DefaultTableModel();
                    ResultSetMetaData metaData = resultSet.getMetaData();

                    // Отримання кількості стовпців
                    int columnCount = metaData.getColumnCount();

                    // Додавання імен стовпців до моделі
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        model.addColumn(metaData.getColumnLabel(columnIndex));
                    }

                    // Додавання рядків до моделі
                    while (resultSet.next()) {
                        Object[] row = new Object[columnCount];
                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            row[columnIndex - 1] = resultSet.getObject(columnIndex);
                        }
                        model.addRow(row);
                    }

                    // Створення таблиці та встановлення моделі
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);

                    // Встановлення розташування та додавання таблиці до панелі
                    scrollPane.setBounds(0, 0, 910, 405);
                    panel_1.removeAll(); // Очистка панелі перед додаванням нового компонента
                    panel_1.add(scrollPane);
                    panel_1.revalidate(); // Оновлення панелі


                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }

        });

        btnProductcategory.setBounds(219, 9, 97, 25);
        panel.add(btnProductcategory);


        JButton btnProvider = new JButton("Provider");

        btnProvider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    // Вибірка даних з таблиці "Client"
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Eco-productsStore", "postgres", "12kOsta71");
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery("SELECT * FROM \"Provider\"");

                    // Заповнення моделі для таблиці
                    DefaultTableModel model = new DefaultTableModel();
                    ResultSetMetaData metaData = resultSet.getMetaData();

                    // Отримання кількості стовпців
                    int columnCount = metaData.getColumnCount();

                    // Додавання імен стовпців до моделі
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        model.addColumn(metaData.getColumnLabel(columnIndex));
                    }

                    // Додавання рядків до моделі
                    while (resultSet.next()) {
                        Object[] row = new Object[columnCount];
                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            row[columnIndex - 1] = resultSet.getObject(columnIndex);
                        }
                        model.addRow(row);
                    }

                    // Створення таблиці та встановлення моделі
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);

                    // Встановлення розташування та додавання таблиці до панелі
                    scrollPane.setBounds(0, 0, 910, 405);
                    panel_1.removeAll(); // Очистка панелі перед додаванням нового компонента
                    panel_1.add(scrollPane);
                    panel_1.revalidate(); // Оновлення панелі


                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }

        });

        btnProvider.setBounds(321, 9, 83, 25);
        panel.add(btnProvider);


    }


    private void connectToDatabase() {
        try {
            // Підключення до бази даних SQLite
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            statement = connection.createStatement();

            // Створення таблиці (якщо її не існує)
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT, age INTEGER)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void fetchClientDataFromDatabase() {
//        try {
//            // Вибірка даних з таблиці "Client"
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Eco-productsStore", "postgres", "12kOsta71");
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("SELECT * FROM \"Client\"");
//
//            // Заповнення моделі для таблиці
//            DefaultTableModel model = new DefaultTableModel();
//            ResultSetMetaData metaData = resultSet.getMetaData();
//
//            // Отримання кількості стовпців
//            int columnCount = metaData.getColumnCount();
//
//            // Додавання імен стовпців до моделі
//            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
//                model.addColumn(metaData.getColumnLabel(columnIndex));
//            }
//
//            // Додавання рядків до моделі
//            while (resultSet.next()) {
//                Object[] row = new Object[columnCount];
//                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
//                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
//                }
//                model.addRow(row);
//            }
//
//            // Створення таблиці та встановлення моделі
//            JTable table = new JTable(model);
//            JScrollPane scrollPane = new JScrollPane(table);
//
//            // Встановлення розташування та додавання таблиці до панелі
//            scrollPane.setBounds(0, 0, 910, 405);
//            panel_1.removeAll(); // Очистка панелі перед додаванням нового компонента
//            panel_1.add(scrollPane);
//            panel_1.revalidate(); // Оновлення панелі
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }


    // Закриття з'єднання при завершенні роботи з програмою
    @Override
    public void dispose() {
        super.dispose();
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    private void performSearch() {
//        try {
//            // Отримання текстів з текстових полів для пошуку
//            String tableName = textField.getText();
//            String fieldName = textField_1.getText();
//            String recordName = textField_2.getText();
//
//            // Формування SQL-запиту з використанням введених значень
//            String sqlQuery = "SELECT \"" + fieldName + "\" FROM \"" + tableName + "\" WHERE \"" + fieldName + "\" LIKE '%" + recordName + "%'";
//
//            // Виконання запиту та відображення результатів
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Eco-productsStore", "postgres", "12kOsta71");
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(sqlQuery);
//
//            // Залишається незміненим решта коду для відображення результатів, як ви показали раніше
//            // ...
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}



