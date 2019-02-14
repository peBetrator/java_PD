import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQuery {
    public void deleteOrders(Statement statement) throws SQLException {
        int rowsAffected = statement.executeUpdate("DELETE FROM [AdventureWorksLT_MNegaliuc].[SalesLT].[Sales] WHERE UnitPrice < '160'");
    }
}
