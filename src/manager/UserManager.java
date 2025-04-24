package manager;

import model.User;
import utils.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class UserManager {
    private static Scanner sc = new Scanner(System.in);

    public static User login(String username, String password) {
        // Kết nối cơ sở dữ liệu
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username); // Set username vào câu truy vấn
            stmt.setString(2, password); // Set password vào câu truy vấn
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Nếu tìm thấy người dùng trong cơ sở dữ liệu
                System.out.println("Login successful!");
                return new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
                );
            } else {
                // Nếu không tìm thấy người dùng
                System.out.println("Invalid username or password!");
            }
        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
        }
        return null; // Trả về null nếu đăng nhập không thành công
    }
}

