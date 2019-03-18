package jdbc.tasks.crud;

import java.sql.*;

public class SelectQuery {
    public void selectColors(Statement statement, String tablename) throws SQLException {
        ResultSet select = statement.executeQuery("SELECT Color FROM " + tablename + " GROUP BY Color");

        while (select.next()) {
            System.out.println(select.getString("color"));
        }
    }

    public void selectAllProducts(Statement statement, String tablename) throws SQLException {
        ResultSet select = statement.executeQuery("SELECT * FROM " + tablename);
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

    public void selectAllSales(Statement statement, String tablename) throws SQLException {
        ResultSet select = statement.executeQuery("select * from " + tablename);
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
