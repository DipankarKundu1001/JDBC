package org.oecm19.transactionApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

public class TransactionSavePoint 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		
		Savepoint sp = null;
		
		String stded = "insert into oecm19.studentedu values(?,?,?,?)";
		String stdpr = "insert into oecm19.studentper values(?,?,?)";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id ??");
		int id = sc.nextInt();
		System.out.println("Enter Name ??");
		String name = sc.next();
		System.out.println("Enter Dept ??");
		String dept = sc.next();
		System.out.println("Enter the perc ??");
		double perc = sc.nextDouble();
		System.out.println("Enter place ??");
		String place = sc.next();
		sc.close();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=toor");
			con.setAutoCommit(false);		//Disable Auto Commit
			pstmt = con.prepareStatement(stded);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, dept);
			pstmt.setDouble(4, perc);
			pstmt.executeUpdate();
			System.out.println("Students Education Details Executed ");
			//1st DB OPERATION
			
			sp = con.setSavepoint();
			
			pstmt1 = con.prepareStatement(stdpr);
			pstmt1.setInt(1, id);
			pstmt1.setString(2, name);
			pstmt1.setString(3, place);
			pstmt1.executeUpdate();
			System.out.println("Student Personal details Executed");
			//2nd DB OPERATION
			con.commit();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			try
			{
				con.rollback(sp);
				con.commit();
				System.out.println("Operation rolled Back..");
			}
			catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			if(pstmt1 != null)
			{
				try {
					pstmt1.close();
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
