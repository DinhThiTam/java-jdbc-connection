package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbcConnection.MySQLConnection;

public class MySQLTest {
	static Connection conn;

	public static void main(String[] args) throws SQLException {
		
		conn = MySQLConnection.getMySQLConnection();
		
		System.out.println("Opened connection: " + conn);
		
		Statement statement = conn.createStatement();
		
		String sql = "Select Emp.EMP_ID, Emp.FIRST_NAME, Emp.LAST_NAME, Emp.DEPT_ID From Employee Emp;";
		
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			int empId = rs.getInt(1);
			String empFirstName = rs.getString(2);
			String empLastName = rs.getString(3);
			int deptId = rs.getInt(4);
			
			System.out.println("****************");
			System.out.println("Emp ID: " + empId);
			System.out.println("Emp FirstName: " + empFirstName);
			System.out.println("Emp LastName: " + empLastName);
			System.out.println("Department ID: " + deptId);
		}
		
		conn.close();
	}

}
