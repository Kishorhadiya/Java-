import java.sql.*;
import java.util.Scanner;

public class jdbcCode18 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company1";
        String user = "root";
        String password = ""; // Replace with your actual MySQL password

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter designation: ");
        String department = sc.nextLine();

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to DB
            Connection con = DriverManager.getConnection(url, user, password);

            // Call procedure that selects by designation
            CallableStatement stmt = con.prepareCall("{CALL get_employees_by_designation(?)}");
            stmt.setString(3, department);

            // Execute query
            ResultSet rs = stmt.executeQuery();

            // Print results
            boolean found = false;
            System.out.println("\nEmployees with designation: " + department);
            System.out.println("---------------------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                double salary = rs.getDouble("salary");

                System.out.printf("Id: %d, Name: %s, Designation: %s, Salary: %.2f%n",
                        id, name, dept, salary);
                found = true;
            }

            if (!found) {
                System.out.println("No employees found with that designation.");
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
