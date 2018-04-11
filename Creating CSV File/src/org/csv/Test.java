package org.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test 
{
	public static void main(String[] args) throws IOException 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String qry = "select * from oecm19.studentedu";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded and Register");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=toor");
			System.out.println("Connection Established with DBServer...");
			
			pstmt = con.prepareStatement(qry);
			System.out.println("Platform Created");
			rs = pstmt.executeQuery();
			
			File file = new File("C:\\JDBC\\test.csv");
			FileWriter fw = null;
			BufferedWriter bw = null;
			try
			{
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
				while(rs.next())
				{
					String id = Integer.toString(rs.getInt(1));
					String name = rs.getString(2);
					String stream = rs.getString(3);
					String perc = Double.toString(rs.getDouble(4));
					String wr = id + "," + name + "," + stream + "," + perc + System.lineSeparator();
					bw.write(wr);
				}
				bw.flush();
				bw.close();
				System.out.println("Flie Written successfully");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally 
			{
				try
				{
					bw.close();
					fw.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
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
