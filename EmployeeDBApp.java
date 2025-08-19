import java.sql.*;
import java.util.Scanner;

public class EmployeeDBApp {
    // JDBC URL, username, password
    static final String URL = "jdbc:mysql://localhost:3306/companyDB";
    static final String USER = "root"; // change to your DB username
    static final String PASS = "password"; // change to your DB password

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("✅ Connected to Database!");

            while (true) {
                System.out.println("\n=== Employee Database Menu ===");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addEmployee(conn, sc);
                        break;
                    case 2:
                        viewEmployees(conn);
                        break;
                    case 3:
                        updateEmployee(conn, sc);
                        break;
                    case 4:
                        deleteEmployee(conn, sc);
                        break;
                    case 5:
                        System.out.println("👋 Exiting...");
                        sc.close();
                        return;
                    default:
                        System.out.println("❌ Invalid choice!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add Employee
    public static void addEmployee(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter department: ");
        String dept = sc.next();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, dept);
        pstmt.setDouble(3, salary);
        pstmt.executeUpdate();

        System.out.println("✅ Employee added successfully!");
    }

    // View Employees
    public static void viewEmployees(Connection conn) throws SQLException {
        String sql = "SELECT * FROM employees";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n--- Employee List ---");
        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("name") + " | " +
                rs.getString("department") + " | " +
                rs.getDouble("salary")
            );
        }
    }

    // Update Employee
    public static void updateEmployee(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        System.out.print("Enter new salary: ");
        double salary = sc.nextDouble();

        String sql = "UPDATE employees SET salary = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, salary);
        pstmt.setInt(2, id);
        int rows = pstmt.executeUpdate();

        if (rows > 0) {
            System.out.println("✅ Employee updated successfully!");
        } else {
            System.out.println("❌ Employee not found!");
        }
    }

    // Delete Employee
    public static void deleteEmployee(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM employees WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        int rows = pstmt.executeUpdate();

        if (rows > 0) {
            System.out.println("✅ Employee deleted successfully!");
        } else {
            System.out.println("❌ Employee not found!");
        }
    }
}
