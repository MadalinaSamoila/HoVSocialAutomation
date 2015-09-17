package test;

import java.io.IOException;

import org.sikuli.script.*;


public class SlotOperations 
{
	static Screen s = new Screen();
	static Region r;
	static String storedRegion;
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
	
	//StoreOrCompareRegion stores region (mode == 'store') region could be part of the slot (subject == 'slot')
	//or bet status (subject == 'bet')
	// (mode == 'compare'): returns true if stored region is present on the screen 
	public static boolean storeOrCompareRegion(String subject, String mode) throws FindFailed, IOException
	{
		boolean res = true;
		Screen s = new Screen();
		
		if (subject.equals("slot"))
		{
			if (mode.equals("store"))
			{
				r = s.find("lobby//Lobby_buyButton.png");
				r.h += 500;
				r.w += 50;
				storedRegion = s.capture(r).getFilename();
			}
			if (mode.equals("compare"))
			{
				try 
				{
					//r.highlight();
					s.find(storedRegion);
					res = true;
				}
				catch (FindFailed e)
				{
					res = false;
				}
			}
		}
		if (subject.equals("bet"))
		{
			if (mode.equals("store"))
			{
				r = s.find("slot//gdk//gdk_dash_totalbet_label.png");
				r.h += 40;
				//r.w += 50;
				storedRegion = s.capture(r).getFilename();
			}
			if (mode.equals("compare"))
			{
				try 
				{
					//r.highlight();
					s.find(storedRegion);
					res = true;
				}
				catch (FindFailed e)
				{
					res = false;
				}
			}
		}
		
		return res;		
	}
	
	public static void clickHelpButton() throws FindFailed
	{
		s.click("slot//gdk//gdk_dash_i_btn.png");
		s.wait(1.5);
		s.find("slot//gdk//gdk_dash_i_clicked_btn.png");
	}
	
	public static void exitFromHelp() throws FindFailed
	{
		s.click("slot//gdk//gdk_help_exit_button.png");	
	}
	
	public static boolean isDeraseBetButtonEnabled() throws FindFailed
	{
		boolean res = false;
		
		try 
		{
			//r.highlight();
			s.find("slot//gdk//gdk_dash_-_enabled_btn.png");
			res = true;
		}
		catch (FindFailed e)
		{
			s.find("slot//gdk//gdk_dash_-_disabled_btn.png");
			res = false;
		}
		return res;
	}
	
	public static boolean isIncraseBetButtonEnabled() throws FindFailed
	{
		boolean res = false;
		
		try 
		{
			//r.highlight();
			s.find("slot//gdk//gdk_dash_+_enabled_btn.png");
			res = true;
		}
		catch (FindFailed e)
		{
			s.find("slot//gdk//gdk_dash_+_disabled_btn.png");
			res = false;
		}
		return res;
	}
	
	public static void clickIncraseBetButton() throws FindFailed
	{
		s.click("slot//gdk//gdk_dash_+_enabled_btn.png");
	}
	
	public static void clickDecraseBetButton() throws FindFailed
	{
		s.click("slot//gdk//gdk_dash_-_enabled_btn.png");
	}
	
}
