package org.oecm19.jdbcApp;

import java.sql.*;

public class JdbcInsertMultiple 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
		String qry1 = "insert into oecm19.students values(1, 'deep', 67.6)";
		String qry2 = "insert into oecm19.students values(2, 'pijus', 77.6)";
		String qry3 = "insert into oecm19.students values(3, 'Suman', 69.6)";
		String qry4 = "insert into oecm19.students values(4, 'bunty', 63.6)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Load and Register Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=toor");
			System.out.println("Connection Estblished");
			
			stmt = con.createStatement();
			System.out.println("Platform Created");
			
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			stmt.executeUpdate(qry3);
			stmt.executeUpdate(qry4);
			System.out.println("Data updated.");
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
		}
	}
}
