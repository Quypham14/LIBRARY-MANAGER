package manager;

import utils.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class DocumentManager {
    private static final Scanner sc = new Scanner(System.in);

    public static void viewAll() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = """
                    SELECT d.document_id, d.title, a.name AS author_name,
                           p.name AS publisher_name, d.publication_year,
                           d.category, d.total_copies, d.available_copies, d.price
                    FROM documents d
                    LEFT JOIN authors a ON d.author_id = a.id
                    LEFT JOIN publishers p ON d.publisher_id = p.publisher_id
                    """;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("=== Document List ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("document_id")
                        + " | Title: " + rs.getString("title")
                        + " | Author: " + rs.getString("author_name")
                        + " | Publisher: " + rs.getString("publisher_name")
                        + " | Year: " + rs.getInt("publication_year")
                        + " | Category: " + rs.getString("category")
                        + " | Total: " + rs.getInt("total_copies")
                        + " | Available: " + rs.getInt("available_copies")
                        + " | Price: $" + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving documents: " + e.getMessage());
        }
    }

    public static void add() {
        System.out.print("Enter document title: ");
        String title = sc.nextLine();
        System.out.print("Enter author ID: ");
        int authorId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter publisher ID: ");
        int publisherId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter publication year: ");
        int year = Integer.parseInt(sc.nextLine());
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        System.out.print("Enter total copies: ");
        int total = Integer.parseInt(sc.nextLine());
        System.out.print("Enter available copies: ");
        int available = Integer.parseInt(sc.nextLine());
        System.out.print("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());

        try (Connection conn = DBConnection.getConnection()) {
            String sql = """
                    INSERT INTO documents(title, author_id, publisher_id, publication_year,
                    category, total_copies, available_copies, price)
                    VALUES(?, ?, ?, ?, ?, ?, ?, ?)
                    """;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setInt(2, authorId);
            stmt.setInt(3, publisherId);
            stmt.setInt(4, year);
            stmt.setString(5, category);
            stmt.setInt(6, total);
            stmt.setInt(7, available);
            stmt.setDouble(8, price);
            stmt.executeUpdate();
            System.out.println("Document added!");
        } catch (SQLException e) {
            System.out.println("Error adding document: " + e.getMessage());
        }
    }

    public static void update() {
        System.out.print("Enter document ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new title: ");
        String title = sc.nextLine();
        System.out.print("Enter new author ID: ");
        int authorId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new publisher ID: ");
        int publisherId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new publication year: ");
        int year = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new category: ");
        String category = sc.nextLine();
        System.out.print("Enter new total copies: ");
        int total = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new available copies: ");
        int available = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new price: ");
        double price = Double.parseDouble(sc.nextLine());

        try (Connection conn = DBConnection.getConnection()) {
            String sql = """
                    UPDATE documents SET title = ?, author_id = ?, publisher_id = ?,
                    publication_year = ?, category = ?, total_copies = ?, available_copies = ?, price = ?
                    WHERE document_id = ?
                    """;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setInt(2, authorId);
            stmt.setInt(3, publisherId);
            stmt.setInt(4, year);
            stmt.setString(5, category);
            stmt.setInt(6, total);
            stmt.setInt(7, available);
            stmt.setDouble(8, price);
            stmt.setInt(9, id);
            stmt.executeUpdate();
            System.out.println("Document updated!");
        } catch (SQLException e) {
            System.out.println("Error updating document: " + e.getMessage());
        }
    }

    public static void delete() {
        System.out.print("Enter document ID: ");
        int id = Integer.parseInt(sc.nextLine());

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM documents WHERE document_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Document deleted!");
        } catch (SQLException e) {
            System.out.println("Error deleting document: " + e.getMessage());
        }
    }
}
