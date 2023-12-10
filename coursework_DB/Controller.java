package coursework_DB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class Controller extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel contentPane;
    private JPanel loginPanel;
    private DatabaseHandler databaseHandler;
    protected String dbUser = "postgres";
    protected String dbPass = "12kOsta71";


    public Controller(DatabaseHandler databaseHandler) {
        this.databaseHandler = databaseHandler;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 379, 348);

        // Створення панелі contentPane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        // Створення панелі loginPanel
        loginPanel = new JPanel();
        loginPanel.setBackground(new Color(0, 100, 0));
        loginPanel.setLayout(null);



        // Додайте компоненти і встановіть їхні розміри та положення
        int labelWidth = 80;
        int textFieldWidth = 150;
        int labelHeight = 30;
        int textFieldHeight = 30;
        int xMargin = 10;
        int yMargin = 10;

        JLabel usernameLabel = new JLabel("Ім'я:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(57, 65, labelWidth, labelHeight);
        loginPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(137, 65, textFieldWidth, textFieldHeight);
        loginPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Пароль:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(57, 120, labelWidth, labelHeight);
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(137, 120, textFieldWidth, textFieldHeight);
        loginPanel.add(passwordField);

        JButton loginButton = new JButton("Увійти");
        loginButton.setBounds(57, 191, labelWidth + textFieldWidth, textFieldHeight);
        loginButton.setBackground(Color.GREEN);
        loginPanel.add(loginButton);


        // Додавання обробника подій для кнопки "Увійти"
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Отримання введених даних
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // Перевірка ім'я та паролю
                if (dbUser.equals(username) && dbPass.equals(password)) {
                    UserInterface userInterface = new UserInterface();
                    setVisible(false);
                    userInterface.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Неправильне ім'я або пароль", "Помилка", JOptionPane.ERROR_MESSAGE);
                }

//                if (databaseHandler.checkCredentials(username, password)) {
//                    JOptionPane.showMessageDialog(contentPane, "Успішний вхід!");
//
//                    UserInterface userInterface = new UserInterface();
//                    setVisible(false);
//                    userInterface.setVisible(true);
//                } else {
//                    JOptionPane.showMessageDialog(contentPane, "Неправильне ім'я або пароль", "Помилка", JOptionPane.ERROR_MESSAGE);
//                }



                // Очищення полів після введення
                usernameField.setText("");
                passwordField.setText("");
            }
        });


        // Додавання панелі loginPanel на contentPane
        contentPane.add(loginPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }
}
