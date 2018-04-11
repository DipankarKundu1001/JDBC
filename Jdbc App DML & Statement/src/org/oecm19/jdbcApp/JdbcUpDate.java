package org.oecm19.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpDate 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
		String qry = "update oecm19.students set name = 'dipankar' where id = 1";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded and register..");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=toor");
			System.out.println("Connection Established with DBServer");
			
			stmt = con.createStatement();
			System.out.println("Platform Created..");
			
			stmt.executeUpdate(qry);
			System.out.println("Data Deleted..");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(stmt != null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Costly resourses closed");
		}
	}

}
