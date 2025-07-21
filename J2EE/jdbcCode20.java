import java.sql.*;

public class jdbcCode20 {
    public static void main(String[] args) {
        // Replace with your own DB credentials and DB name
        String url = "jdbc:mysql://localhost:3306/store"; // Your DB name
        String user = "root";
        String password = ""; // Replace with your actual password

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection con = DriverManager.getConnection(url, user, password);

            // Get database metadata
            DatabaseMetaData meta = con.getMetaData();

            // Display basic metadata
            System.out.println("Database Product Name: " + meta.getDatabaseProductName());
            System.out.println("Database Product Version: " + meta.getDatabaseProductVersion());
            System.out.println("Driver Name: " + meta.getDriverName());
            System.out.println("Driver Version: " + meta.getDriverVersion());
            System.out.println("User Name: " + meta.getUserName());

            // List all tables in the database
            System.out.println("\n--- List of Tables ---");
            ResultSet tables = meta.getTables(null, null, "%", new String[]{"TABLE"});
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("Table: " + tableName);
            }

            // Close connections
            tables.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
