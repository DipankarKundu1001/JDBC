package org.oecm19.storedAPP;
import java.sql.*;
import java.util.Scanner;

public class CstmtDemo 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String qry = "{call OECM19.getDetails(?)}";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sid :- ");
		//int sid = sc.nextInt();
		String sid = sc.next();
		sc.close();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=toor");
			cstmt = con.prepareCall(qry);
			cstmt.setString(1, sid);
			rs = cstmt.executeQuery();
			if(rs.next())
			{
				String name = rs.getString(2);
				String dept = rs.getString(3);
				double perc = rs.getDouble(4);
				System.out.println(name + " " + dept + " " + perc);
			}
			else 
			{
				System.err.println("NO data found!!!!");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(cstmt!=null)
			{
				try {
					cstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
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
