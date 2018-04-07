package org.oecm19.jdbcApp;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class JdbcDemo1 
{
	public static void main(String[] args) 
	{
		try 
		{
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			System.out.println("Driver load and register ... by using Driver manager and Register driver");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
