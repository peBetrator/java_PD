import java.sql.*;

public class InsertQuery {
    public void populateDataInSales(Statement statement) throws SQLException {
        int rowsAffected = statement.executeUpdate("INSERT INTO [AdventureWorksLT_MNegaliuc].[SalesLT].[Sales] (SalesOrderID,SalesOrderDetailID,OrderQty,ProductID,UnitPrice,UnitPriceDiscount,rowguid,ModifiedDate)" +
                "values (26271,110562,1,836,356.89,0.00,'1','2008-06-01 00:00:00.000')," +
                "(26272,110563,1,822,356.89,0.00,'2','2008-06-01 00:00:00.000')," +
                "(26273,110567,1,907,163.90,0.00,'3','2008-06-01 00:00:00.000')," +
                "(26274,110616,4,905,218.45,0.00,'4','2008-06-01 00:00:00.000')," +
                "(26275,110617,2,983,461.69,0.00,'5','2008-06-01 00:00:00.000')," +
                "(26276,110618,6,988,112.99,0.40,'6','2008-06-01 00:00:00.000')," +
                "(26277,110619,2,748,818.70,0.00,'7','2008-06-01 00:00:00.000')," +
                "(26278,110620,1,990,323.99,0.00,'8','2008-06-01 00:00:00.000')," +
                "(26279,110621,1,926,149.87,0.00,'9','2008-06-01 00:00:00.000');");
    }
}
