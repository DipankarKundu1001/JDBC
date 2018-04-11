package org.oecm19.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login_Validation 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry = "select username from oecm19.user where name = ? and password = ?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name ??");
		String name = sc.next();
		System.out.println("Enter password ??");
		String pwd = sc.next();
		sc.close();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded and Register..");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=toor");
			System.out.println("Connection Established with DBServer.");
			
			pstmt = con.prepareStatement(qry);
			
			//SET THE VALUES FOR PLACEHOLDER BEFORE EXECUTION
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				String username = rs.getString(1);
				System.out.println("Welcome " + username);
			}
			else
				System.err.println("Invalid name and Password.");
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
