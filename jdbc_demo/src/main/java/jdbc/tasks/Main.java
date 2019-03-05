package jdbc.tasks;

import populators.PopulateData;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
Practice: CRUD operations using java

Problem_1_Read: Create a method which will return result of any given Read query (select * from Sales where ..)
taking into account that number of columns may vary.

Problem_2_Update: Update table and double quantity of all orders.

Problem_3_Delete: DELETE all rows with price less than 160.00.

Problem_4 Insert: INSERT a new row with the following data (26280,110567,1,905,140.90,0.00,'3','2008-06-01 00:00:00.000').

Problem_5_Bulk_insert: Create a CSV file (100 rows) with data and insert all data to "Sales" table using bulk insert.
 */

public class Main {
    public static void main(String[] args) throws SQLException {

        //populates random data in .csv
        new PopulateData().moreData("data.csv", 999);

        String dbUrl = "jdbc:sqlserver://MDCH-QA-TRAIN2";
        String user = "sa";
        String pass = "MDCH-TRAIN2SA";
        String destinationTable = "AdventureWorksLT_YBakhtina.SalesLT.Sales";

        //sets up connection with database
        java.sql.Connection myCon = DriverManager.getConnection(dbUrl, user, pass);
        Statement myStmt = myCon.createStatement();

        //tasks
        new SelectQuery().selectAllSales(myStmt, destinationTable);
        new UpdateQuery().updadeOrderQty(myStmt, destinationTable);
        new DeleteQuery().deleteOrders(myStmt, destinationTable);
        new InsertQuery().populateDataInSales(myStmt, destinationTable);
        new BulkInsert().hereComesThatData(myCon, myStmt, destinationTable);

        myStmt.close();
        myCon.close();
    }
}
