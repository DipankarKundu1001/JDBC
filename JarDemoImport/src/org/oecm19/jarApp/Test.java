package org.oecm19.jarApp;

public class Test 
{
	public static void main(String[] args) 
	{
		
		try 
		{
			Class.forName("org.oecm19.jarApp.Bike");
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
