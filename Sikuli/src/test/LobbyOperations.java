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
				s.find("lobby//Shop_fbConfirmPaymentGeneral.png");
			}
			else
			{
				s.find("lobby//Shop_fbConfirmPaymentUpsale.png");
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
	
	public static boolean isCongratulationPopupPresentAndClickOkayButton() throws FindFailed
	{
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
	
	
	//FAN PAGE
	
	public static boolean isLobbyReturned() throws FindFailed
	 {
		   try
		   {
			   s.find("lobby//Lobby_top.png");
		    
			   return true;
		   }
		   catch (FindFailed e)
		   {
			   return false;
		   }
	  }
	  
	  
	  public static boolean isFanPageOpened() throws FindFailed
	  {
		   try
		   {
			    s.find("externalPages//FanPage.png");
			    
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
}
