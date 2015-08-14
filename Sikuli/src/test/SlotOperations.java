package test;

import org.sikuli.script.*;


public class SlotOperations 
{
	static Screen s = new Screen();
	
	public static boolean isNgSpinButtonPresent() throws FindFailed
	{
		try
		{						
			s.find("slot//ng//NG_spinButton.png");						
							
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	public static boolean isGanSpinButtonPresent() throws FindFailed
	{
		try
		{						
			s.find("slot//gan//GAN_spinButton.png");						
							
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	public static boolean isGdkSpinButtonPresent()
	{
		try
		{						
			s.find("slot//gdk//GDK_spinButton.png");						
							
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	public static int specifySlot() throws FindFailed // returns values 0 - not a slot; 1 - NextGen; 2 - GAN; 3 - GDK
	{
		if (isNgSpinButtonPresent())
		{
			return 1;
		}
		else if (isGanSpinButtonPresent())
		{
			return 2;
		}
		else if (isGdkSpinButtonPresent())
		{
			return 3;
		}
		else
		{
			return 0;
		}
	}
}
