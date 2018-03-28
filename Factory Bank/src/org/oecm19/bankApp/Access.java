package org.oecm19.bankApp;

import java.util.Scanner;

public class Access 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Swipe card....");
		String type = sc.next();
		sc.close();
		ICard ic = BankFactory.getAccount(type);
		if(ic != null)
		{
			ic.swipe();
		}
	}
}
