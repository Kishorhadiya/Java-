import java.sql.*;
public class jdbcFirstLatter {

     public static void main(String[] args) {
         
         Connection conn = null;
         Statement stmt = null;

           String url="Jdbc:mysql://localhost:3306/Company";

        try{
             
              Class.forName("com.mysql.cj.jdbc.Driver");

              conn=DriverManager.getConnection(url, "root", "root");

              String sql="Select * from emp where empnm like 'A%'";

              stmt=conn.createStatement();
              ResultSet rs=stmt.executeQuery(sql);

               while(rs.next())
               {
                   String emp[]=new String[6];
                     emp[0]=String.valueOf(rs.getInt("empno"));
                        emp[1]=rs.getString("empnm");
                        emp[2]=rs.getString("designation");
                        emp[3]=rs.getString("city");                            
                        emp[4]=String.valueOf(rs.getInt("salary"));
                        emp[5]=rs.getString("Department");


                     System.out.println("Empno: " + emp[0] + ", Name: " + emp[1] + ", Designation: " + emp[2] +
                                          ", City: " + emp[3] + ", Salary: " + emp[4] + ", Department: " + emp[5]);

               }

              



        }

        catch(Exception e)
        {
            e.printStackTrace();
        }


         
}
}