import java.sql.*;

 public  class jdbcInsertDemo
 {
     public static void main(String[] args) {
         Connection conn=null;  
         Statement stmt=null;         


         String url="jdbc:mysql://localhost:3306/Company";

         try
         {
                Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url,"root","");

                // String sql="insert into emp values(8,'dharul','cleark','pune',50000,'It')";
                // stmt=conn.createStatement();
                // int val=stmt.executeUpdate(sql);

                // if(val>0)
                // {
                //     System.out.println(val+"Record inserted successfully");
                // }
                // else
                // {
                //     System.out.println("Record not inserted");
                // }

                  
                 
                String sql="select * from emp where salary=(select max(salary) from emp)";

                stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                  while(rs.next())
                  {
                      System.out.println("ID: " + rs.getInt("empno"));
                      System.out.println("Name: " + rs.getString("empnm"));
                      System.out.println("Salary : " + rs.getDouble("salary"));
                  }
        
                
        }
        
         catch(Exception e)
         {
             e.printStackTrace();
         }
       
             
         }
     }
    

