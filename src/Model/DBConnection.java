package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // load the jdbc driver and open the database file at this URL
    private static final String URL = "jdbc:sqlite:src/database/store.db";

    //connects to database or prints the error message
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}