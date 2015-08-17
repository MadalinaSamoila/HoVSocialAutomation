package test;

import java.io.IOException;

import org.sikuli.script.Screen;
import org.testng.annotations.*;

public class HoVSmokeTests {
	static Screen screen= new Screen();
	
	@Test
	public void FreshInstallTest() {
		
	}
	
	@Test
	public void TutorialInstigates() {
		
		if (LobbyOperations.isTimeBonusTutorialStepPresentAndClick())
		{
			System.out.println("[testprogress] Tutorial Time Bonus Step is Present and Clicked - OK");
			
			if (LobbyOperations.isChooseMachineTutorialStepPresentAndClick())
			{
				System.out.println("[testprogress] Tutorial Choose Machine Step is Present and Clicked - OK");
				
				if (LobbyOperations.isSelectBetTutorialStepPresentAndClick())
				{
					System.out.println("[testprogress] Tutorial Select Bet Step is Present and Clicked - OK");										
					
					switch (SlotOperations.specifySlot())
					{
						case 0:
						{
							System.out.println("[teststat] The User was not placed into the Slot - FAILED");
							
							break;
						}
						case 1:
						{
							System.out.println("[testprogress] The User Placed into NexGen Slot - OK");
							
							if (LobbyOperations.returnToLobby())
							{
								System.out.println("[teststat] Returned to the Lobby - OK");
							}
							else
							{
								System.out.println("[teststat] The User was not placed into the Lobby - FAILED");
							}
							
							break;
						}
						case 2:
						{
							System.out.println("[testprogress] The User Placed into GAN Slot - OK");
							
							if (LobbyOperations.returnToLobby())
							{
								System.out.println("[teststat] Returned to the Lobby - OK");
							}
							else
							{
								System.out.println("[teststat] The User was not placed into the Lobby - FAILED");
							}
							
							break;
						}
						case 3:
						{
							System.out.println("[testprogress] The User Placed into GDK Slot - OK");
							
							if (LobbyOperations.returnToLobby())
							{
								System.out.println("[teststat] Returned to the Lobby - OK");
							}
							else
							{
								System.out.println("[teststat] The User was not placed into the Lobby - FAILED");
							}
							
							break;
						}
					}
				}
				else
				{
					System.out.println("[teststat] Tutorial Select Bet Step is Absent - FAILED");
				}
			}
			else
			{
				System.out.println("[teststat] Tutorial Choose Machine Step is Absent - FAILED");
			}
		}
		else
		{
			System.out.println("[teststat] Tutorial Time Bonus Step is Absent - FAILED");
		}
	
	}
	
	@Test
	public void PlacedInLobby() {
		
		if (LobbyOperations.isLobbyReturned(0) == true)
		{
			System.out.println("[teststat] User is placed in the Lobby - OK");
		}
		
		else
		{
			System.out.println("[teststat] User is not placed in the Lobby - Failed");
		}
		
	}
	
	@Test 
	public void DailyBonusPresent() {
		if (LobbyOperations.isDailyWheelPresent())
		{
			System.out.println("[testprogress] Daily Wheel is Present - OK");
			
			if (LobbyOperations.clickDailyWheelSpin())
			{
				System.out.println("[testprogress] Daily Wheel Spin Complete - OK");
				
				if (LobbyOperations.isDailyWheelSharePresent())
				{
					System.out.println("[testprogress] Daily Wheel Share is ticked - DISABLING SHARE - OK");
					
					if (LobbyOperations.untickDailyWheelShare())
					{
						System.out.println("[testprogress] Daily Wheel Share is Unticked - OK");
					}
					else
					{
						System.out.println("[testprogress] Unable to Untick Daily Wheel Share");
					}
				}
				
				if (LobbyOperations.clickDailyWheelCollect())
				{
					System.out.println("[teststat] Daily Wheel Collect Button is Clicked - OK");
				}
				else
				{
					System.out.println("[teststat] Daily Wheel Collect Button is not Clicked - FAILED");
				}
				
			}
			else
			{
				System.out.println("[teststat] Unable to Spin Daily Wheel - FAILED");
			}
		}
		else
		{
			System.out.println("[teststat] Daily Wheel is Absent - FAILED");
		}
		
	}
	
	@Test
	public void EnabledCRMsAppear() {
		
	}
	
	@Test
	public void HelpFanPageOpen() {
		if (LobbyOperations.clickFanPage() == true)
		{
			System.out.println("[testprogress] Fan page button is found and clicked - OK");
								
			if (LobbyOperations.isFanPageOpened() == true)
			{
				System.out.println("[testprogress] Fan page from top bar is opened - OK");
				
				BrowserOperations.closeTab(BrowserOperations.getBrowserName());
				
				//s.click("browserFFButtons//closeTabFFButton.png"); // Will be changed to Maddy`s tab closing method
				
				if (LobbyOperations.isLobbyReturned(1) == true)
				{
					System.out.println("[testprogress] Lobby is returned from Fan Page - OK");
					
					if (LobbyOperations.clickSupportPage() == true)
					{
						System.out.println("[testprogress] Support page is found and clicked - OK");
						
						if (LobbyOperations.isHelpPageOpened() == true)
						{
							System.out.println("[testprogress] Support page from the bottom is opened - OK");
							
							BrowserOperations.closeTab(BrowserOperations.getBrowserName());
							
							//s.click("browserFFButtons//closeTabFFButton.png");  // Will be changed to Maddy`s tab closing method
							
							//s.wait(4.0);
							
							//s.wheel("lobby//SupportLinkFooter.png", -1, 2);
							
							if (LobbyOperations.isLobbyReturned(2) == true)
							{
								System.out.println("[teststat] Lobby is returned from Support Page - OK");
							}
							
							else
							{
								System.out.println("[teststat] Lobby is not returned from Support Page - Failed");
							}
							
						}
						
						else 
						{
							System.out.println("[teststat] Support page from the bottom is not opened - FAILED");
						}
					}
					
					
					else
					{
						System.out.println("[teststat] Support page is not found and clicked - FAILED");
					}
					
				}
				
				else
				{
					System.out.println("[teststat] Lobby is not returned from Fan Page - FAILED");
				}
			}
			else
			{
				System.out.println("[teststat] Fan page from top bar is not opened - FAILED");
			}
		}
		else
		{
			System.out.println("[teststat] Fan page button cannot be found - FAILED");
		}
	}
	
	@Test
	public void BuyAllCoinPackages() {
		
		if (LobbyOperations.isBuyButtonPresentAndClick())
		{
			System.out.println("[testprogress] Lobby Buy Button is Present and Clicked - OK");
			
			//if (LobbyOperations.isShopOpened())   //The Shop popup was changed, performing recognition via "PURCHASE" button only
			//{
				
				
				//System.out.println("[testprogress] Shop Opened - OK");
				
				if (LobbyOperations.isPurchaseButtonPresentAndClick())
				{
					System.out.println("[testprogress] Purchase Button is Present and has been clicked - OK");
					
					
					
					if (LobbyOperations.isFbConfirmPopupPresentAndClickBuyButton(false))
					{
						System.out.println("[testprogress] FB Popup (General) is Present and Buy button has been clicked - OK");
						
						
						
						if (LobbyOperations.isUpsalePopupPresentAndClickSpinButton())
						{
							System.out.println("[testprogress] Upsale Popup is Present and Spin has been clicked - OK");
							
							
							
							if (LobbyOperations.isFbConfirmPopupPresentAndClickBuyButton(true))
							{
								System.out.println("[testprogress] FB Popup (Upsale) is Present and Buy button has been clicked - OK");
								
								
								
								if (LobbyOperations.isUpsalePopupCompletedPresentAndClickCollectButton())
								{
									System.out.println("[testprogress] Upsale Completed and Collect button has been clicked - OK");
									
									
									
									if (LobbyOperations.isCongratulationPopupPresentAndClickOkayButton())
									{
										System.out.println("[testprogress] Congratulation Popup is Present and Okay button has been clicked - OK");
									}
									else
									{
										System.out.println("[testprogress] Congratulation Popup is Absent or Okay button is Absent - Failed");
									}
								}
								else
								{
									System.out.println("[teststat] Can't Find Completed Upsale Popup or click Upsale Collect Button - FAILED");
								}
							}
							else
							{
								System.out.println("[teststat] Can't Find FB Popup or click FB Buy Button (Upsale) - FAILED");
							}
						}
						else
						{
							System.out.println("[teststat] Can't Find Upsale Popup or Upsale Spin Button - FAILED");
						}
						
					}
					else
					{
						System.out.println("[teststat] Can't Find FB Popup or click FB Buy Button (General) - FAILED");
					}
					
					
				}
				else
				{
					System.out.println("[teststat] Can't Click Shop Purchase Button - FAILED");
				}
			//}
			//else
			//{
			//	System.out.println("[teststat] Shop Popup is Absent - FAILED");
			//}
		}
		else
		{
			System.out.println("[testprogress] Lobby Buy Button is Absent - UNABLE_TO_CONTINUE");
		}
	}
	
	@Test
	public void QuickBuyFunctional() {
		if (LobbyOperations.isQuickBuyPanelPresent())
		{
			System.out.println("[testprogress] QuickBuy Panel is Present - OK");
			
			if (LobbyOperations.quickBuyDownClick())
			{
				System.out.println("[testprogress] QuickBuy Down Button is Present and Clicked - OK");
				
				if (LobbyOperations.isQuickBuyDropDownPresent())
				{
					System.out.println("[testprogress] QuickBuy DropDown List is Present - OK");
					
					if (LobbyOperations.quickBuyUpClick())
					{
						System.out.println("[testprogress] QuickBuy Up Button is Present and Clicked - OK");
						
						if (LobbyOperations.quickBuyBuyClick())
						{
							System.out.println("[testprogress] QuickBuy Buy Button is Present and Clicked - OK");
							////////////////////SPEC_QUICKBUY////////////////////////////////
							if (LobbyOperations.isFbConfirmPopupPresentAndClickBuyButton(false))
							{
								System.out.println("[testprogress] FB Popup (General) is Present and Buy button has been clicked - OK");
								
								if (LobbyOperations.isUpsalePopupPresentAndClickSpinButton())
								{
									System.out.println("[testprogress] Upsale Popup is Present and Spin has been clicked - OK");
									
									if (LobbyOperations.isFbConfirmPopupPresentAndClickBuyButton(true))
									{
										System.out.println("[testprogress] FB Popup (Upsale) is Present and Buy button has been clicked - OK");
										
										if (LobbyOperations.isUpsalePopupCompletedPresentAndClickCollectButton())
										{
											System.out.println("[testprogress] Upsale Completed and Collect button has been clicked - OK");
											
											if (LobbyOperations.isCongratulationPopupPresentAndClickOkayButton())
											{
												System.out.println("[teststat] Congratulation Popup is Present and Okay button has been clicked - OK");
											}
											else
											{
												System.out.println("[testprogress] Congratulation Popup is Absent or Okay button is Absent - Failed");
											}
										}
										else
										{
											System.out.println("[teststat] Can't Find Completed Upsale Popup or click Upsale Collect Button - FAILED");
										}
									}
									else
									{
										System.out.println("[teststat] Can't Find FB Popup or click FB Buy Button (Upsale) - FAILED");
									}
								}
								else
								{
									System.out.println("[teststat] Can't Find Upsale Popup or Upsale Spin Button - FAILED");
								}
								
							}
							else
							{
								System.out.println("[teststat] Can't Find FB Popup or click FB Buy Button (General) - FAILED");
							}
							
							
							////////////////////SPEC_QUICKBUY////////////////////////////////
						}
						else
						{
							System.out.println("[teststat] QuickBuy Buy Button is Absent - FAILED");
						}
					}
					else
					{
						System.out.println("[teststat] QuickBuy Up Button is Absent - FAILED");
					}
				}
				else
				{
					System.out.println("[teststat] QuickBuy DropDown List is Absent - FAILED");
				}
			}
			else
			{
				System.out.println("[teststat] QuickBuy Down Button is Absent - FAILED");
			}
		}
		else
		{
			System.out.println("[testprogress] QuickBuy Panel is Absent - UNABLE_TO_CONTINUE");
		}
		
		
	}
	
	@Test
	public void CollectHourlyBonus() {
		
		if (LobbyOperations.isTimeBonusEnabled())
		{
			System.out.println("[testprogress] Time Bonus Enabled - OK");
			
			if (LobbyOperations.clickCollectTimeBonus())
			{
				System.out.println("[testprogress] Time Bonus Clicked - OK");
				
				if (LobbyOperations.isCollectedTimeBonus())
				{
					System.out.println("[teststat] Time Bonus Collected - OK");
				}
				else
				{
					System.out.println("[teststat] Time Bonus is not Collected - FAILED");
				}
			}
			else
			{
				System.out.println("[teststat] Time Bonus Not Clicked - FAILED");
			}
		}
		else
		{
			System.out.println("[testprogress] Time Bonus Disabled - UNABLE_TO_CONTINUE");
		}
		
	}
	
	@Test
	public void SlotMachinesPresent() {
		
	}
	
	
	
	@BeforeSuite
	public void beforeSuite(String browser) {
		try {
			FacebookOperations.createTestUser();
			BrowserOperations.openBrowser(browser);
			
			screen.wait(1.5);

			BrowserOperations.clickSearch(browser);
			FacebookOperations.loginTestUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterSuite
	public void afterSuite() {
		try {
			FacebookOperations.deleteTestUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
