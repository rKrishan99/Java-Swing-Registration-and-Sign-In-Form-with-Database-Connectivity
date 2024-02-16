import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/registration",
                "root",
                ""
        );
    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            try {
                dbConnection = new DBConnection();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace(); // Handle the exception appropriately, e.g., show an error message
            }
        }
        return dbConnection;
    }

    public Connection getConnection() throws SQLException {
        // Check if the connection is closed or null, and recreate it if necessary
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/registration",
                        "root",
                        ""
                );
            } catch (SQLException e) {
                e.printStackTrace(); // Handle the exception appropriately, e.g., show an error message
                throw e;
            }
        }
        return connection;
    }
}
