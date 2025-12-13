package Model;

import java.sql.*;
import java.util.ArrayList;



public class ItemRetriever {

    // Create item table if it doesn't exist
    public static void initialize() {
        String sql = """
                CREATE TABLE IF NOT EXISTS items (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT,
                    price REAL,
                    imagePath TEXT
                );
                """;

        //connect to database
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add a new item
    //TODO create a addItemView
    //TODO create a description
    public static void addItem(String name, double price, String imagePath) {
        //template for SQL to insert an item
        String sql = "INSERT INTO items (name, price, imagePath) VALUES (?, ?, ?)";

        //connects to database and sets new item to these parameters
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.setString(3, imagePath);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update an item
    public static void updateItem(int id, String name, double price, String imagePath) {
        //update item variables at this ID
        String sql = "UPDATE items SET name=?, price=?, imagePath=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.setString(3, imagePath);
            stmt.setInt(4, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete an item
    public static void deleteItem(int id) {
        String sql = "DELETE FROM items WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //creates an arrayList from the database of all items to be returned to the view and controller.
    public static ArrayList<ItemTemplate> getAllItems() {
        ArrayList<ItemTemplate> items = new ArrayList<>();

        //finds all items
        String sql = "SELECT * FROM items";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // turns items into a template
            while (rs.next()) {
                items.add(new ItemTemplate(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("imagePath")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //
        return items;
    }
}