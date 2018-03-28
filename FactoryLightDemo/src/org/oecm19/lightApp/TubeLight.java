package org.oecm19.lightApp;

public class TubeLight implements ISwitch 
{
	//Implementation Logic//
	@Override
	public void sOn() 
	{
		System.out.println("Tube Light is on..");
	}

	@Override
	public void sOff() 
	{
		System.out.println("Tube Light is off ...");
	}

}
