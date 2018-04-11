package org.oecm19.metaApp;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaData 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String qry = "Select * from oecm19.students";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=toor");
			
			DatabaseMetaData dbm = con.getMetaData();
			System.out.println("Driver Name :- " + dbm.getDriverName());
			System.out.println("Driver Version :- " + dbm.getDriverVersion());
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(qry);
			
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("Total number of column :- " + rsmd.getColumnCount());
			for(int i = 1; i <= rsmd.getColumnCount(); i++)
			{
				System.out.println("Name of " + i + " column is " + rsmd.getColumnLabel(i));
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(rs != null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
