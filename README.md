
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
        "jdbc:sqlserver://localhost\\SQLEXPRESS;"
        + "databaseName=EmployeeManagementSystem;"
        + "encrypt=true;"
        + "trustServerCertificate=true;";

    private static final String USER = "sa";
    private static final String PASSWORD = "1234";

    // Singleton Connection
    private static Connection conn = null;

    // Private Constructor
    private DBConnection() {
    }

    // Singleton Method
    public static Connection getConnection() {

        try {

            if (conn == null || conn.isClosed()) {

                conn = DriverManager.getConnection(URL, USER, PASSWORD);

                System.out.println("Database Connected Successfully!");
            }

        } catch (SQLException e) {

            System.out.println("Connection Failed!");
            e.printStackTrace();
        }

        return conn;
    }
}
