package coursework_DB;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class Information extends JPanel{
    private JTextField textField;
    private JTextField textField_1;
    private JPanel contentPane;
    private Statement statement;
    private ResultSet resultSets;

    /**
     * Create the panel.
     */
    public Information() {
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Перша таблиця");
        lblNewLabel.setBounds(12, 17, 97, 16);
        add(lblNewLabel);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(22, 46, 74, 22);


        comboBox.addItem("Client");
        comboBox.addItem("Order");
        comboBox.addItem("Product");
        comboBox.addItem("Product_category");
        comboBox.addItem("Provider");

        add(comboBox);

        JLabel lblNewLabel_1 = new JLabel("Друга таблиця");
        lblNewLabel_1.setBounds(189, 17, 87, 16);
        add(lblNewLabel_1);

        JComboBox<String> comboBox_1 = new JComboBox<>();
        comboBox_1.setBounds(199, 46, 77, 22);
        comboBox_1.addItem("Client");
        comboBox_1.addItem("Order");
        comboBox_1.addItem("Product");
        comboBox_1.addItem("Product_category");
        comboBox_1.addItem("Provider");

        add(comboBox_1);

        JLabel label = new JLabel("Яке поле");
        label.setBounds(121, 107, 56, 16);
        add(label);

        textField = new JTextField();
        textField.setBounds(93, 126, 116, 22);
        add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Який запис");
        lblNewLabel_2.setBounds(118, 168, 74, 16);
        add(lblNewLabel_2);

        textField_1 = new JTextField();
        textField_1.setBounds(93, 186, 116, 22);
        add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton = new JButton("Шукати");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                // Отримання вибраних елементів з ComboBox та введених текстових полів
                String table1 = (String) comboBox.getSelectedItem();
                String table2 = (String) comboBox_1.getSelectedItem();
                String field = textField.getText();
                String f = "";
                String f2 = "";
                String record = textField_1.getText();

                // Визначення полів для конкретних вибраних таблиць
                if ("Client".equals(table1) && "Product".equals(table2)) {
                    f = "Client_ID";
                } else if ("Product".equals(table1) && "Client".equals(table2)) {
                    f2 = "Product_ID";
                }
                // Додаткові умови для інших таблиць...

                try {
                    // Підключення до бази даних
//                    Class.forName("org.postgresql.Driver");
//                    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Eco-productsStore", "postgres", "12kOsta71");

                    // Підготовка SQL-запиту
                    String query = "SELECT * FROM \"" + table1 + "\" WHERE \"" + f + "\" IN " +
                            "(SELECT DISTINCT \"" + f2 + "\" FROM \"" + table2 + "\" WHERE \"" + field + "\" LIKE '%" + record + "%')";

//                    PreparedStatement preparedStatement = connection.prepareStatement(query);
//                    preparedStatement.setString(1, "%" + record + "%");


                    Class.forName("org.postgresql.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Eco-productsStore", "postgres", "12kOsta71");
                    statement = connection.createStatement();
                    resultSets = statement.executeQuery(query);

                    // Виконання SQL-запиту
//                    ResultSet resultSet = preparedStatement.executeQuery();

                    // Заповнення моделі для таблиці
                    DefaultTableModel model = new DefaultTableModel();
                    ResultSetMetaData metaData = resultSets.getMetaData();

                    // Отримання кількості стовпців
                    int columnCount = metaData.getColumnCount();

                    // Додавання імен стовпців до моделі
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        model.addColumn(metaData.getColumnLabel(columnIndex));
                    }

                    // Додавання рядків до моделі
                    while (resultSets.next()) {
                        Object[] row = new Object[columnCount];
                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            row[columnIndex - 1] = resultSets.getObject(columnIndex);
                        }
                        model.addRow(row);
                    }

                    // Створення таблиці та встановлення моделі
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);

                    // Встановлення розташування та додавання таблиці до панелі
                    JPanel panel_1 = new JPanel();
                    panel_1.setBounds(12, 331, 910, 216);
                    contentPane.add(panel_1);
                    panel_1.setLayout(null);
                    scrollPane.setBounds(0, 0, 910, 405);
                    panel_1.removeAll(); // Очистка панелі перед додаванням нового компонента
                    panel_1.add(scrollPane);
                    panel_1.revalidate(); // Оновлення панелі

                    // Закриття ресурсів
                    resultSets.close();
                    statement.close();
                    connection.close();

                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }

        });
        btnNewButton.setBounds(103, 262, 97, 25);
        add(btnNewButton);



    }
}

