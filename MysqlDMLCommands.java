package SeleniumPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlDMLCommands {

	public static void main(String[] args) throws SQLException {
		
		//1.creating a connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","root");
		
		//2.create statement/query
		Statement st=con.createStatement();
		
		//3.Execute statement/query
		//String s="INSERT INTO STUDENT VALUES(666,'TIGER1')";
		//String s = "UPDATE STUDENT SET SNAME='MAHESH' WHERE SNO=666";
		//String s = "DELETE FROM STUDENT WHERE SNO=666";
		String s="select emp_no,first_name,last_name from employees where emp_no=496777";
		
		ResultSet rs=st.executeQuery(s);
		
		while(rs.next()) {
			int empno = rs.getInt("EMP_NO");
			String fname = rs.getString("FIRST_NAME");
			String lname = rs.getString("LAST_NAME");
			
			System.out.println(empno+"    "+fname+"    "+lname );
		}
		
		//4.close connection.
		con.close();
		
		System.out.println("Query executeddd.......");

	}

}
