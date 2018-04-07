package org.oecm19.loadApp;

public class Test 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("org.oecm19.loadApp.Boy");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
