package test;

import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.*;

import com.gurock.testrail.APIException;

public class HoVSmokeTests {
	static Screen screen= new Screen();
	
	@Test
	public void FreshInstallTest(String browser) throws FindFailed, APIException, IOException {
		String testRailTitle = "Fresh app install is successfull with no previous builds installed";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		try
		{		
			testRailComment += LobbyOperations.findChangeURLAndAccessUATSocial(browser) +" \n";
			testRailComment += LobbyOperations.areFreshInstallStepsCompleted() +" \n";	
				
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
		}
		catch (FindFailed e)
		{	
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
		
		
		
		
		
		
		
	}
	
	@Test
	public void TutorialInstigates() throws FindFailed, APIException, IOException {
		String testRailTitle = "Via a fresh account, the tutorial instigates and successfully walks the player through the relevant steps without any core concerns";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		try
		{	
			testRailComment += LobbyOperations.isTimeBonusTutorialStepPresentAndClick()+" \n";
			
			testRailComment += LobbyOperations.isChooseMachineTutorialStepPresentAndClick()+" \n";
			
			testRailComment += LobbyOperations.isSelectBetTutorialStepPresentAndClick()+" \n";	
						
			switch (SlotOperations.specifySlot())
			{
				case 0:
				{
					System.out.println("[teststat] The User was not placed into the Slot Or Slot Displays Incorrectly - FAILED");
					testRailComment += "[teststat] The User was not placed into the Slot Or Slot Displays Incorrectly - FAILED \n";
					TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
					break;
				}
				case 1:
				{
					System.out.println("[testprogress] The User Placed into NexGen Slot - OK");
					testRailComment += "[testprogress] The User Placed into NexGen Slot - OK \n";
					
					testRailComment += LobbyOperations.returnToLobby();
					
					TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
					
					break;
				}
				case 2:
				{
					System.out.println("[testprogress] The User Placed into GAN Slot - OK");
					testRailComment += "[testprogress] The User Placed into GAN Slot - OK \n";
					
					testRailComment += LobbyOperations.returnToLobby();
					
					TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
								
					break;
				}
				case 3:
				{
					System.out.println("[testprogress] The User Placed into GDK Slot - OK");
					testRailComment += "[testprogress] The User Placed into GDK Slot - OK \n";
					
					testRailComment += LobbyOperations.returnToLobby();
					
					TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
									
					break;
				}
			}
			
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
	
	}
	
	@Test
	public void PlacedInLobby() throws FindFailed, APIException, IOException {
		String testRailTitle = "User is successfully placed into the apps lobby";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		try
		{
			testRailComment += LobbyOperations.isLobbyReturned(0) + "\n";
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
	}
	
	@Test 
	public void DailyBonusPresent() throws FindFailed, APIException, IOException {
		String testRailTitle = "Daily Bonus is present in build, opening upon load (if in a ready status) and functions as expected";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		
		try
		{
			testRailComment += LobbyOperations.isDailyWheelPresent();
			
			testRailComment += LobbyOperations.clickDailyWheelSpin();
					
			if (LobbyOperations.isDailyWheelSharePresent())
			{
				System.out.println("[testprogress] Daily Wheel Share is ticked - DISABLING SHARE - OK");
				testRailComment += "[testprogress] Daily Wheel Share is ticked - DISABLING SHARE - OK \n";	
				testRailComment += LobbyOperations.untickDailyWheelShare();	
			}
					
			testRailComment += LobbyOperations.clickDailyWheelCollect();
				
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();	
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}		
		
	}
	
	@Test
	public void EnabledCRMsAppear() throws FindFailed, APIException, IOException {
		String testRailTitle = "CRM's that are enabled appear and function as expected";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		try
		{
			testRailComment += LobbyOperations.clickCentralSlot() + "\n";
			testRailComment += LobbyOperations.isCRMOpened() + "\n";
			testRailComment += LobbyOperations.clickCloseButtonCRM() + "\n";
			testRailComment += LobbyOperations.isCRMClosed() + "\n";
			testRailComment += LobbyOperations.clickNextSlot() + "\n";
			testRailComment += LobbyOperations.isCRMOpened() + "\n";
			testRailComment += LobbyOperations.clickCRM() + "\n";
			testRailComment += LobbyOperations.ClickCongratulationOkayButton() + "\n"; //ClickCongratulationOkayButton() method now
			testRailComment += LobbyOperations.isCRMClosed() + "\n";
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
	}
	
	@Test
	public void HelpFanPageOpen() throws FindFailed, APIException, IOException {
		String testRailTitle = "Help & Fan page can be successfully loaded from within game";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		
		if (LobbyOperations.clickFanPage() == true)
		{
			System.out.println("[testprogress] Fan page button is found and clicked - OK");
			testRailComment += "[testprogress] Fan page button is found and clicked - OK \n";
								
			if (LobbyOperations.isFanPageOpened() == true)
			{
				System.out.println("[testprogress] Fan page from top bar is opened - OK");
				testRailComment += "[testprogress] Fan page from top bar is opened - OK \n";
				
				BrowserOperations.closeTab();
				
				//s.click("browserFFButtons//closeTabFFButton.png"); // Will be changed to Maddy`s tab closing method
				
				if (LobbyOperations.isLobbyReturned(1) == true)
				{
					System.out.println("[testprogress] Lobby is returned from Fan Page - OK");
					testRailComment += "[testprogress] Lobby is returned from Fan Page - OK \n";
					
					if (LobbyOperations.clickSupportPage() == true)
					{
						System.out.println("[testprogress] Support page is found and clicked - OK");
						testRailComment += "[testprogress] Support page is found and clicked - OK \n";
						
						if (LobbyOperations.isHelpPageOpened() == true)
						{
							System.out.println("[testprogress] Support page from the bottom is opened - OK");
							testRailComment += "[testprogress] Support page from the bottom is opened - OK \n";
							
							BrowserOperations.closeTab();
							
							//s.click("browserFFButtons//closeTabFFButton.png");  // Will be changed to Maddy`s tab closing method
							
							//s.wait(4.0);
							
							//s.wheel("lobby//SupportLinkFooter.png", -1, 2);
							
							if (LobbyOperations.isLobbyReturned(2) == true)
							{
								System.out.println("[teststat] Lobby is returned from Support Page - OK");
								testRailComment += "[teststat] Lobby is returned from Support Page - OK \n";
								TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
							}
							
							else
							{
								System.out.println("[teststat] Lobby is not returned from Support Page - Failed");
								testRailComment += "[teststat] Lobby is not returned from Support Page - FAILED \n";
								TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
								
							}
							
						}
						
						else 
						{
							System.out.println("[teststat] Support page from the bottom is not opened - FAILED");
							testRailComment += "[teststat] Support page from the bottom is not opened - FAILED \n";
							TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
						}
					}
					
					
					else
					{
						System.out.println("[teststat] Support page is not found and clicked - FAILED");
						testRailComment += "[teststat] Support page is not found and clicked - FAILED \n";
						TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
					}
					
				}
				
				else
				{
					System.out.println("[teststat] Lobby is not returned from Fan Page - FAILED");
					testRailComment += "[teststat] Lobby is not returned from Fan Page - FAILED \n";
					TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
				}
			}
			else
			{
				System.out.println("[teststat] Fan page from top bar is not opened - FAILED");
				testRailComment += "[teststat] Fan page from top bar is not opened - FAILED \n";
				TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
			}
		}
		else
		{
			System.out.println("[teststat] Fan page button cannot be found - FAILED");
			testRailComment += "[teststat] Fan page button cannot be found - FAILED \n";
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
	}
	
	@Test
	public void BuyAllCoinPackages() throws FindFailed, APIException, IOException {
		String testRailTitle = "User can successfully purchase all coin packages within the shop and they have the option to upsale their purchase";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		
		if (LobbyOperations.isBuyButtonPresentAndClick())
		{
			System.out.println("[testprogress] Lobby Buy Button is Present and Clicked - OK");
			testRailComment += "[testprogress] Lobby Buy Button is Present and Clicked - OK \n";
			
			//if (LobbyOperations.isShopOpened())   //The Shop popup was changed, performing recognition via "PURCHASE" button only
			//{
				
				
				//System.out.println("[testprogress] Shop Opened - OK");
				//testRailComment += "[testprogress] Shop Opened - OK \n";
				
				if (LobbyOperations.isPurchaseButtonPresentAndClick())
				{
					System.out.println("[testprogress] Purchase Button is Present and has been clicked - OK");
					testRailComment += "[testprogress] Purchase Button is Present and has been clicked - OK \n";
					
					
					if (LobbyOperations.isFbConfirmPopupPresentAndClickBuyButton(false))
					{
						System.out.println("[testprogress] FB Popup (General) is Present and Buy button has been clicked - OK");
						testRailComment += "[testprogress] FB Popup (General) is Present and Buy button has been clicked - OK \n";
						
						
						if (LobbyOperations.isUpsalePopupPresentAndClickSpinButton())
						{
							System.out.println("[testprogress] Upsale Popup is Present and Spin has been clicked - OK");
							testRailComment += "[testprogress] Upsale Popup is Present and Spin has been clicked - OK \n";
							
							
							if (LobbyOperations.isFbConfirmPopupPresentAndClickBuyButton(true))
							{
								System.out.println("[testprogress] FB Popup (Upsale) is Present and Buy button has been clicked - OK");
								testRailComment += "[testprogress] FB Popup (Upsale) is Present and Buy button has been clicked - OK \n";
								
								
								if (LobbyOperations.isUpsalePopupCompletedPresentAndClickCollectButton())
								{
									System.out.println("[testprogress] Upsale Completed and Collect button has been clicked - OK");
									testRailComment += "[testprogress] Upsale Completed and Collect button has been clicked - OK \n";
									
									
									if (LobbyOperations.isCongratulationPopupPresentAndClickOkayButton())
									{
										System.out.println("[teststat] Congratulation Popup is Present and Okay button has been clicked - OK");
										testRailComment += "[teststat] Congratulation Popup is Present and Okay button has been clicked - OK \n";
										TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
									}
									else
									{
										System.out.println("[teststat] Congratulation Popup is Absent or Okay button is Absent - Failed");
										testRailComment += "[teststat] Congratulation Popup is Absent or Okay button is Absent - FAILED \n";

										TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
									}
								}
								else
								{
									System.out.println("[teststat] Can't Find Completed Upsale Popup or click Upsale Collect Button - FAILED");
									testRailComment += "[teststat] Can't Find Completed Upsale Popup or click Upsale Collect Button - FAILED \n";
									TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
								}
							}
							else
							{
								System.out.println("[teststat] Can't Find FB Popup or click FB Buy Button (Upsale) - FAILED");
								testRailComment += "[teststat] Can't Find FB Popup or click FB Buy Button (Upsale) - FAILED \n";
								TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
							}
						}
						else
						{
							System.out.println("[teststat] Can't Find Upsale Popup or Upsale Spin Button - FAILED");
							testRailComment += "[teststat] Can't Find Upsale Popup or Upsale Spin Button - FAILED \n";
							TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
						}
						
					}
					else
					{
						System.out.println("[teststat] Can't Find FB Popup or click FB Buy Button (General) - FAILED");
						testRailComment += "[teststat] Can't Find FB Popup or click FB Buy Button (General) - FAILED \n";
						TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
					}
					
					
				}
				else
				{
					System.out.println("[teststat] Can't Click Shop Purchase Button - FAILED");
					testRailComment += "[teststat] Can't Click Shop Purchase Button - FAILED \n";
					TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
				}
			//}
			//else
			//{
			//	System.out.println("[teststat] Shop Popup is Absent - FAILED");
			//	testRailComment += "[teststat] Shop Popup is Absent - FAILED \n";
			//}
		}
		else
		{
			System.out.println("[teststat] Lobby Buy Button is Absent - UNABLE_TO_CONTINUE");
			testRailComment += "[teststat] Lobby Buy Button is Absent - FAILED \n";

			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
	}
	
	@Test
	public void QuickBuyFunctional() throws FindFailed, APIException, IOException {
		String testRailTitle = "Quick Buy bar is functioning as intended";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		
		if (LobbyOperations.isQuickBuyPanelPresent())
		{
			System.out.println("[testprogress] QuickBuy Panel is Present - OK");
			testRailComment += "[testprogress] QuickBuy Panel is Present - OK \n";
			
			if (LobbyOperations.quickBuyDownClick())
			{
				System.out.println("[testprogress] QuickBuy Down Button is Present and Clicked - OK");
				testRailComment += "[testprogress] QuickBuy Down Button is Present and Clicked - OK \n";
				
				if (LobbyOperations.isQuickBuyDropDownPresent())
				{
					System.out.println("[testprogress] QuickBuy DropDown List is Present - OK");
					testRailComment += "[testprogress] QuickBuy DropDown List is Present - OK \n";
					
					if (LobbyOperations.quickBuyUpClick())
					{
						System.out.println("[testprogress] QuickBuy Up Button is Present and Clicked - OK");
						testRailComment += "[testprogress] QuickBuy Up Button is Present and Clicked - OK \n";
						
						if (LobbyOperations.quickBuyBuyClick())
						{
							System.out.println("[testprogress] QuickBuy Buy Button is Present and Clicked - OK");
							testRailComment += "[testprogress] QuickBuy Buy Button is Present and Clicked - OK \n";
							////////////////////SPEC_QUICKBUY////////////////////////////////
							if (LobbyOperations.isFbConfirmPopupPresentAndClickBuyButton(false))
							{
								System.out.println("[testprogress] FB Popup (General) is Present and Buy button has been clicked - OK");
								testRailComment += "[testprogress] FB Popup (General) is Present and Buy button has been clicked - OK \n";
								
								if (LobbyOperations.isUpsalePopupPresentAndClickSpinButton())
								{
									System.out.println("[testprogress] Upsale Popup is Present and Spin has been clicked - OK");
									testRailComment += "[testprogress] Upsale Popup is Present and Spin has been clicked - OK \n";
									
									if (LobbyOperations.isFbConfirmPopupPresentAndClickBuyButton(true))
									{
										System.out.println("[testprogress] FB Popup (Upsale) is Present and Buy button has been clicked - OK");
										testRailComment += "[testprogress] FB Popup (Upsale) is Present and Buy button has been clicked - OK \n";
										
										if (LobbyOperations.isUpsalePopupCompletedPresentAndClickCollectButton())
										{
											System.out.println("[testprogress] Upsale Completed and Collect button has been clicked - OK");
											testRailComment += "[testprogress] Upsale Completed and Collect button has been clicked - OK \n";
											
											if (LobbyOperations.isCongratulationPopupPresentAndClickOkayButton())
											{
												System.out.println("[teststat] Congratulation Popup is Present and Okay button has been clicked - OK");
												testRailComment += "[teststat] Congratulation Popup is Present and Okay button has been clicked - OK \n";
												TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
											}
											else
											{
												System.out.println("[teststat] Congratulation Popup is Absent or Okay button is Absent - Failed");
												testRailComment += "[teststat] Congratulation Popup is Absent or Okay button is Absent - FAILED \n";

												TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
											}
										}
										else
										{
											System.out.println("[teststat] Can't Find Completed Upsale Popup or click Upsale Collect Button - FAILED");
											testRailComment += "[teststat] Can't Find Completed Upsale Popup or click Upsale Collect Button - FAILED \n";

											TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
										}
									}
									else
									{
										System.out.println("[teststat] Can't Find FB Popup or click FB Buy Button (Upsale) - FAILED");
										testRailComment += "[teststat] Can't Find FB Popup or click FB Buy Button (Upsale) - FAILED \n";

										TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
									}
								}
								else
								{
									System.out.println("[teststat] Can't Find Upsale Popup or Upsale Spin Button - FAILED");
									testRailComment += "[teststat] Can't Find Upsale Popup or Upsale Spin Button - FAILED \n";

									TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
								}
								
							}
							else
							{
								System.out.println("[teststat] Can't Find FB Popup or click FB Buy Button (General) - FAILED");
								testRailComment += "[teststat] Can't Find FB Popup or click FB Buy Button (General) - FAILED \n";

								TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
							}
							
							
							////////////////////SPEC_QUICKBUY////////////////////////////////
						}
						else
						{
							System.out.println("[teststat] QuickBuy Buy Button is Absent - FAILED");
							testRailComment += "[teststat] QuickBuy Buy Button is Absent - FAILED \n";
							TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
						}
					}
					else
					{
						System.out.println("[teststat] QuickBuy Up Button is Absent - FAILED");
						testRailComment += "[teststat] QuickBuy Up Button is Absent - FAILED \n";
						TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
					}
				}
				else
				{
					System.out.println("[teststat] QuickBuy DropDown List is Absent - FAILED");
					testRailComment += "[teststat] QuickBuy DropDown List is Absent - FAILED \n";
					TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
				}
			}
			else
			{
				System.out.println("[teststat] QuickBuy Down Button is Absent - FAILED");
				testRailComment += "[teststat] QuickBuy Down Button is Absent - FAILED \n";
				TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
			}
		}
		else
		{
			System.out.println("[teststat] QuickBuy Panel is Absent - UNABLE_TO_CONTINUE");
			testRailComment += "[teststat] QuickBuy Panel is Absent - FAILED \n";
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
		
		
	}
	
	@Test
	public void CollectHourlyBonus() throws FindFailed, APIException, IOException {
		String testRailTitle = "User can collect their hourly bonus";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		
		if (LobbyOperations.isTimeBonusEnabled())
		{
			System.out.println("[testprogress] Time Bonus Enabled - OK");
			testRailComment += "[testprogress] Time Bonus Enabled - OK \n";
			
			if (LobbyOperations.clickCollectTimeBonus())
			{
				System.out.println("[testprogress] Time Bonus Clicked - OK");
				testRailComment += "[testprogress] Time Bonus Clicked - OK \n";
				
				if (LobbyOperations.isCollectedTimeBonus())
				{
					System.out.println("[teststat] Time Bonus Collected - OK");
					testRailComment += "[teststat] Time Bonus Collected - OK \n";
					TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
				}
				else
				{
					System.out.println("[teststat] Time Bonus is not Collected - FAILED");
					testRailComment += "[teststat] Time Bonus is not Collected - FAILED \n";
					TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
				}
			}
			else
			{
				System.out.println("[teststat] Time Bonus Not Clicked - FAILED");
				testRailComment += "[teststat] Time Bonus Not Clicked - FAILED \n";
				TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
			}
		}
		else
		{
			System.out.println("[testprogress] Time Bonus Disabled - UNABLE_TO_CONTINUE");
			testRailComment += "[teststat] Time Bonus Disabled - FAILED \n";
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
		
	}
	
	@Test
	public void SlotMachinesPresent() throws FindFailed, IOException, APIException {
		String testRailTitle = "All slot machines are present, with their relevant graphics and Toppers (E.G Jackpot, hot new game etc...)";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";

		int ngLoaded = 0;
		int ganLoaded = 0;
		int gdkLoaded = 0;
		int errLoaded = 0;
		
		if ((LobbyOperations.isNextSlotComingSoon()) || (LobbyOperations.isNextSlotEarlyAccess()))
		{				
			LobbyOperations.skipNextEarlyAccessAndComingSoonSlots();
			LobbyOperations.clickNextSlot();
			LobbyOperations.clickCloseCabinet();
		}
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
							testRailComment += "[testres] GAN - "+ganLoaded+"; GDK - "+gdkLoaded+ "; NG - "+ngLoaded+" ; Does Not Load - "+errLoaded;
							if (errLoaded != 0)
							{
								TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
							}
							else
							{
								TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
							}
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
							testRailComment += "[testres] GAN - "+ganLoaded+"; GDK - "+gdkLoaded+ "; NG - "+ngLoaded+" ; Does Not Load - "+errLoaded;
							if (errLoaded != 0)
							{
								TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
							}
							else
							{
								TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
							}
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

			BrowserOperations.clickSearch();
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