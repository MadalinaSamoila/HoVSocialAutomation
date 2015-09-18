package test;

import java.io.IOException;

import org.sikuli.script.*;


public class SlotOperations 
{
	static Screen s = new Screen();
	static Region r;
	static String storedRegionSlot;
	static String storedRegionBet;
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
				System.out.println("STORING REGION");
				storedRegionSlot = s.capture(r).getFilename();
			}
			if (mode.equals("compare"))
			{
				try 
				{
					//r.highlight();
					s.find(storedRegionSlot);
					System.out.println("SAME REGION");
					res = true;
				}
				catch (FindFailed e)
				{
					res = false;
					System.out.println("DIFFERENT REGION");
					//throw e;
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
				System.out.println("STORING REGION");
				storedRegionSlot = s.capture(r).getFilename();
			}
			if (mode.equals("compare"))
			{
				try 
				{
					//r.highlight();
					
					r = s.find("slot//gdk//gdk_dash_totalbet_label.png");
					r.h += 40;
					r.find(storedRegionSlot);
					System.out.println("SAME REGION");
					res = true;
				}
				catch (FindFailed e)
				{
					System.out.println("DIFFERENT REGION");
					res = false;
					//throw e;
				}
			}
		}
		
		return res;		
	}
	
	public static String clickHelpButton() throws FindFailed
	{
		s.click("slot//gdk//gdk_dash_i_btn.png");
		s.wait(1.5);
		s.find("slot//gdk//gdk_dash_i_clicked_btn.png");
		
		String res = "[testprogress] 'i' Button Clicked";
		System.out.println(res);
		
		return (res);
	}
	
	public static String exitFromHelp() throws FindFailed
	{
		s.click("slot//gdk//gdk_help_exit_button.png");	
		
		String res = "[testprogress] Returned To The Slot From GameInfo Page";
		System.out.println(res);
		
		return (res);	
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
	
	public static String clickIncraseBetButton() throws FindFailed
	{
		r = s.find("slot//gdk//gdk_dash_totalbet_label.png");
		
		r.x += 50;
		r.h += 50;
		//r.highlight();
		r.click("slot//gdk//gdk_dash_+_enabled_btn.png");
		
		String res = "[testprogress] Incrase Bet Button Clicked";
		System.out.println(res);
		
		return (res);		
	}
	
	public static String clickDecraseBetButton() throws FindFailed
	{
		r = s.find("slot//gdk//gdk_dash_totalbet_label.png");
		r.x -= 50;
		r.h += 50;
		s.click("slot//gdk//gdk_dash_-_enabled_btn.png");
		
		String res = "[testprogress] Decrase Bet Button Clicked";
		System.out.println(res);
		
		return (res);
	}
	
	public static String clickSpinButton() throws FindFailed
	{
		s.click("slot//gdk//GDK_spinButton.png");
		
		String res = "[testprogress] Spin Button Clicked";
		System.out.println(res);
		
		return (res);
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
	
	public static String clickMaxBetButton() throws FindFailed
	{
			s.find("slot//gdk_dash_maxbet_enabled_btn.png");
			
			s.click("slot//gdk_dash_maxbet_enabled_btn.png");
			
			s.find("slot//gdk_dash_maxbet_disabled_btn.png");
			
			s.find("slot//gdk_dash_+_disabled_btn.png");
			
			
			String res = "[testprogress] MaxBet Button Clicked";
			System.out.println(res);
			
			return (res);
			
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


	public static String clickAutospinActivate() throws FindFailed
	{
		s.click("slot//gdk//gdk_dash_autospin_activate_btn.png");
		String res = "[testprogress] Autospin Activate Button Clicked";
		System.out.println(res);
		return (res);
	}
	
	public static String clickAutospinDeactivate() throws FindFailed
	{
		s.click("slot//gdk//gdk_dash_autospin_deactivate_btn.png");
		String res = "[testprogress] Autospin Deactivate Button Clicked";
		System.out.println(res);
		return (res);
	}
	
}
