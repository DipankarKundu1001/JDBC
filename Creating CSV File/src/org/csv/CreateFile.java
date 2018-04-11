package org.csv;

import java.io.File;

public class CreateFile 
{
	public void createFile()
	{
		File f = new File("C:\\JDBC\\test.csv");
		try
		{
			if(!f.exists())
			{
				f.createNewFile();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
