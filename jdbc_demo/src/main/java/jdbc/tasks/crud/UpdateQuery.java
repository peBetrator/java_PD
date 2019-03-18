package jdbc.tasks.crud;

import java.sql.*;

public class UpdateQuery {
    public void update(Statement statement, String tablename) throws SQLException {
        int rowsAffected = statement.executeUpdate(
                "UPDATE " + tablename +
                        " SET Name='NEW_NAME', ModifiedDate=CURRENT_TIMESTAMP " +
                        "WHERE ModifiedDate='2012-10-10 10:01:36.000'");
    }

    public void updadeOrderQty(Statement statement, String tablename) throws SQLException {
        int rowsAffecte = statement.executeUpdate("UPDATE " + tablename + " SET OrderQty = OrderQty*2");
    }
}
