import java.sql.*;

public class Connection {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:sqlserver://MDCH-QA-TRAIN2";
        String user = "sa";
        String pass = "MDCH-TRAIN2SA";

        java.sql.Connection myCon = DriverManager.getConnection(dbUrl, user, pass);
        Statement myStmt = myCon.createStatement();

        new DeleteQuery().deleteOrders(myStmt);
    }
}
