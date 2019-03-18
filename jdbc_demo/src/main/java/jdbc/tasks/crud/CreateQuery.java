package jdbc.tasks.crud;

import java.sql.*;

public class CreateQuery {
    public void createTable(Statement statement, String tablename) throws SQLException {
        String sql = "CREATE TABLE " + tablename + " (" +
                "SalesOrderID int NOT NULL," +
                "SalesOrderDetailID int NOT NULL," +
                "OrderQty smallint NOT NULL," +
                "ProductID int NOT NULL," +
                "UnitPrice decimal(15,2) NOT NULL," +
                "UnitPriceDiscount decimal(15,2) NOT NULL," +
                "rowguid int NOT NULL," +
                "ModifiedDate datetime NOT NULL );";

        statement.executeUpdate(sql);
    }
}
