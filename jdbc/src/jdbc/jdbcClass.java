package jdbc;

import java.sql.*;

public class jdbcClass {

	public static void main(String[] args) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","login_to_database","password_to_database");
			
			Statement myStmt = myConn.createStatement();
			
			ResultSet myRs = myStmt.executeQuery("select * from employees");
			
			while(myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
