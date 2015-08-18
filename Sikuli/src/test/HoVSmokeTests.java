package test;

import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.*;

public class HoVSmokeTests {
	static Screen screen= new Screen();
	
	@Test
	public void FreshInstallTest() throws FindFailed {
		
	}
	
	@Test
	public void TutorialInstigates() throws FindFailed {
		
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
	public void PlacedInLobby() throws FindFailed {
		
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
	public void DailyBonusPresent() throws FindFailed {
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
	public void EnabledCRMsAppear() throws FindFailed {
		
		if (LobbyOperations.clickCentralSlot() == true)
		{
			System.out.println("[testprogress] Cabinet successfully clicked - OK");
			
			if (LobbyOperations.isCRMOpened() == true)
			{
				System.out.println("[testprogress] CRM is opened - OK");
				
				if (LobbyOperations.clickCloseButtonCRM() == true)
				{
					System.out.println("[testprogress] CRM close button clicked - OK");
					
					if (LobbyOperations.isCRMClosed() == true)
					{
						System.out.println("[testprogress] CRM successfully closed - OK");
						
						if (LobbyOperations.clickCentralSlot() == true)
						{
							System.out.println("[testprogress] Cabinet successfully clicked - OK");
							
							if (LobbyOperations.isCRMOpened() == true)
							{
								System.out.println("[testprogress] CRM is opened - OK");
								
								if (LobbyOperations.clickCRM() == true)
								{
									System.out.println("[testprogress] CRM body is clicked - OK");
									
									if (LobbyOperations.isCongratulationPopupPresentAndClickOkayButton() == true)
									{
										System.out.println("[testprogress] Congratulation popup is present and Okay button is clicked - OK");
										
										if (LobbyOperations.isCRMClosed() == true)
										{
											System.out.println("[teststat] Congratulation popup is closed - OK");
										}
										
										else
										{
											System.out.println("[teststat] Congratulation popup is not closed - Failed");
										}
									}
									
									else
									{
										System.out.println("[teststat] Congratulation popup is absent OR Okay button is not clicked - Failed");
									}
								}
								
								else
								{
									System.out.println("[teststat] CRM body is not clicked - Failed");
								}
							}
							
							else
							{
								System.out.println("[teststat] CRM is not opened - Failed");
							}
						}
						
						else
						{
							System.out.println("[teststat] Cabinet is not clicked - Failed");
						}
					}
					
					else
					{
						System.out.println("[teststat] CRM is not closed - Failed");
					}
				}
				
				else
				{
					System.out.println("[teststat] CRM is not clicked - Failed");
				}
			}
			
			else
			{
				System.out.println("[teststat] CRM is not opened - Failed");
			}
		}
				
		else
		{
			System.out.println("[teststat] Cabinet is not clicked - Failed");
		}
	}
	
	@Test
	public void HelpFanPageOpen() throws FindFailed {
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
	public void BuyAllCoinPackages() throws FindFailed {
		
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
	public void QuickBuyFunctional() throws FindFailed {
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
	public void CollectHourlyBonus() throws FindFailed {
		
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
	public void SlotMachinesPresent() throws FindFailed, IOException {

		int ngLoaded = 0;
		int ganLoaded = 0;
		int gdkLoaded = 0;
		int errLoaded = 0;
		
		LobbyOperations.saveCentralSlotRegion();
		
		while(true)
		{
			if ((LobbyOperations.isNextSlotComingSoon()) || (LobbyOperations.isNextSlotEarlyAccess()))
			{				
				LobbyOperations.skipNextEarlyAccessAndComingSoonSlots();
			}
			else
			{
				System.out.println("[teststat] Next Slot is not in Early Acces or Comnig Soon Status - OK");
				
				if (LobbyOperations.clickNextSlot())
				{
					System.out.println("[teststat] Next Slot Clicked - OK");
					
					if (LobbyOperations.clickCabinetPlayButton())
					{
						System.out.println("[teststat] Starting the Slot - OK");
																		
						switch (SlotOperations.specifySlot())
						{
							case 0:
							{
								System.out.println("[teststat] The User was not placed into the Slot or the Slot Displays incorrectly - FAILED");
								errLoaded++;
								System.out.println("[teststat] FORCE TRYING TO RETURN TO THE LOBBY");
								if (LobbyOperations.returnToLobby())
								{
									System.out.println("[testres] Returned to the Lobby - OK");		
									
								}
								else
								{
									System.out.println("[teststat] The User was not placed into the Lobby - FAILED");
								}
								break;
							}
							case 1:
							{
								System.out.println("[testprogress] The User Placed into NexGen Slot - OK");
								ngLoaded++;
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
								ganLoaded++;
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
								gdkLoaded++;
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
						if (LobbyOperations.isCentralSlotInitial())
						{
							System.out.println("[testres] The Slot is initial - STOP_TESTING");
							
							System.out.println("[testres] GAN - "+ganLoaded+"; GDK - "+gdkLoaded+ "; NG - "+ngLoaded+" ; Does Not Load - "+errLoaded);
							break;
							
						}
						else
						{
							System.out.println("[testres] The Slot is not initial - CONTUNUE_TESTING");
						}
					}
					else
					{
						System.out.println("[teststat] Play Button (Bet per line) Not Clicked - FAILED");
					}
				}
				else
				{
					System.out.println("[teststat] Next Slot Not Clicked - FAILED");
					System.out.println("[teststat] FORCE TRYING TO RETURN TO THE LOBBY");
					if (LobbyOperations.returnToLobby())
					{
						System.out.println("[testres] Returned to the Lobby - OK");
						if (LobbyOperations.isCentralSlotInitial())
						{
							System.out.println("[testres] The Slot is initial - STOP_TESTING");
							System.out.println("[testres] GAN - "+ganLoaded+"; GDK - "+gdkLoaded+ "; NG - "+ngLoaded+" ; Does Not Load - "+errLoaded);
							break;
							
						}
						else
						{
							System.out.println("[testres] The Slot is not initial - CONTUNUE_TESTING");
						}
						
					}
					else
					{
						System.out.println("[teststat] The User was not placed into the Lobby - FAILED");
					}
				}
			}
		}
		
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
