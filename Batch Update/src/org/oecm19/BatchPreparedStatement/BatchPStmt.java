package org.oecm19.BatchPreparedStatement;

import java.sql.*;

public class BatchPStmt 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		
		String inqry = "insert into oecm19.students values (6,'DEEP', 'cse', 65.60)";
		String delqry = "delete from oecm19.students where id = 3";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=toor");
			
			pstmt = con.prepareStatement(inqry);
			pstmt.addBatch();
			int arr[] = pstmt.executeBatch();
			for(int i:arr)
			{
				System.out.println(i);
			}
			
			pstmt1 = con.prepareStatement(delqry);
			pstmt1.addBatch();
			int arr1[] = pstmt1.executeBatch();
			for (int j : arr1) 
			{
				System.out.println(j);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
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
