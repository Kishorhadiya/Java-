// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;

// public class jdbcUpdatePrepare {

//     public static void main(String[] args) {

//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             String url = "jdbc:mysql://localhost:3306/Company";
//             Connection conn = DriverManager.getConnection(url, "root", "");

//             // String sql = "UPDATE Stud SET firstname = ?, lastname = ?, course = ?, semester = ? WHERE rollno = ?";
 
//              String sql="DELETE FROM stud WHERE rollno = ?";

//             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//             // System.out.println("Enter First Name:");
//             // String firstName = br.readLine();

//             // System.out.println("Enter Last Name:");
//             // String lastName = br.readLine();

//             // System.out.println("Enter Course:");
//             // String course = br.readLine();

//             // System.out.println("Enter Semester:");
//             // String semester = br.readLine();

//             System.out.println("Enter Roll Number:");
//             int rollno = Integer.parseInt(br.readLine());

//             PreparedStatement pstm = conn.prepareStatement(sql);

            
//             // pstm.setString(1, firstName);
//             // pstm.setString(2, lastName);
//             // pstm.setString(3, course);
//             // pstm.setString(4, semester);

//             pstm.setInt(1, rollno);

//             pstm.executeUpdate();
//             System.out.println("Record updated successfully");

//             conn.close();

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }



 // Delete code for 

 import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class jdbcUpdatePrepare {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Company";
            Connection conn = DriverManager.getConnection(url, "root", "");

            String sql = "DELETE FROM stud WHERE rollno = ?";

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter Roll Number:");
            int rollno = Integer.parseInt(br.readLine());

            PreparedStatement pstm = conn.prepareStatement(sql);

            // ✅ Correct parameter index
            pstm.setInt(1, rollno);

            int result = pstm.executeUpdate();

            if (result > 0) {
                System.out.println("Record deleted successfully");
            } else {
                System.out.println("No record found with that roll number");
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
