package jdbc.tasks.crud;

import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQuery {
    public void deleteOrders(Statement statement, String tablename) throws SQLException {
        int rowsAffected = statement.executeUpdate("DELETE FROM " + tablename + " WHERE UnitPrice < '160'");
    }
}
