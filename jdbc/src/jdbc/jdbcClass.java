package jdbc;

import java.sql.*;

public class jdbcClass {

	public static void main(String[] args) {
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
			int i = 0;
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","januszprog");
			
			CreateStatement to database and read values
			
			Statement myStmt = myConn.createStatement();

			//statement in database
            ResultSet myRs = myStmt.executeQuery("select * from employees");

            //throw values from database
			while(myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
			}

		
			
			
			// Execute SQL query INSERT to database
			
			
			String sql = "insert into employees "
					+ "(id,last_name,first_name,email)"
					+ "values (6,'Kaminski', 'Krzysztof', 'krzysztof@kaminski@gmail.com')";

			myStmt.executeUpdate(sql);

			System.out.println("Insert complete");
			
			
			
			//Execute SQL query UPDATE index in database

			String sql1 = "update employees "
					+ "set email='lukid@onet.eu'"
					+ "where id=1";

			myStmt.executeUpdate(sql1);

			System.out.println("Updated complite");
			

			
     		//Execute SQL query DELETE index in database

			String sql2 = "delete from employees where last_name='Kaminski'";
            int rowsAffected = myStmt.executeUpdate(sql2);
            System.out.println("Delete complete");
			
			
			
			   //Execute SQL query prepare statement

			myStmt = myConn.prepareStatement("select * from employees where salary > ?" );
			myStmt.setInt(1, 00);

			myRs = myStmt.executeQuery();

			display(myRs);
			
			
			
			
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}
		//Method to prepare statement
	
	private static void display(ResultSet myRs) throws SQLException {
		while (myRs.next()) {
			String lastName = myRs.getString("last_name");
			String firstName = myRs.getString("first_name");
			double salary = myRs.getDouble("salary");

			System.out.printf("%s, %s, %.2f\n", lastName, firstName, salary);
		}
	}

}
