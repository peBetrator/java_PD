import java.sql.*;

public class UpdateQuery {
    public void update(Statement statement) throws SQLException {
        int rowsAffected = statement.executeUpdate(
                "UPDATE [AdventureWorksLT_MNegaliuc].[SalesLT].[Product] " +
                        "SET Name='NEW_NAME', ModifiedDate=CURRENT_TIMESTAMP " +
                        "WHERE ModifiedDate='2012-10-10 10:01:36.000'");
    }

    public void updadeOrderQty(Statement statement) throws SQLException {
        int rowsAffecte = statement.executeUpdate("UPDATE [AdventureWorksLT_MNegaliuc].[SalesLT].[Sales] SET OrderQty = OrderQty*2");
    }

    public void readFromFile(Statement statement){

    }
}
