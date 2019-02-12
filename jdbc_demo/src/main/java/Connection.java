import java.sql.*;
public class Connection {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:sqlserver://MDCH-QA-TRAIN2";
        String user = "sa";
        String pass = "MDCH-TRAIN2SA";
//        String name = "AdventureWorksLT_MNegaliuc";

            java.sql.Connection myCon = DriverManager.getConnection(dbUrl,user,pass);
            Statement myStmt = myCon.createStatement();
            ResultSet myRes = myStmt.executeQuery("SELECT Color FROM [AdventureWorksLT_MNegaliuc].[SalesLT].[Product] GROUP BY Color");

            while(myRes.next()){
                System.out.println(myRes.getString("color"));
            }

    }
}
