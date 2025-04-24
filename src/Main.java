import model.User;
import manager.UserManager;
import manager.AuthorManager;
import manager.DocumentManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đăng nhập
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User currentUser = UserManager.login(username, password);

        if (currentUser != null) {
            System.out.println("Welcome, " + currentUser.getUsername() + " (" + currentUser.getRole() + ")");

            if (currentUser.getRole().equals("admin") || currentUser.getRole().equals("staff")) {
                adminOrStaffMenu(sc);
            } else if (currentUser.getRole().equals("reader")) {
                readerMenu(sc);
            } else {
                System.out.println("Access denied: You do not have permission.");
            }
        } else {
            System.out.println("Login failed.");
        }
    }

    private static void adminOrStaffMenu(Scanner sc) {
        while (true) {
            System.out.println("\n=== Management Menu ===");
            System.out.println("1. Manage Authors");
            System.out.println("2. Manage Documents");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int choice = getIntInput(sc);
            switch (choice) {
                case 1:
                    manageAuthors(sc);
                    break;
                case 2:
                    manageDocuments(sc);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void readerMenu(Scanner sc) {
        while (true) {
            System.out.println("\n=== Reader Menu ===");
            System.out.println("1. View Authors");
            System.out.println("2. View Documents");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int choice = getIntInput(sc);
            switch (choice) {
                case 1:
                    AuthorManager.viewAll();
                    break;
                case 2:
                    DocumentManager.viewAll();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void manageAuthors(Scanner sc) {
        System.out.println("\n-- Author Menu --");
        System.out.println("1. View All");
        System.out.println("2. Add Author");
        System.out.println("3. Update Author");
        System.out.println("4. Delete Author");
        System.out.print("Your choice: ");

        int choice = getIntInput(sc);
        switch (choice) {
            case 1:
                AuthorManager.viewAll();
                break;
            case 2:
                AuthorManager.add();
                break;
            case 3:
                AuthorManager.update();
                break;
            case 4:
                AuthorManager.delete();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void manageDocuments(Scanner sc) {
        System.out.println("\n-- Document Menu --");
        System.out.println("1. View All");
        System.out.println("2. Add Document");
        System.out.println("3. Update Document");
        System.out.println("4. Delete Document");
        System.out.print("Your choice: ");

        int choice = getIntInput(sc);
        switch (choice) {
            case 1:
                DocumentManager.viewAll();
                break;
            case 2:
                DocumentManager.add();
                break;
            case 3:
                DocumentManager.update();
                break;
            case 4:
                DocumentManager.delete();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static int getIntInput(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1; // Giá trị không hợp lệ
        }
    }
}
