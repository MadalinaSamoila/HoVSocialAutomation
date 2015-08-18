package test;

import org.sikuli.script.*;


public class LobbyOperations 
{
	static Screen s = new Screen();
	
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
			
			s.wait(3.0);
			
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
			
			s.wait(5.0);
			
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
			
			s.wait(5.0);
			
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
			
			s.wait(10.0);
			
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
			
			s.wait(5.0);
			
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
			
			s.wait(5.0);
			
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
			s.wait(4.0);
			
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
			s.wait(4.0);
			
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
			s.wait(4.0);
			
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
			
			s.wait(4.0);
			
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
			
			s.wait(4.0);
			
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
			  s.wait(4.0);
			  
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
			  s.wait(4.0);
			  
			  s.find("lobby//FanPageTopBarButton.png");
		   
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
			  
			  s.wait(5.0);
		   
		   return true;
		  }
		  catch (FindFailed e)
		  {
		   return false;
		  }
		 } 
		
		// Close CRM Congratulation popup mecthod is in SHOP - isCongratulationPopupPresentAndClickOkayButton()

		
		// SlotMachinesPresent
}
