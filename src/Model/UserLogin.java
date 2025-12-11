package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLogin {

    // Create the table if it doesn't exist
    public static void initialize() {
        String sql =
                "CREATE TABLE IF NOT EXISTS users (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "username TEXT UNIQUE," +
                        "password TEXT" +
                        ");";

        // connect to the database
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // creates the user table
            stmt.execute();
            //System.out.println("Users table ready.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // registers a new user
    public static boolean registerUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // uses the first box for username, second for the password
            stmt.setString(1, username);
            stmt.setString(2, password);

            // update the user table
            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            // username already exists/error
            return false;
        }
    }


    // validate the login
    public static boolean validateLogin(String username, String password) {
        // sql query for the username and password
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // SQL SELECT * FROM users WHERE username = '' AND password = '';
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            // true if match found
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
