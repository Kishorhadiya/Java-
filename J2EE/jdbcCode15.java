import java.sql.*;

public class jdbcCode15 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company1";
        String user = "root";
        String password = ""; 

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Prepare callable statement
            CallableStatement stmt = con.prepareCall("{CALL p1()}");

            // Execute the stored procedure
            stmt.execute();

            System.out.println("Default employee inserted successfully.");

            // Close resources
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
