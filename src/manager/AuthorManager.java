package manager;

import utils.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class AuthorManager {
    private static final Scanner sc = new Scanner(System.in);

    public static void viewAll() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM authors";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("=== Author List ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " - Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving authors: " + e.getMessage());
        }
    }

    public static void add() {
        System.out.print("Enter author name: ");
        String name = sc.nextLine();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO authors(name) VALUES(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.executeUpdate();
            System.out.println("Author added!");
        } catch (SQLException e) {
            System.out.println("Error adding author: " + e.getMessage());
        }
    }

    public static void update() {
        System.out.print("Enter author ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new name: ");
        String name = sc.nextLine();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE authors SET name = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Author updated!");
        } catch (SQLException e) {
            System.out.println("Error updating author: " + e.getMessage());
        }
    }

    public static void delete() {
        System.out.print("Enter author ID: ");
        int id = Integer.parseInt(sc.nextLine());

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM authors WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Author deleted!");
        } catch (SQLException e) {
            System.out.println("Error deleting author: " + e.getMessage());
        }
    }
}
