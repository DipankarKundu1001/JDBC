package org.oecm19.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc_Prepared_Stm 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		String qry = "insert into oecm19.students values(?,?,?)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded and Regiser..");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=toor");
			System.out.println("Connection Established");
			
			pstmt = con.prepareStatement(qry);
			System.out.println("Platform Created...");
			
			//SET THE VALUED FOR PLACEHOLDER BEFORE EXECUTION
			pstmt.setInt(1, 1);
			pstmt.setString(2, "deep");
			pstmt.setDouble(3, 67.6);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 2);
			pstmt.setString(2, "Pijus");
			pstmt.setDouble(3, 69.6);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 3);
			pstmt.setString(2, "Bunty");
			pstmt.setDouble(3, 57.6);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 4);
			pstmt.setString(2, "Suman");
			pstmt.setDouble(3, 96.6);
			pstmt.executeUpdate();
			
			System.out.println("Data Inserted Succesfully..");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
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
