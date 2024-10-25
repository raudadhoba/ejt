/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatefulEjbClass.java to edit this template
 */
package MyPkg;

import jakarta.ejb.Stateful;
import jakarta.ejb.LocalBean;
import java.util.*;
import java.sql.*;
import jakarta.ejb.*;
/**
 *
 * @author HP
 */
@Stateful
@LocalBean
public class ShoppingCart {

    private List<String> contents = new ArrayList<>();
    private String customerName;
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // Initialize customer and connect to the database
    public void initialize(String person) {
        if (person != null) {
            customerName = person;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  // Updated driver
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/cartdb", 
                        "root", 
                        "root");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Failed to connect to the Database: " + e.getMessage());
            }
        }
    }

    // Add book to the cart
    public void addBook(String title) {
        String query = "INSERT INTO cart (UserName, ItemName) VALUES (?, ?)";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, customerName);
            stmt.setString(2, title);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to insert values: " + e.getMessage());
        } finally {
            closeStatement();
        }
    }

    // Remove book from the cart
    public void removeBook(String title) {
        String query = "DELETE FROM cart WHERE UserName = ? AND ItemName = ?";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, customerName);
            stmt.setString(2, title);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to delete values: " + e.getMessage());
        } finally {
            closeStatement();
        }
    }

    // Retrieve the cart contents
    public List<String> getContents() {
        String query = "SELECT ItemName FROM cart WHERE UserName = ?";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, customerName);
            rs = stmt.executeQuery();
            while (rs.next()) {
                contents.add(rs.getString("ItemName"));
            }
        } catch (SQLException e) {
            System.err.println("Failed to fetch contents: " + e.getMessage());
        } finally {
            closeResultSet();
            closeStatement();
        }
        return contents;
    }

    // Remove bean state
    @Remove
    public void remove() {
        contents = null;
        closeConnection();
    }

    // Helper method to close ResultSet
    private void closeResultSet() {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            System.err.println("Failed to close ResultSet: " + e.getMessage());
        }
    }

    // Helper method to close PreparedStatement
    private void closeStatement() {
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            System.err.println("Failed to close Statement: " + e.getMessage());
        }
    }

    // Helper method to close Connection
    private void closeConnection() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.err.println("Failed to close Connection: " + e.getMessage());
        }
    }
}
