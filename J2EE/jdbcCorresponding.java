import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class jdbcCorresponding {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/company"; // Your DB name
        String user = "root"; // DB username
        String password = "root"; // DB password

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");  
            
            // Establish connection
            conn = DriverManager.getConnection(url, user, password);

            // Read input from user
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter employee number: ");
            int empno = Integer.parseInt(reader.readLine());
            
            // Prepare SQL query
            String query = "SELECT * FROM emp WHERE empno = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, empno);

            // Execute query
            rs = ps.executeQuery();

            // Check if data found
            if (rs.next()) {
                System.out.println("\nEmployee Record Found:");
                System.out.println("Employee Number: " + rs.getInt("empno"));
                System.out.println("Employee Name: " + rs.getString("empnm"));
                System.out.println("Designation: " + rs.getString("designation"));
                System.out.println("City: " + rs.getString("city"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("Department: " + rs.getString("department"));
            } else {
                System.out.println("No employee found with empno: " + empno);
            }

        } catch (Exception e) {
            e.printStackTrace();
       
    }
}
}

