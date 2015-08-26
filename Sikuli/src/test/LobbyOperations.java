package test;

import java.io.IOException;

import org.sikuli.script.*;


public class LobbyOperations 
{
	static Screen s = new Screen();
	static String startRegion;
	static String res;
	
	//TIME BONUS
	
	
	
	public static String isTimeBonusEnabled() throws FindFailed // works if time bonus is filled on approx 50%
	{		
		s.find("lobby//TB_full.png");
		
		res = "[testprogress] Time Bonus Is Enabled - OK";
		
		System.out.println(res);
		
		return res; 
						
	}
	
	public static String clickCollectTimeBonus() throws FindFailed
	{	
		
			s.find("lobby//TB_collectEnabled.png");
			
			s.click("lobby//TB_collectEnabled.png");
			
			res = "[testprogress] Collect Time Bonus Button Is Clicked - OK";
			
			System.out.println(res);
			
			return res; 
			
	}
	
	public static String isCollectedTimeBonus() throws FindFailed
	{	
					
			s.find("lobby//TB_empty_005957_remaining.png");
			
			res = "[teststat] Time Bonus Collected - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	
	//SHOP
	
	public static String isBuyButtonPresentAndClick() throws FindFailed
	{
		
			s.find("lobby//Lobby_buyButton.png");
			
			s.click("lobby//Lobby_buyButton.png");
			
			s.wait(5.0);
			
			res = "[testprogress] Lobby Buy Button is Present and Clicked - OK";
			
			System.out.println(res);
		
			return res;
	}
	
	public static String isShopOpened() throws FindFailed
	{
			
			s.find("lobby//Shop_general.png");
			
			res = "[testprogress] Shop Opened - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	public static String isPurchaseButtonPresentAndClick() throws FindFailed
	{
			s.find("lobby//Shop_purchaseButton.png");
			
			s.click("lobby//Shop_purchaseButton.png");
			
			s.wait(15.0);
			
			res = "[testprogress] Purchase Button Is Present and Has Been Clicked - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	public static String isFbConfirmPopupPresentAndClickBuyButton(boolean isUpsale) throws FindFailed
	{
			if (isUpsale)
			{
				s.find("lobby//Shop_fbConfirmPaymentUpsale.png");
			}
			else
			{
				s.find("lobby//Shop_fbConfirmPaymentGeneral.png");
			}
			
			s.find("lobby//Shop_fbConfirmPaymentBuyButton.png");
			
			s.click("lobby//Shop_fbConfirmPaymentBuyButton.png");
			
			s.wait(15.0);
			
			res = "[testprogress] FB Popup (General) Is Present and Buy Button Has Been Clicked - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	public static String isUpsalePopupPresentAndClickSpinButton() throws FindFailed
	{

			s.find("lobby//Shop_upsaleWheel.png");
			
			s.find("lobby//Shop_upsaleWheelSpinButton.png");
			
			s.click("lobby//Shop_upsaleWheelSpinButton.png");
			
			s.wait(15.0);
			
			res = "[testprogress] Upsale Popup is Present and Spin Has Been Clicked - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	public static String isUpsalePopupCompletedPresentAndClickCollectButton() throws FindFailed
	{
			s.find("lobby//Shop_upsaleWheelCompleted.png");
			
			s.find("lobby//Shop_upsaleWheelCompletedCollectButton.png");
			
			s.click("lobby//Shop_upsaleWheelCompletedCollectButton.png");
			
			s.wait(15.0);
			
			res = "[testprogress] FB Popup (Upsale) Is Present and Buy Button Has Been Clicked - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	public static String ClickCongratulationOkayButton() throws FindFailed //this method is using for 																				
	{                                                                                        // CRM Congratulation popup too
			s.find("lobby//Shop_congratulationOkayButton.png");
			
			s.click("lobby//Shop_congratulationOkayButton.png");
			
			res = "[teststat] Congratulation Okay Button Has Been Clicked - OK";
			
			System.out.println(res);
			
			return res;
	}
	//SHOP_QUICKBUY
	
	public static String isQuickBuyPanelPresent() throws FindFailed
	{

			s.find("lobby//Shop_quickbuy.png");
			
			res = "[testprogress] QuickBuy Panel is Present - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	
	public static String quickBuyDownClick() throws FindFailed
	{

			s.find("lobby//Shop_quickbuyDownButton.png");					
			
			s.click("lobby//Shop_quickbuyDownButton.png");
			
			s.wait(1.5);
			
			res = "[testprogress] QuickBuy Down Button is Present and Clicked - OK";
			
			System.out.println(res);
			
			return res;

	}
	
	public static String quickBuyUpClick() throws FindFailed
	{

			s.find("lobby//Shop_quickbuyUpButton.png");					
			
			s.click("lobby//Shop_quickbuyUpButton.png");
			
			s.wait(1.5);
			
			res = "[testprogress] QuickBuy Up Button is Present and Clicked - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	
	public static String isQuickBuyDropDownPresent() throws FindFailed
	{

			s.find("lobby//Shop_quickbuyDropDownLess98.png");
			
			res = "[testprogress] QuickBuy DropDown List is Present - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	public static String quickBuyBuyClick() throws FindFailed
	{
			s.find("lobby//Shop_quickbuyBuyButton.png");					
			
			s.click("lobby//Shop_quickbuyBuyButton.png");
			
			s.wait(10.0);
			
			res = "[testprogress] QuickBuy Buy Button is Present and Clicked - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	//FAN PAGE
	
	public static String isLobbyReturned(int wheel) throws FindFailed  //Accepts 1 to PageDown, 2 for PageUp
	{
			s.wait(8.0);
			
			switch  (wheel)
			{
			
				default:
				{
					s.find("lobby//FanPageTopBarButton.png");
					
					break;
				}
			
				case 1:
				{
					//s.type(Key.PAGE_DOWN);
					
					s.wheel("lobby//FanPageTopBarButton.png", 1, 2);
					
					break;
					
				}
				case 2:
				{
					//s.type(Key.PAGE_UP);
					
					s.wheel("lobby//SupportLinkFooter.png", -1, 2);
					
					break;
				}
			}
			
			res = "[testprogress] User Is Returned To The Lobby - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	
	public static String isFanPageOpened()  throws FindFailed
	{

			s.wait(14.0);
			
			s.find("externalPages//FanPageLogo.png");
			
			res = "[testprogress] Fan Page From Top Bar Is Opened - OK";
			
			System.out.println(res);
			
			return res;
	}	
		
	public static String isHelpPageOpened()  throws FindFailed
	{

			s.wait(14.0);
			
			s.find("externalPages//SupportPage.png");
			
			res = "[testprogress] Support Page From The Bottom Is Opened - OK";
			
			System.out.println(res);
			
			return res;

	}	
	
	public static String clickFanPage()  throws FindFailed
	{

			s.click("lobby//FanPageTopBarButton.png");
			
			s.wait(15.0);
			
			res = "[testprogress] Fan Page Button Is Found and Clicked - OK";
			
			System.out.println(res);
			
			return res;
	}	
	
	public static String clickSupportPage()  throws FindFailed
	{
			s.click("lobby//SupportLinkFooter.png");
			
			s.wait(14.0);
			
			res = "[testprogress] Support Page Is Found and Clicked - OK";
			
			System.out.println(res);
			
			return res;

	}	
	  
	  
	  //TUTORIAL
	  
	  public static boolean isTimeBonusTutorialStepPresentAndClick() throws FindFailed
		{
			try
			{
							
				s.find("lobby//Tutorial_collectBonusStep.png");
				
				s.click("lobby//Tutorial_collectBonusStep.png");
				
				s.wait(5.0);
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		public static boolean isChooseMachineTutorialStepPresentAndClick() throws FindFailed
		{
			try
			{
							
				s.find("lobby//Tutorial_chooseMachineStep.png");
				
				s.click("lobby//Tutorial_chooseMachineStep.png");
				
				s.wait(3.0);
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		public static boolean isSelectBetTutorialStepPresentAndClick() throws FindFailed
		{
			try
			{
							
				s.find("lobby//Tutorial_selectBetStep.png");
				
				s.click("lobby//Tutorial_selectBetStep.png");
				
				s.wait(Double.parseDouble(CommonOperations.hov_slot_load_time));
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		public static boolean returnToLobby()
		{
			try
			{						
				s.find("slot//Slot_LobbyButton.png");						
				
				s.click("slot//Slot_LobbyButton.png");
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		//DAILY_WHEEL
		
		public static boolean isDailyWheelPresent() throws FindFailed
		{
			try
			{
				s.find("lobby//DW_Unspinned.png");					
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		public static boolean clickDailyWheelSpin() throws FindFailed
		{
			try
			{
				s.find("lobby//DW_ClickSpin.png");	
				
				s.click("lobby//DW_ClickSpin.png");					

				s.wait(10.0);
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		public static boolean clickDailyWheelCollect() throws FindFailed
		{
			try
			{
				s.find("lobby//DW_CollectButton.png");	
				
				s.click("lobby//DW_CollectButton.png");					

				s.wait(3.0);
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		public static boolean isDailyWheelSharePresent() throws FindFailed 
		{
			try
			{
				s.find("lobby//DW_ShareTicked.png");	
										
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		
		public static boolean untickDailyWheelShare() throws FindFailed 
		{
			try
			{
				s.find("lobby//DW_ShareTicked.png");	
				
				s.click("lobby//DW_ShareTick.png");	
				
				s.find("lobby//DW_ShareUnticked.png");	
				
				s.wait(3.0);
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		public static boolean tickDailyWheelShare() throws FindFailed 
		{
			try
			{
				s.find("lobby//DW_ShareUnticked.png");	
				
				s.click("lobby//DW_ShareUntick.png");	
				
				s.find("lobby//DW_ShareTicked.png");	
				
				s.wait(3.0);
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		// IsEnabledCRMAppears
		
		// Method that used for clicking Slot is writen in SlotMachinesPresent - clickCentralSlot()
		public static boolean isCRMOpened() throws FindFailed
		 {
		  try
		  {   
			  s.wait(14.0);
			  
			  s.find("lobby//Lobby_CRM_body.png");
		   
		   return true;
		  }
		  catch (FindFailed e)
		  {
		   return false;
		  }
		 } 
		
		public static boolean clickCloseButtonCRM() throws FindFailed
		 {
		  try
		  {      
			  s.click("lobby//Lobby_CRM_Close_Button.png");
		   
		   return true;
		  }
		  catch (FindFailed e)
		  {
		   return false;
		  }
		 } 
		
		public static boolean isCRMClosed() throws FindFailed
		 {
		  try
		  {      
			  s.wait(14.0);
			  
			  s.find("lobby//FanPageTopBarButton.png");
			  
			  s.wait(14.0);
		   return true;
		  }
		  catch (FindFailed e)
		  {
		   return false;
		  }
		 } 
		
		public static boolean clickCRM() throws FindFailed
		 {
		  try
		  {      
			  s.click("lobby//Lobby_CRM_body.png");
			  
			  s.wait(10.0);
		   
		   return true;
		  }
		  catch (FindFailed e)
		  {
		   return false;
		  }
		 } 
		
		// Close CRM Congratulation popup mecthod is in SHOP - isCongratulationPopupPresentAndClickOkayButton()

		
		// SlotMachinesPresent
		public static boolean clickCentralSlot() throws FindFailed
		{
			try
			{
				Region r = s.find("lobby//Lobby_HR_Button.png");
				r.h += 500;
				r.click("lobby//Lobby_slotCabinetButtons.png");
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		public static boolean clickNextSlot() throws FindFailed
		{
			try
			{
				Region r = s.find("lobby//Lobby_JP_Button.png");
				
				r.h += 500;
				r.w += 70;
				//r.highlight();
				r.click("lobby//Lobby_slotCabinetButtonsNext.png");
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		public static boolean isNextSlotComingSoon() throws FindFailed
		{
			try
			{
				Region r = s.find("lobby//Lobby_JP_Button.png");
				r.h += 500;
				r.w += 100;
				r.find("lobby//Lobby_ComingSoon.png");
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		public static boolean isNextSlotEarlyAccess() throws FindFailed
		{
			try
			{
				Region r = s.find("lobby//Lobby_JP_Button.png");
				r.h += 500;
				r.w += 100;
				r.find("lobby//Lobby_EarlyAccess.png");
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		public static boolean clickCabinetPlayButton() throws FindFailed
		{
			try
			{						
				s.find("lobby//Lobby_CabinetPlayBetButton.png");						
				
				s.click("lobby//Lobby_CabinetPlayBetButton.png");
				
				s.wait(Double.parseDouble(CommonOperations.hov_slot_load_time));
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		
		
		
		public static boolean clickAfterNextSlot() throws FindFailed
		{
			try
			{						
				Region r = s.find("lobby//Lobby_JP_Button.png");
				r.h += 500;
				r.x += 250;
				r.click("lobby//Lobby_slotCabinetButtonsNext.png");
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		public static boolean clickCloseCabinet() throws FindFailed
		{
			try
			{						
				s.click("lobby//Lobby_CabinetCloseButton.png");
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		public static void skipNextEarlyAccessAndComingSoonSlots() throws FindFailed
		{
			while (true)
			{
				try
				{
					Region r = s.find("lobby//Lobby_JP_Button.png");
					r.h += 500;
					r.w += 50;
					r.find("lobby//Lobby_ComingSoon.png");
					r.click("lobby//Lobby_ComingSoon.png");
					s.click("lobby//Lobby_CabinetCloseButton.png");
					System.out.println("[teststat] Next Slot is in Comnig Soon Status - SKIPPING");
				}
				catch (FindFailed e)
				{
					try
					{
						Region r = s.find("lobby//Lobby_JP_Button.png");
						r.h += 500;
						r.w += 50;
						r.find("lobby//Lobby_EarlyAccess.png");
						r.click("lobby//Lobby_EarlyAccess.png");
						s.click("lobby//Lobby_CabinetCloseButton.png");
						System.out.println("[teststat] Next Slot is in Early Acces Status - SKIPPING");
					}
					catch (FindFailed ex)
					{
						System.out.println("[teststat] Next Slot is not in Early Acces or Comnig Soon Status - NOT SKIPPING");
						break;
						
					}
				}
			}
		}
		
		public static void saveCentralSlotRegion() throws FindFailed, IOException
		{
			try
			{
				Region r = s.find("lobby//Lobby_HR_Button.png");
				r.y += 200;
				r.h += 300;
				//r.highlight();
				startRegion = s.capture(r).getFilename();	
				
				System.out.println("[teststat] (Initial) Slot Region Stored - OK");
			}
			catch (FindFailed e)
			{
				System.out.println("[teststat] Can't Store the Region with Central (Initial) Slot");
			}
			catch (IOException ex)
			{
				System.out.println("[teststat] Can't Store the Region with Central (Initial) Slot");
			}
		}
		
		public static boolean isCentralSlotInitial() throws FindFailed
		{
			try
			{	
				Region r = s.find("lobby//Lobby_HR_Button.png");
				r.y += 200;
				r.h += 300;		
				//r.highlight();
				r.find(startRegion);
				
				return true;
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		
		// FreshInstallTest case methods - start (behind)
		public static boolean findChangeURLAndAccessUATSocial(String browser)  throws FindFailed
		{
			try
			{
				s.find("browser//"+browser+"_facebook.com_url.png");
				
				s.click("browser//"+browser+"_facebook.com_url.png");
				
				s.paste("https://apps.facebook.com/hov_uat/");
				
				s.type(Key.ENTER);
				
				s.wait(13.0);
				
				s.find("browser//"+browser+"_Heart_of_Vegas_tab_text.png");
				
				return true;
				
			}
			catch (FindFailed e)
			{
				try
				{
					BrowserOperations.clickSearch();
					
					s.paste("https://apps.facebook.com/hov_uat/");
					
					s.type(Key.ENTER);
					
					s.wait(13.0);
					
					s.find("browser//"+browser+"_Heart_of_Vegas_tab_text.png");
					
					return true;
					
				}
				catch (FindFailed ex)
				{
					
					return false;
				}			
			}
		}
		
		public static boolean areFreshInstallStepsCompleted()  throws FindFailed
		{
			try
			{
				s.wait(15.0);
				
				s.find("browser//facebook_Play_Now_button.png");
				
				s.click("browser//facebook_Play_Now_button.png");
				
				s.wait(15.0);
				
				s.find("browser//facebook_OK_button.png");
				
				s.click("browser//facebook_OK_button.png");
				
				s.wait(Double.parseDouble(CommonOperations.hov_load_time));
				
				s.find("lobby//Tutorial_collectBonusStep.png");
				
				return true;
				
			}
			catch (FindFailed e)
			{
				return false;
			}
		}
		// FreshInstallTest case methods - finish (above)
}