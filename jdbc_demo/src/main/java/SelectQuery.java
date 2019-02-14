import java.sql.*;

public class SelectQuery {
    public void selectColors(Statement statement) throws SQLException {
        ResultSet select = statement.executeQuery("SELECT Color FROM [AdventureWorksLT_MNegaliuc].[SalesLT].[Product] GROUP BY Color");

        while (select.next()) {
            System.out.println(select.getString("color"));
        }
    }

    public void selectAllProducts(Statement statement) throws SQLException {
        ResultSet select = statement.executeQuery("SELECT * FROM [AdventureWorksLT_MNegaliuc].[SalesLT].[Product]");
        ResultSetMetaData md = select.getMetaData();
        int colCount = md.getColumnCount();

        for (int i = 1; i <= colCount; i++) {
            String col_name = md.getColumnName(i);
            System.out.print(col_name + "\t");
        }

        while (select.next()) {
            for (int i = 1; i <= colCount; i++) {
                String col_name = md.getColumnName(i);
                System.out.print(select.getString(col_name) + "\t");
            }
            System.out.println();
        }
    }

    public void selectAllSales(Statement statement) throws SQLException {
        ResultSet select = statement.executeQuery("select * from [AdventureWorksLT_MNegaliuc].[SalesLT].[Sales]");
        ResultSetMetaData md = select.getMetaData();
        int colCount = md.getColumnCount();

        while (select.next()) {
            for (int i = 1; i <= colCount; i++) {
                String col_name = md.getColumnName(i);
                System.out.print(select.getString(col_name) + "\t");
            }
            System.out.println();
        }
    }
}
