package org.oecm19.lightApp;

public class LightFactory 
{
	//Object Creation Logic //
	public static ISwitch getLight(String type)
	{
		if(type.equalsIgnoreCase("TubeLight"))
		{
			return new TubeLight();
		}
		else if(type.equalsIgnoreCase("LedLight"))
		{
			return new LedLight();
		}
		else
		{
			System.err.println("No light fount");
		}
		return null;
	}
}
