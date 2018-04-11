package org.oecm19.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcApp 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class Loaded and register..");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=toor");
			System.out.println("Connection Established with MYSQL...");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(con != null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
