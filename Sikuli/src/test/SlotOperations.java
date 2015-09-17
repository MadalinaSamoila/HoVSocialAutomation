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
			try
			{
				s.find("slot//gan//GAN_spinButtonOldschool.png");						
				
				return true;
			}
			catch (FindFailed ex)
			{
				return false;
			}
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
	
	// JackpotsUpdateAcceptanceStateWhenChangingCoinDenomination - start (behind)
	
	public static boolean isJPNotValid()  throws FindFailed
	{
		try
		{
			s.find("slot//Slot_JPNotValid.png");
			
			return true;
		}
		
		catch (FindFailed e)
		{
			return false;
		}
		
	}
	
	public static void clickMaxBetButton() throws FindFailed
	{
			s.find("slot//gdk_dash_maxbet_enabled_btn.png");
			
			s.click("slot//gdk_dash_maxbet_enabled_btn.png");
			
			s.find("slot//gdk_dash_maxbet_disabled_btn.png");
			
			s.find("slot//gdk_dash_+_disabled_btn.png");
			
	}
	
	public static boolean isJPValid()  throws FindFailed
	{
		try
		{
			s.find("slot//Slot_JPValid.png");
			
			return true;
		}
		
		catch (FindFailed e)
		{
			return false;
		}
	}
	// JackpotsUpdateAcceptancestateWhenChangingCoinDenomination - finish (above)
	
	// AllDashButtonsAreFunctional - start (behind)
	// MaxBet button checked during JackpotsUpdateAcceptanceStateWhenChangingCoinDenomination test case
	
}
