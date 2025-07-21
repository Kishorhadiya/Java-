
import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


 public class jdbc22
 {
       public static void main(String[] args)
       {
          Connection conn=null;
          Statement stmt=null;
          preparedStatement ps=null;
          
 
            String url="jdbc:mysql://localhost:3306/company";



          try   
          {
              Class.forName("com.mysql.cj.jdbc.Driver");
              conn=DriverManager.getConnection(url,"root","");

              String sql="select * from emp where empno=?";

              

          }

          catch()
          {

          }
          
          
       } 
 }
