package org.oecm19.BatchStatement;

import java.sql.*;

public class BatchStmt 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
		String inqry = "insert into oecm19.students values (6,'deep','cse',65.60)";
		String upqry = "update oecm19.students set perc = 70.77 where id = 1";
		String delqry = "delete from oecm19.students where perc = 75.68";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=toor");
			stmt = con.createStatement();
			stmt.addBatch(inqry);
			stmt.addBatch(delqry);
			stmt.addBatch(upqry);
			
			int curr[] = stmt.executeBatch();
			for(int i : curr)
			{
				System.out.println(i);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
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
