package org.oecm19.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Fetch_Prepared_PlaceHolder 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry = "select * from oecm19.students where id = ?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id ??");
		int id = sc.nextInt();
		sc.close();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded and Register..");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=toor");
			System.out.println("Connection Established with DBServer...");
			
			pstmt = con.prepareStatement(qry);
			System.out.println("Platform Created");
			
			//SET THE VALUE FOR PLACEHOLDER BEFORE EXECUTION
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				String name = rs.getString(2);
				double perc = rs.getDouble(3);
				System.out.println(name + " " + perc);
			}
			else
				System.err.println("No data found");
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
