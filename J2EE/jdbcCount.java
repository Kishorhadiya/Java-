import java.sql.*;

public class jdbcCount {

     public static void main(String[] args) {
         
         Connection conn = null;
         Statement stmt = null;


          try{
                   
          String url = "jdbc:mysql://localhost:3306/Company";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn=DriverManager.getConnection(url,"root","root");

                String sql="jdbc:mysql://localhost:3306/compnay";
                  stmt=conn.createStatement();
                  ResultSet rs=stmt.executeQuery("Select count(*) from emp");

                        if(rs.next())
                        {
                            int count = rs.getInt(1);
                            System.out.println("Total number of employees: " + count);

                        }

                        else{
                            System.out.println("No records found");
                        }
                



          }

          catch(Exception e) {
              e.printStackTrace();
          }
     }
}
    