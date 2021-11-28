package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import jdbcConnection.SQLJTDSConnection;

public class SQLJTDSTest {

	public static void main(String[] args) throws SQLException {

			Connection conn =  SQLJTDSConnection.getMySQLConnection();
		
		
		System.out.println("Opened connection: " + conn);
		
		Statement statement = conn.createStatement();
		
		String sql = "Select EMP_ID, FIRST_NAME, LAST_NAME, DEPT_ID FROM [automationfc].[dbo].[EMPLOYEE];";
		
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
		System.out.println("------- Closed connection -----------");
	}
}
