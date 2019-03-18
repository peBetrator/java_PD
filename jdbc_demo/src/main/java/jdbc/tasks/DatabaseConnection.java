package jdbc.tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private String dbUrl = "jdbc:sqlserver://MDCH-QA-TRAIN2";
    private String user = "sa";
    private String pass = "MDCH-TRAIN2SA";

    private DatabaseConnection() throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, user, pass);
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
}