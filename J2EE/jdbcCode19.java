import java.sql.*;
import java.util.Scanner;

public class jdbcCode19 {
    static final String URL = "jdbc:mysql://localhost:3306/store";
    static final String USER = "root";
    static final String PASSWORD = ""; // Replace with your MySQL root password

    static Connection con;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            int choice;
            do {
                System.out.println("\n------ PRODUCT CRUD MENU ------");
                System.out.println("1. Insert Product");
                System.out.println("2. View All Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1: insertProduct(); break;
                    case 2: viewProducts(); break;
                    case 3: updateProduct(); break;
                    case 4: deleteProduct(); break;
                    case 5: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid choice.");
                }
            } while (choice != 5);

            con.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void insertProduct() throws SQLException {
        System.out.print("Enter product ID: ");
        int pid = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        String sql = "INSERT INTO product VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, pid);
        ps.setString(2, name);
        ps.setDouble(3, price);
        ps.setInt(4, qty);

        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("Product inserted successfully.");
        ps.close(); 
    }

    static void viewProducts() throws SQLException {
        String sql = "SELECT * FROM product";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("\n--- Product List ---");
        System.out.printf("%-5s %-20s %-10s %-10s%n", "ID", "Name", "Price", "Qty");
        System.out.println("----------------------------------------------");
        while (rs.next()) {
            int id = rs.getInt("pid");
            String name = rs.getString("productname");
            double price = rs.getDouble("price");
            int qty = rs.getInt("quantity");
            System.out.printf("%-5d %-20s %-10.2f %-10d%n", id, name, price, qty);
        }
        rs.close();
        st.close();
    }

    static void updateProduct() throws SQLException {
        System.out.print("Enter product ID to update: ");
        int pid = sc.nextInt();
        System.out.print("Enter new price: ");
        double price = sc.nextDouble();
        System.out.print("Enter new quantity: ");
        int qty = sc.nextInt();

        String sql = "UPDATE product SET price = ?, quantity = ? WHERE pid = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, price);
        ps.setInt(2, qty);
        ps.setInt(3, pid);

        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("Product updated successfully.");
        else
            System.out.println("Product not found.");
        ps.close();
    }

    static void deleteProduct() throws SQLException {
        System.out.print("Enter product ID to delete: ");
        int pid = sc.nextInt();

        String sql = "DELETE FROM product WHERE pid = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, pid);

        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("Product deleted successfully.");
        else
            System.out.println("Product not found.");
        ps.close();
    }
}
