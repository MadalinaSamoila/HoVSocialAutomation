package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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
	
	public static String isShopOpened(boolean isLoyaltyEnabled) throws FindFailed
	{
		
			if (isLoyaltyEnabled)
			{		
				s.find("lobby//Shop_general_loyaltyMember.png");
			}
			else
			{
				s.find("lobby//Shop_general.png");
			}
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
	{                                                                      // CRM Congratulation popup too
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
					res = "[testprogress] Fan Page Button Present - OK";
					break;
				}
			
				case 1:
				{
					//s.type(Key.PAGE_DOWN);
					
					s.wheel("lobby//FanPageTopBarButton.png", 1, 2);
					res = "[testprogress] User Is Returned To The Lobby - OK";
					break;
					
				}
				case 2:
				{
					//s.type(Key.PAGE_UP);
					
					s.wheel("lobby//SupportLinkFooter.png", -1, 2);
					res = "[testprogress] User Is Returned To The Lobby - OK";
					break;
				}
			}
			
			
			
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
	  
	public static String isTimeBonusTutorialStepPresentAndClick() throws FindFailed
	{			
						
		s.find("lobby//Tutorial_collectBonusStep.png");
		
		s.click("lobby//Tutorial_collectBonusStep.png");
		
		s.wait(5.0);
		
		res = "[testprogress] Tutorial's Time Bonus Step Was Clicked - OK";
		
		System.out.println(res);
		
		return res;
	}
	
	public static String isTimeBonusTutorialStepPresent() throws FindFailed
	{			
						
		s.find("lobby//Tutorial_collectBonusStep.png");			
		
		res = "[testprogress] Tutorial's Time Bonus Step is Present - OK";
		
		System.out.println(res);
		
		return res;
	}
	
	public static String isChooseMachineTutorialStepPresentAndClick() throws FindFailed
	{
					
		s.find("lobby//Tutorial_chooseMachineStep.png");
		
		s.click("lobby//Tutorial_chooseMachineStep.png");
		
		s.wait(3.0);
		
		res = "[testprogress] Tutorial's Choose Machine Step Was Clicked - OK";
		
		System.out.println(res);
		
		return res;
	}
	
	public static String isSelectBetTutorialStepPresentAndClick() throws FindFailed
	{
						
		s.find("lobby//Tutorial_selectBetStep.png");
		
		s.click("lobby//Tutorial_selectBetStep.png");
		
		s.wait(Double.parseDouble(CommonOperations.hov_slot_load_time));
		
		res = "[testprogress] Tutorial's Select Bet Step Was Clicked - OK";
		
		System.out.println(res);
		
		return res;
	}
	
	public static String returnToLobby() throws FindFailed
	{
							
		s.find("slot//Slot_LobbyButton.png");						
		
		s.click("slot//Slot_LobbyButton.png");
		
		res = "[testprogress] The User Was Returned to the Lobby - OK";
		
		System.out.println(res);
		
		return res;
	}
	
	//DAILY_WHEEL
	
	public static String isDailyWheelPresent() throws FindFailed
	{
		s.find("lobby//DW_Unspinned.png");					
			
		res = "[testprogress] Daily Wheel is Present - OK";
		
		System.out.println(res);
		
		return res;
	}
	
	public static String clickDailyWheelSpin() throws FindFailed
	{
		s.find("lobby//DW_ClickSpin.png");	
			
		s.click("lobby//DW_ClickSpin.png");	
		
		for (int i = 0; i < 10; i++)
		{
			s.click("lobby//DW_CentralRegionWheel.png");
		}

		s.wait(10.0);
			
		res = "[testprogress] Daily Wheel Was Clicked - OK";
		
		System.out.println(res);
		
		return res;
	}
	
	public static String clickDailyWheelCollect() throws FindFailed
	{
		
		s.find("lobby//DW_CollectButton.png");	
		
		s.click("lobby//DW_CollectButton.png");					

		s.wait(3.0);
		
		res = "[testprogress] Daily Wheel's Collect Button Was Clicked - OK";
		
		System.out.println(res);
		
		return res;
	}
	
	public static boolean isDailyWheelSharePresent()
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
	
	
	public static String untickDailyWheelShare() throws FindFailed 
	{
		
		s.find("lobby//DW_ShareTicked.png");	
		
		s.click("lobby//DW_ShareTick.png");	
		
		s.find("lobby//DW_ShareUnticked.png");	
		
		s.wait(3.0);
		
		res = "[testprogress] Daily Wheel's Share Checkbix Was Unticked - OK";
		
		System.out.println(res);
		
		return res;
	}
	
	public static String tickDailyWheelShare() throws FindFailed 
	{
		
		s.find("lobby//DW_ShareUnticked.png");	
		
		s.click("lobby//DW_ShareUntick.png");	
		
		s.find("lobby//DW_ShareTicked.png");	
		
		s.wait(3.0);
		
		res = "[testprogress] Daily Wheel's Share Checkbix Was Ticked - OK";
		
		System.out.println(res);
		
		return res;
	}
	
	public static String isDailyWheelCloseDisabledPresent() throws FindFailed 
	{
		
		
		Region r = s.find("lobby//DW_FriendsSymbol.png");	
		
		r.x += 48;
		r.w -= 15;
		r.h -= 20;
		
		s.find("lobby//DW_CloseButtonDisabled.png");	
		
		res = "[testprogress] Daily Wheel's Disabled Close Button Is Present - OK";
		
		System.out.println(res);
		
		return res;
	}
	
	public static String clicksOutsideDailyWheel() throws FindFailed
	{
		Region r = s.find("lobby//DW_ReturnsSymbol.png");	
		
		r.click();
		
		r.y += 100;	
		
		r.click();
		
		r.x += 50;
		
		r.click();
		
		r.y += 100;	
		
		r.click();
		
		r.x += 70;
		r.y += 100;	
		
		r.click();
		
		r.x += 170;
		r.y += 20;	
		
		r.click();
	
		r = s.find("lobby//DW_FriendsSymbol.png");	
		
		r.click();
		
		r.y += 100;	
		
		r.click();
		
		r.x -= 50;
		
		r.click();
		
		r.y += 100;	
		
		r.click();
		
		r.x -= 70;
		r.y += 100;	
		
		r.click();
	
		
		res = "[testprogress] Daily Wheel Was Clicked Outside - OK";
		
		System.out.println(res);
		
		return res;
	}
	
	
	public static String spinDailyWheelWithSpam() throws FindFailed
	{
		s.click("lobby//DW_ClickSpin.png");
		for (int i = 0; i < 10; i++)
		{
			s.click("lobby//DW_CentralRegionWheel.png");
		}
		
		res = "[testprogress] Daily Wheel Was Spammed - OK";
		
		System.out.println(res);
		
		return res;
	}
	// IsEnabledCRMAppears
	
	// Method that used for clicking Slot is writen in SlotMachinesPresent - clickCentralSlot()
	public static String isCRMOpened() throws FindFailed
	{
	   
		  s.wait(14.0);
		  
		  s.find("lobby//Lobby_CRM_body.png");
	   
		  res = "[testprogress] CRM Is Opened - OK";
			
		  System.out.println(res);
		  
		  return res;
	 } 
	
	public static String clickCloseButtonCRM() throws FindFailed
	{
	       
		  s.click("lobby//Lobby_CRM_Close_Button.png");
	   
		  res = "[testprogress] CRM's Close Button Was Clicked - OK";
			
		  System.out.println(res);
		  
		  return res;
	} 
	
	public static String isCRMClosed() throws FindFailed
	{
	        
		  s.wait(14.0);
		  
		  s.find("lobby//FanPageTopBarButton.png");
		  
		  s.wait(14.0);
	   
		  res = "[testprogress] CRM Was Closed - OK";
			
		  System.out.println(res);
		  
		  return res;
	 }
	 
	
	public static String clickCRM() throws FindFailed
	{
	        
		  s.click("lobby//Lobby_CRM_body.png");
		  
		  s.wait(10.0);
	   
		  res = "[testprogress] CRM Was Clicked - OK";
			
		  System.out.println(res);
		  
		  return res;
	 } 
	
	// Close CRM Congratulation popup mecthod is in SHOP - isCongratulationPopupPresentAndClickOkayButton()

	
	// SlotMachinesPresent
	public static String clickCentralSlot() throws FindFailed
	{
		
		Region r = s.find("lobby//Lobby_HR_Button.png");
		
		r.h += 500;
		r.w += 70;
		//r.highlight();
		try
		{
			r.click("lobby//Lobby_slotCabinetButtons.png");
			
			res = "[testprogress] Next Slot Was Clicked - OK";
			
			System.out.println(res);
			
			return res;
		}
		catch (FindFailed e)
		{
			r.click("lobby//Lobby_slotOldschoolCabinetButtonsNext.png");
			
			res = "[testprogress] Next Slot Was Clicked (Old School Slot Version) - OK";
			
			System.out.println(res);
			
			return res;
		}
	}
	
	public static String clickNextSlot() throws FindFailed
	{
		
		Region r = s.find("lobby//Lobby_JP_Button.png");
		
		r.h += 500;
		r.w += 70;
		//r.highlight();
		try
		{
			r.click("lobby//Lobby_slotCabinetButtonsNext.png");
			
			res = "[testprogress] Next Slot Was Clicked - OK";
			
			System.out.println(res);
			
			return res;
		}
		catch (FindFailed e)
		{
			r.click("lobby//Lobby_slotOldschoolCabinetButtonsNext.png");
			
			res = "[testprogress] Next Slot Was Clicked (Old School Slot Version) - OK";
			
			System.out.println(res);
			
			return res;
		}
	}
	
	public static boolean isNextSlotComingSoon()
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
	
	public static boolean isNextSlotEarlyAccess()
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
	
	public static String clickCabinetPlayButton() throws FindFailed
	{
								
		s.find("lobby//Lobby_CabinetPlayBetButton.png");						
		
		s.click("lobby//Lobby_CabinetPlayBetButton.png");
		
		s.wait(Double.parseDouble(CommonOperations.hov_slot_load_time));
		
		res = "[testprogress] Bet's Play Button Was Clicked - OK";
		
		System.out.println(res);
		
		return res;
	}
	
	
	
	
	public static String clickAfterNextSlot() throws FindFailed
	{
							
		Region r = s.find("lobby//Lobby_JP_Button.png");
		r.h += 500;
		r.x += 250;
		r.click("lobby//Lobby_slotCabinetButtonsNext.png");
		
		res = "[testprogress] After The Next Slot Was Clicked - OK";
		
		System.out.println(res);
		
		return res;
	}
	
	public static String clickCloseGameInfoPopup() throws FindFailed
	{									
		s.click("lobby//Lobby_CabinetCloseButton.png");
		
		res = "[testprogress] Cabinet's Close Button Was Clicked - OK";
		
		System.out.println(res);
		
		return res;
	}
	
	public static void skipNextEarlyAccessAndComingSoonSlots()
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
	
	public static void saveCentralSlotRegion()
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
	
	public static boolean isCentralSlotInitial()
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
	public static String findChangeURLAndAccessUATSocial(String browser)  throws FindFailed
	{
		
			BrowserOperations.clickSearch();
			s.wait(1.5);
			s.paste("https://apps.facebook.com/hov_uat/");
			
			s.type(Key.ENTER);
			
			s.wait(10.5);
			
			/*s.type(Key.ENTER);
			
			s.wait(10.5);
			
			s.find("browser//"+browser+"_Heart_of_Vegas_tab_text.png");
			
			res = "[testprogress] The tab With The Game Opened - OK";
			*/
			System.out.println(res);
			
			return res;
			
		
		
	}
	
	public static String areFreshInstallStepsCompleted()  throws FindFailed
	{
		
			s.wait(15.0);
			
			s.find("browser//facebook_Play_Now_button.png");
			
			s.click("browser//facebook_Play_Now_button.png");
			
			s.wait(15.0);
			
			s.find("browser//facebook_OK_button.png");
			
			s.click("browser//facebook_OK_button.png");
			
			s.wait(Double.parseDouble(CommonOperations.hov_load_time));
			
			s.find("lobby//Tutorial_collectBonusStep.png");
			
			res = "[testprogress] All Install Steps Were Completed. The User Is Placed In The Tutorial - OK";
			
			System.out.println(res);
			
			return res;
	}
	// FreshInstallTest case methods - finish (above)
	
	// JackpotsUpdateAcceptanceStateWhenChangingCoinDenomination
	
	// isJPNotValid(), clickMaxBetButton() and  methods isJPValid() is inside *SlotOperations.java class
	
	//UserCanSendAndreceiveGifts - start (behind)
	
	public static String sendGiftViaLeaderboard() throws FindFailed
	{
		
		s.find("lobby//Lobby_Send_Gift_Button_Leaderboard.png");
		
		s.click("lobby//Lobby_Send_Gift_Button_Leaderboard.png");
		
		s.wait(5.0);
		
		s.find("browser//facebook_Send_Button.png");
		
		s.click("browser//facebook_Send_Button.png");
		
		s.wait(5.0);
		
		s.find("lobby//Lobby_Gift_Sent_Button_Leaderboard.png");
			
			
		
		String res = "[testprogress]The Gift Was Sent Via The Leaderboard - OK";
		
		System.out.println(res);
		
		return res;
		
	}
	
	public static String sendGiftViaGiftBox() throws FindFailed
	{
		    s.find("lobby//Lobby_Gift_Box_Tab.png");
			
			s.click("lobby//Lobby_Gift_Box_Tab.png");
			
			s.wait(5.0);
			
			s.find("lobby//Lobby_Send_Gift_Button_Gift_Box_Enabled.png");
			
			s.click("lobby//Lobby_Send_Gift_Button_Gift_Box_Enabled.png");
			
			s.wait(5.0);
			
			s.find("browser//facebook_Send_Button.png");
			
			s.click("browser//facebook_Send_Button.png");
			
			s.wait(5.0);
			
			s.find("lobby//Lobby_Gift_Box_Tab.png");
			
			s.click("lobby//Lobby_Gift_Box_Tab.png");
			
			s.wait(5.0);
			
			s.find("lobby//Lobby_Send_Gift_Button_Gift_Box_Disabled.png");
			
			s.click("lobby//Lobby_Send_Gift_Button_Gift_Box_Disabled.png");
			
			LobbyOperations.closeShopInviteBoxGiftBoxPopup();
			
			String res = "[testprogress]The Gift Was Sent Via The Gitf Box - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	public static boolean isGiftReseivedClient(String fbLogin, String fbPassword, String browser) throws Exception
	{
		WebDriver driver;
		
		System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "lib\\webdriver\\MicrosoftWebDriver.exe");
		
		switch(browser) {
		case "chrome": 	driver = new ChromeDriver();
						break;
		case "firefox": driver = new FirefoxDriver();
						break;
		case "iexplore":driver = new InternetExplorerDriver();
						break;
		case "edge":	driver = new EdgeDriver();
						break;		
		default:		driver = new ChromeDriver();
						break;
		}
		
		s.keyDown(Key.WIN);
		s.keyDown(Key.UP);
		s.keyUp(Key.WIN);
		s.keyUp(Key.UP);
		try
		{
			
			
			FacebookOperations.loginFacebook(browser, fbLogin, fbPassword);
			
			LobbyOperations.findChangeURLAndAccessUATSocial(browser);
			
			s.wait(Double.parseDouble(CommonOperations.hov_load_time));
			
			LobbyOperations.closeShopInviteBoxGiftBoxPopup();				
			
			s.find("lobby//Lobby_Gift_Box_Tab.png");
			
			s.click("lobby//Lobby_Gift_Box_Tab.png");
			
			s.wait(5.0);
			
			s.find("lobby//Lobby_Collect_Button_Gift_Box_Enabled.png");
			
			s.click("lobby//Lobby_Collect_Button_Gift_Box_Enabled.png");
			
			s.wait(3.0);
			
			s.find("lobby//Lobby_Collect_Button_Gift_Box_Disabled.png");
			
			LobbyOperations.closeShopInviteBoxGiftBoxPopup();
			
			s.find("lobby//Lobby_Collect_One_Gift_After_Tutorial_Congratulation_Popup.png");
			
			s.find("lobby//Shop_congratulationOkayButton.png");
			
			s.click("lobby//Shop_congratulationOkayButton.png");
			
			s.find("lobby//Lobby_Gift_Box_Tab.png");
			
			s.click("lobby//Lobby_Gift_Box_Tab.png");
			
			s.wait(5.0);
			
			s.find("lobby//Lobby_Collect_Button_Gift_Box_Disabled.png");
			
			LobbyOperations.closeShopInviteBoxGiftBoxPopup();
			driver.close();
			return true;
		}
		
		catch (FindFailed e)
		{
			driver.close();
			return false;
		}
	}
	
	public static void closeShopInviteBoxGiftBoxPopup() throws FindFailed
	{
		s.find("lobby//Lobby_Close_Shop_InviteBox_GiftBox_Popup_Button.png");
		
		s.click("lobby//Lobby_Close_Shop_InviteBox_GiftBox_Popup_Button.png");
		
		s.wait(5.0);
		
		
		
	}
	
	public static String sendInviteViaLeaderboard() throws FindFailed
	{
		
			s.find("lobby//Lobby_Invite_Button_Leaderboard.png");
			
			s.click("lobby//Lobby_Invite_Button_Leaderboard.png");
			
			s.wait(5.0);
			
			s.find("browser//facebook_Send_Button.png");
			
			s.click("browser//facebook_Send_Button.png");
			
			s.wait(5.0);
			
			s.find("lobby//Lobby_Invited_Button_Leaderboard.png");
			
			String res = "[testprogress]The Invite Was Sent Via The Leaderboard - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	
	//Top Bar - elements are present 
	
	public static String balanceFieldIsPresent() throws FindFailed //For balance = 2.030.000
	{
		
			s.find("lobby//Lobby_topBar_balance2030000.png");				
			
			String res = "[testprogress] The Balance Field Is Present (2.030.000) - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	public static String levelBarIsPresent() throws FindFailed //For level = 1 (empty bar)
	{
		
			s.find("lobby//Lobby_topBar_level1empty.png");				
			
			String res = "[testprogress] The Level Bar Is Present (1 level - empty) - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	public static String loyaltyButtonIsPresent() throws FindFailed //For level = 1 (empty bar)
	{
		
			s.find("lobby//Lobby_topBar_loyaltyButton.png");				
			
			String res = "[testprogress] The Loyalty Button Is Present - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	public static String shopButtonsArePresent() throws FindFailed //For level = 1 (empty bar)
	{
		
			s.find("lobby//Lobby_buyButton.png");			
			s.find("lobby//Lobby_topBar_getCoins.png");	
			s.find("lobby//Lobby_topBar_coinsIcon.png");	
			
			String res = "[testprogress] The Shop Buttons Are Present - OK";
			
			System.out.println(res);
			
			return res;
	}
	
	public static String giftButtonIsPresent() throws FindFailed //For level = 1 (empty bar)
	{
		
			s.find("lobby//Lobby_Gift_Box_Tab.png");				
			
			String res = "[testprogress] The Gift Button Is Present - OK";
			
			System.out.println(res);
			
			return res;
	}
}
