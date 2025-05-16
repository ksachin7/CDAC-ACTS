import java.sql.*;

public class DbConnect {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver loaded successfully.");

            // Establish the initial connection to create the database
            con = DriverManager.getConnection("jdbc:mysql://db:3306?useSSL=false&allowPublicKeyRetrieval=true", "root", "pass");
            stmt = con.createStatement();
            System.out.println("Initial database connection established.");

            // Create the database if it does not exist
            String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS cdac";
            stmt.executeUpdate(createDatabaseSQL);
            System.out.println("Database 'cdac' created or already exists.");

            // Close the initial statement and connection
            if (stmt != null) stmt.close();
            if (con != null) con.close();
            System.out.println("Initial connection closed.");

            // Establish the connection to the newly created database
            con = DriverManager.getConnection("jdbc:mysql://db:3306/cdac?useSSL=false&allowPublicKeyRetrieval=true", "root", "pass");
            System.out.println("Connected to 'cdac' database.");

            // Create the student table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS student ("
                    + "PRN INT NOT NULL PRIMARY KEY, "
                    + "student_name CHAR(50), "
                    + "course CHAR(30)"
                    + ")";
            stmt = con.createStatement();
            stmt.execute(createTableSQL);
            System.out.println("Table 'student' created or already exists.");

            // Insert SQL statement
            String insertSQL = "INSERT INTO student VALUES (?, ?, ?)";
            pstmt = con.prepareStatement(insertSQL);

            // Insert three rows
            pstmt.setInt(1, 1);
            pstmt.setString(2, "Student 1");
            pstmt.setString(3, "DAC");
            pstmt.executeUpdate();
            System.out.println("Inserted record for PRN: 1");

            pstmt.setInt(1, 2);
            pstmt.setString(2, "Student 2");
            pstmt.setString(3, "DITISS");
            pstmt.executeUpdate();
            System.out.println("Inserted record for PRN: 2");

            pstmt.setInt(1, 3);
            pstmt.setString(2, "Student 3");
            pstmt.setString(3, "DAI");
            pstmt.executeUpdate();
            System.out.println("Inserted record for PRN: 3");

            // Select SQL statement
            String preparedSQL = "SELECT prn, student_name, course FROM student";
            pstmt = con.prepareStatement(preparedSQL);

            // Execute the select query
            rs = pstmt.executeQuery();
            System.out.println("\nStudent Data:");
            while (rs.next()) {
                int prn = rs.getInt("prn");
                String name = rs.getString("student_name");
                String course = rs.getString("course");
                System.out.println("PRN: " + prn + ", Name: " + name + ", Course: " + course);
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Error: MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQLException occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources in a finally block to ensure they are always closed
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
