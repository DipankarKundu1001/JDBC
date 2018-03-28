package org.oecm19.bankApp;

public class BankFactory 
{
	//Object creation Logic
	public static ICard getAccount(String type)
	{
		if(type.equalsIgnoreCase("sbi"))
		{
			return new SbiImpl();
		}
		else if(type.equalsIgnoreCase("icic"))
		{
			return new IcicImpl();
		}
		else
		{
			System.err.println("No Access...");
		}
		return null;
	}
}
