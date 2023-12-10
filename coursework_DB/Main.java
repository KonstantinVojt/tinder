package coursework_DB;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DatabaseHandler databaseHandler = new DatabaseHandler();
                    databaseHandler.getDbConnection();

                    Controller frame = new Controller(databaseHandler);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
