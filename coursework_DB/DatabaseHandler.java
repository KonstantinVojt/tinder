package coursework_DB;
import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection()
        throws ClassNotFoundException, SQLException {
//        String connectionString = "jdbc:postgresql://" + dbHost + ":"
//                + dbPort + "/" + dbName;
        String connectionString = "jdbc:postgresql://localhost:5432/Eco-productsStore";
        Class.forName(("org.postgresql.Driver"));

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

//    public boolean checkCredentials(String username, String password) {
//        try {
//            Connection connection = getDbConnection();
//
////            String query = "SELECT * FROM your_users_table WHERE username = ? AND password = ?";
//            String query = dbUser, dbPass;
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//                preparedStatement.setString(1, username);
//                preparedStatement.setString(2, password);
//
//                try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                    return ((ResultSet) resultSet).next(); // Повертає true, якщо знайдено відповідні дані
//                }
//            }
//        } catch (ClassNotFoundException | SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        }
//    }

}
