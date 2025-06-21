import java.sql.*;

public class JdbcExample {

  public static void main(String[] args) {
    String url = "jdbc:sqlite:test.db"; // SQLite DB file

    try (Connection conn = DriverManager.getConnection(url)) {
      if (conn != null) {
        // Create table if not exists
        String createTableSQL =
          "CREATE TABLE IF NOT EXISTS users (" +
          "id INTEGER PRIMARY KEY AUTOINCREMENT," +
          "name TEXT NOT NULL," +
          "email TEXT NOT NULL UNIQUE)";
        try (Statement stmt = conn.createStatement()) {
          stmt.execute(createTableSQL);
          System.out.println("Table created or already exists.");
        }

        // Insert some data
        String insertSQL = "INSERT INTO users(name, email) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
          pstmt.setString(1, "Alice");
          pstmt.setString(2, "alice@example.com");
          pstmt.executeUpdate();

          pstmt.setString(1, "Bob");
          pstmt.setString(2, "bob@example.com");
          pstmt.executeUpdate();

          System.out.println("Inserted data.");
        } catch (SQLException e) {
          // ignore duplicates or errors for repeated runs
          System.out.println(
            "Insert might have failed (likely duplicates): " + e.getMessage()
          );
        }

        // Query and print data
        String selectSQL = "SELECT * FROM users";
        try (
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(selectSQL)
        ) {
          System.out.println("Users in DB:");
          while (rs.next()) {
            System.out.println(
              rs.getInt("id") +
              "\t" +
              rs.getString("name") +
              "\t" +
              rs.getString("email")
            );
          }
        }
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
