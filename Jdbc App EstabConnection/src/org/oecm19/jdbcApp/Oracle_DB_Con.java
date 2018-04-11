package org.oecm19.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Oracle_DB_Con 
{
	public static void main(String[] args) 
	{
		Connection con  = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Load and Register Driver of ORACLE");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			System.out.println("Connection established with Oracle DB..");
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select * from emp");
			while(rs.next())
			{
				String no = rs.getString(1);
				String name = rs.getString(2);
				System.out.println(no + " - " + name);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
