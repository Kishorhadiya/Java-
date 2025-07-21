import java.sql.*;

public class jdbcCode17 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company1";
        String user = "root";
        String password = ""; // Replace with your MySQL password

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database and prepare the callable statement using try-with-resources
            try (Connection con = DriverManager.getConnection(url, user, password);
                 CallableStatement stmt = con.prepareCall("{CALL get_desi(?, ?)}")) {

                // Set input parameter (empno)
                stmt.setInt(1, 2); // Change empno as needed

                // Register output parameter (designation)
                stmt.registerOutParameter(2, Types.VARCHAR);

                // Execute the procedure
                stmt.execute();

                // Retrieve the output value
                String designation = stmt.getString(2);

                System.out.println("Employee Designation: " + designation);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
