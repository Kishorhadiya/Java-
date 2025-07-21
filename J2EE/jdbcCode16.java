import java.sql.*;

public class jdbcCode16 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company1";
        String user = "root";
        String password = ""; 

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");  

            // Establish connection and prepare callable statement using try-with-resources
            try (Connection con = DriverManager.getConnection(url, user, password);
                 CallableStatement stmt = con.prepareCall("{CALL insert_employee(?,?,?)}")) {

                // insert values in procedure
                stmt.setString(1, "meet");
                stmt.setString(2,"BCA");
                stmt.setDouble(3, 50000.00);

                // Execute the stored procedure
                stmt.execute();

                System.out.println("parameters base  employee inserted successfully.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
