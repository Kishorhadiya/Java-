import java.sql.*;

public class jdbcPreparedDemo {

    public static void main(String[] args)
    {

        try{  

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Company";
            Connection conn = DriverManager.getConnection(url, "root", "");

             
             //create a PreparedStatement
 
                    //   String sql="insert into stud values(?,?,?,?,?)";

                    //   String sql="Delete from stud  where rollno=?";

                  String sql="select * from stud where firstname=? ;";

               PreparedStatement st=conn.prepareStatement(sql);

                st.setString(1, "shani");

                ResultSet rs = st.executeQuery();
             while(rs.next())
             {
                 System.out.println("Roll no "+ rs.getInt(1));
                 System.out.println("Roll no "+ rs.getString(2));
                 System.out.println("Roll no "+ rs.getString(3));
                 System.out.println("Roll no "+ rs.getString(4));
                 System.out.println("Roll no "+ rs.getString(5));

             }






                //set the values for the PreparedStatement

                // st.setInt(1, 1);
                // st.setString(2,"kishor");
                // st.setString(3,"hadiya");
                // st.setString(4,"BCA");
                // st.setInt(5, 5);

                // st.setInt(1, 3);
              
      
                 //user input for the values
                 
                //  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                // System.out.println("Enter Employee Number:");
                // int empno = Integer.parseInt(br.readLine());

                // System.out.println("Enter Employee Name:");
                // String empnm = br.readLine();

                // System.out.println("Enter Designation:");
                // String designation = br.readLine();


                // System.out.println("Enter City:");
                // String city = br.readLine();

                // System.out.println("Enter Salary:");
                // double salary = Double.parseDouble(br.readLine());  

                // System.out.println("Enter Department:");
                // String department = br.readLine();  

                //     st.setInt(1, empno);
                // st.setString(2, empnm);
                // st.setString(3, designation);
                // st.setString(4, city);
                // st.setDouble(5, salary);
                // st.setString(6, department);




          // st.executeUpdate();

                if(st.executeUpdate() > 0)
                {
                    System.out.println("Record inserted successfully");
                }
                else
                {
                    System.out.println("Failed to insert record");
                }

               

        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}