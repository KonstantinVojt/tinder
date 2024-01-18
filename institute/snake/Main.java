package institute.snake;

import javax.swing.*;

public class Main extends JFrame {
    public Main() {
        setTitle("Змія");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(650, 650);
        setLocation(500, 100);
        add(new SnakeGame());
        setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
