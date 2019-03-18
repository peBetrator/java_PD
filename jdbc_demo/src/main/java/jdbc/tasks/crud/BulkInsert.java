package jdbc.tasks.crud;

import java.sql.*;

import com.microsoft.sqlserver.jdbc.SQLServerBulkCSVFileRecord;
import com.microsoft.sqlserver.jdbc.SQLServerBulkCopy;

public class BulkInsert {
    public void hereComesThatData(Connection connection, Statement statement, String destinationTable) {
        int countBefore, countAfter;

        // Get data from the source file by loading it into a class that implements ISQLServerBulkRecord.
        // Here we are using the SQLServerBulkCSVFileRecord implementation to import the example CSV file.
        try (SQLServerBulkCopy bulkCopy = new SQLServerBulkCopy(connection);
             SQLServerBulkCSVFileRecord fileRecord = new SQLServerBulkCSVFileRecord("data.csv", false)) {

            // Set the metadata for each column to be copied.
            fileRecord.addColumnMetadata(1, null, Types.INTEGER, 0, 0);
            fileRecord.addColumnMetadata(2, null, java.sql.Types.INTEGER, 0, 0);
            fileRecord.addColumnMetadata(3, null, Types.SMALLINT, 0, 0);
            fileRecord.addColumnMetadata(4, null, java.sql.Types.INTEGER, 0, 0);
            fileRecord.addColumnMetadata(5, null, Types.DECIMAL, 38, 0);
            fileRecord.addColumnMetadata(6, null, Types.DECIMAL, 38, 0);
            fileRecord.addColumnMetadata(7, null, Types.INTEGER, 0, 0);
            fileRecord.addColumnMetadata(8, null, Types.DATE, 50, 0);

            // Empty the destination table.
            statement.executeUpdate("DELETE FROM " + destinationTable);

            // Perform an initial count on the destination table.
            countBefore = getRowCount(statement, destinationTable);

            // Set up the bulk copy object.
            // Note that the column positions in the source
            // data reader match the column positions in
            // the destination table so there is no need to
            // map columns.
            bulkCopy.setDestinationTableName(destinationTable);

            // Write from the source to the destination.
            bulkCopy.writeToServer(fileRecord);

            // Perform a final count on the destination
            // table to see how many rows were added.
            countAfter = getRowCount(statement, destinationTable);
            System.out.println((countAfter - countBefore) + " rows were added.");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getRowCount(Statement stmt,
                            String tableName) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM " + tableName);
        rs.next();
        int count = rs.getInt(1);
        rs.close();
        return count;
    }
}