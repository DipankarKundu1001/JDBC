package org.oecm19.jdbcApp;

import java.sql.*;

public class JdbcDemo 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
		String qry ="insert into oecm19.students values (1,'deep', 57.6)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded & register..");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=toor");
			System.out.println("Connection Established with DBServer...");
			
			stmt = con.createStatement();
			System.out.println("Platform Created");
			
			stmt.executeUpdate(qry);
			System.out.println("Data inserted");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally 
		{
			if(stmt!=null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
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
