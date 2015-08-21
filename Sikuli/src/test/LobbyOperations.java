package test;

import java.io.IOException;

import org.sikuli.script.*;


public class LobbyOperations 
{
	static Screen s = new Screen();
	static String startRegion;
	
	//TIME BONUS
	
	public static boolean isTimeBonusEnabled() throws FindFailed // works if time bonus is filled on approx 50%
	{		
		try
		{						
			s.find("lobby//TB_full.png");
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
						
	}
	
	public static boolean clickCollectTimeBonus() throws FindFailed
	{	
		try
		{
						
			s.find("lobby//TB_collectEnabled.png");
			
			s.click("lobby//TB_collectEnabled.png");
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	public static boolean isCollectedTimeBonus() throws FindFailed
	{	
		try
		{				
			s.find("lobby//TB_empty_005957_remaining.png");					
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	
	//SHOP
	
	public static boolean isBuyButtonPresentAndClick() throws FindFailed
	{
		try
		{
			s.find("lobby//Lobby_buyButton.png");
			
			s.click("lobby//Lobby_buyButton.png");
			
			s.wait(5.0);
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	public static boolean isShopOpened() throws FindFailed
	{
		try
		{
			
			s.find("lobby//Shop_general.png");		
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	public static boolean isPurchaseButtonPresentAndClick() throws FindFailed
	{
		try
		{
			s.find("lobby//Shop_purchaseButton.png");
			
			s.click("lobby//Shop_purchaseButton.png");
			
			s.wait(15.0);
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	public static boolean isFbConfirmPopupPresentAndClickBuyButton(boolean isUpsale) throws FindFailed
	{
		try
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
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	public static boolean isUpsalePopupPresentAndClickSpinButton() throws FindFailed
	{
		try
		{
			s.find("lobby//Shop_upsaleWheel.png");
			
			s.find("lobby//Shop_upsaleWheelSpinButton.png");
			
			s.click("lobby//Shop_upsaleWheelSpinButton.png");
			
			s.wait(15.0);
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	public static boolean isUpsalePopupCompletedPresentAndClickCollectButton() throws FindFailed
	{
		try
		{
			s.find("lobby//Shop_upsaleWheelCompleted.png");
			
			s.find("lobby//Shop_upsaleWheelCompletedCollectButton.png");
			
			s.click("lobby//Shop_upsaleWheelCompletedCollectButton.png");
			
			s.wait(15.0);
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	public static boolean isCongratulationPopupPresentAndClickOkayButton() throws FindFailed //this method is using for 																				
	{                                                                                        // CRM Congratulation popup too
		try
		{
			s.find("lobby//Shop_congratulation.png");
			
			s.find("lobby//Shop_congratulationOkayButton.png");
			
			s.click("lobby//Shop_congratulationOkayButton.png");
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	//SHOP_QUICKBUY
	
	public static boolean isQuickBuyPanelPresent() throws FindFailed
	{
		try
		{
			s.find("lobby//Shop_quickbuy.png");					
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	
	public static boolean quickBuyDownClick() throws FindFailed
	{
		try
		{
			s.find("lobby//Shop_quickbuyDownButton.png");					
			
			s.click("lobby//Shop_quickbuyDownButton.png");
			
			s.wait(1.5);
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	public static boolean quickBuyUpClick() throws FindFailed
	{
		try
		{
			s.find("lobby//Shop_quickbuyUpButton.png");					
			
			s.click("lobby//Shop_quickbuyUpButton.png");
			
			s.wait(1.5);
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	
	public static boolean isQuickBuyDropDownPresent() throws FindFailed
	{
		try
		{
			s.find("lobby//Shop_quickbuyDropDownLess98.png");					
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	public static boolean quickBuyBuyClick() throws FindFailed
	{
		try
		{
			s.find("lobby//Shop_quickbuyBuyButton.png");					
			
			s.click("lobby//Shop_quickbuyBuyButton.png");
			
			s.wait(10.0);
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	//FAN PAGE
	
	public static boolean isLobbyReturned(int wheel) throws FindFailed  //Accepts 1 to PageDown, 2 for PageUp
	{
		try
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
			
			return true;
		}
		catch (FindFailed e)
		{
			return false;
		}
	}
	
	
	public static boolean isFanPageOpened()  throws FindFailed
	{
		try
		{
			s.wait(14.0);
			
			s.find("externalPages//FanPageLogo.png");
			
			return true;
			
		}
		catch (FindFailed e)
		{
			return false;
		}
	}	
		
	public static boolean isHelpPageOpened()  throws FindFailed
	{
		try
		{
			s.wait(14.0);
			
			s.find("externalPages//SupportPage.png");
			
			return true;
			
		}
		catch (FindFailed e)
		{
			return false;
		}
	}	
	
	public static boolean clickFanPage()  throws FindFailed
	{
		try
		{
			s.click("lobby//FanPageTopBarButton.png");
			
			s.wait(15.0);
			
			return true;
			
		}
		catch (FindFailed e)
		{
			return false;
		}
	}	
	
	public static boolean clickSupportPage()  throws FindFailed
	{
		try
		{
			s.click("lobby//SupportLinkFooter.png");
			
			s.wait(14.0);
			
			return true;
			
		}
		catch (FindFailed e)
		{
			return false;
		}
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
				
				s.wait(30.0);
				
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
				
				s.wait(65.5);
				
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
				// r.highlight();
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
				Region r = s.find("lobby//Lobby_JP_Button.png");
				r.y += 100;
				r.h += 300;			
				s.find(startRegion);
				
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
				
				s.wait(10.0);
				
				s.find("browser//"+browser+"_Heart_of_Vegas_tab_text.png");
				
				return true;
				
			}
			catch (FindFailed e)
			{
				return false;
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
				
				s.wait(65.0);
				
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