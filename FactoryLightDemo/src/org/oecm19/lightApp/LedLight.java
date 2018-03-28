package org.oecm19.lightApp;

public class LedLight implements ISwitch 
{
	// Implementation Logic //
	@Override
	public void sOn() 
	{
		System.out.println("LED light is ON....");
	}

	@Override
	public void sOff() 
	{
		System.out.println("LED light is OFF....");
	}

}
