import java.io.*;
import java.nio.file.Paths;
import java.sql.*;
import java.sql.Connection;

public class BulkInsert {
    public void speedInsert(Connection connection) throws FileNotFoundException {
        String filePath = Paths.get("data.csv").toAbsolutePath().toString();
        try {
            String querySetLimit = "SET GLOBAL max_allowed_packet=104857600;";  // 10 MB
            Statement stSetLimit = connection.createStatement();
            // stSetLimit.execute(querySetLimit);

            String sql = "INSERT INTO [AdventureWorksLT_MNegaliuc].[SalesLT].[Sales] " +
                    "(SalesOrderID,SalesOrderDetailID,OrderQty,ProductID,UnitPrice,UnitPriceDiscount,rowguid,ModifiedDate) " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2, "2");
            statement.setString(3, "3");
            statement.setString(4, "4");
            statement.setString(5, "5");
            statement.setString(1, "1");
            statement.setString(6, "6");
            statement.setString(7, "7");
            statement.setString(8, "2008-06-01 00:00:00.000");
            InputStream inputStream = new FileInputStream(new File(filePath));

            statement.setBlob(1, inputStream);

            int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("A product was added");
            }
            connection.close();
            inputStream.close();
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
