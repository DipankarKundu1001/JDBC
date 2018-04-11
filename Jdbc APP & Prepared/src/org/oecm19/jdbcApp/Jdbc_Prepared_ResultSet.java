package org.oecm19.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc_Prepared_ResultSet 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry = "select * from oecm19.students";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class LOaded and Register..");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=toor");
			System.out.println("Connection Established with DBServer");
			
			pstmt = con.prepareStatement(qry);
			System.out.println("Platform Created");
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString(2);
				double perc = rs.getDouble(3);
				System.out.println(id + " " + name + " " + perc);
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
			if(pstmt != null)
			{
				try {
					pstmt.close();
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
