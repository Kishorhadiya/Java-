import  java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class jdbcAlong
{
     public static void main(String[] args) {
          
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/Company";
                Connection conn = DriverManager.getConnection(url, "root", "");


                //create a PreparedStatement

                  String sql="select empno,designation from emp where empno = ?";

                  PreparedStatement st=conn.prepareStatement(sql);

          
                //set the values for the PreparedStatement
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter Employee Number:");
                int empno = Integer.parseInt(br.readLine());
                st.setInt(1, empno);

                //execute the query
                ResultSet rs = st.executeQuery();
                //process the result set

                if(rs.next()) {
                    int empNoResult = rs.getInt("empno");
                    String designation = rs.getString("designation");
                    System.out.println("Employee Number: " + empNoResult);
                    System.out.println("Designation: " + designation);
                } else {
                    System.out.println("No employee found with empno: " + empno);
                }


         }
         catch(Exception e) {
             e.printStackTrace();
         }
     }
}
