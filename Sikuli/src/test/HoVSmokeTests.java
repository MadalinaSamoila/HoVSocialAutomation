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
			System.out.println(e.getMessage());
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
			testRailComment += LobbyOperations.ClickCongratulationOkayButton() + "\n"; //isCongratulationPopupPresentAndClickOkayButton() was
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
		try
		{
			testRailComment += LobbyOperations.clickFanPage() + "\n";	
			testRailComment += LobbyOperations.isFanPageOpened() + "\n";	
			BrowserOperations.closeTab();
			testRailComment += LobbyOperations.isLobbyReturned(1) + "\n";
			testRailComment += LobbyOperations.clickSupportPage() + "\n";
			testRailComment += LobbyOperations.isHelpPageOpened() + "\n";		
			BrowserOperations.closeTab();
			//s.wait(4.0);
			testRailComment += LobbyOperations.isLobbyReturned(2) + "\n";
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
	}
	
	@Test
	public void BuyAllCoinPackages() throws FindFailed, APIException, IOException {
		String testRailTitle = "User can successfully purchase all coin packages within the shop and they have the option to upsale their purchase";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		try
		{
			testRailComment += LobbyOperations.isBuyButtonPresentAndClick() + "\n";
			//testRailComment += LobbyOperations.isShopOpened() + "\n";   //The Shop popup was changed, performing recognition via "PURCHASE" button only
			testRailComment += LobbyOperations.isPurchaseButtonPresentAndClick() + "\n";
			testRailComment += LobbyOperations.isFbConfirmPopupPresentAndClickBuyButton(false) + "\n";
			testRailComment += LobbyOperations.isUpsalePopupPresentAndClickSpinButton() + "\n";
			testRailComment += LobbyOperations.isFbConfirmPopupPresentAndClickBuyButton(true) + "\n";
			testRailComment += LobbyOperations.isUpsalePopupCompletedPresentAndClickCollectButton() + "\n";
			testRailComment += LobbyOperations.ClickCongratulationOkayButton() + "\n"; //isCongratulationPopupPresentAndClickOkayButton() was
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
	}
	
	@Test
	public void QuickBuyFunctional() throws FindFailed, APIException, IOException {
		String testRailTitle = "Quick Buy bar is functioning as intended";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		try
		{
			testRailComment += LobbyOperations.isQuickBuyPanelPresent() + "\n";
			testRailComment += LobbyOperations.quickBuyDownClick() + "\n";
			testRailComment += LobbyOperations.isQuickBuyDropDownPresent() + "\n";
			testRailComment += LobbyOperations.quickBuyUpClick() + "\n";
			testRailComment += LobbyOperations.quickBuyBuyClick() + "\n";
			////////////////////SPEC_QUICKBUY////////////////////////////////
			testRailComment += LobbyOperations.isFbConfirmPopupPresentAndClickBuyButton(false) + "\n";
			testRailComment += LobbyOperations.isUpsalePopupPresentAndClickSpinButton() + "\n";
			testRailComment += LobbyOperations.isFbConfirmPopupPresentAndClickBuyButton(true) + "\n";
			testRailComment += LobbyOperations.isUpsalePopupCompletedPresentAndClickCollectButton() + "\n";
			testRailComment += LobbyOperations.ClickCongratulationOkayButton() + "\n"; //isCongratulationPopupPresentAndClickOkayButton() was
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
	}
	
	@Test
	public void CollectHourlyBonus() throws FindFailed, APIException, IOException {
		String testRailTitle = "User can collect their hourly bonus";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		try
		{
			testRailComment += LobbyOperations.isTimeBonusEnabled() + "\n";
			testRailComment += LobbyOperations.clickCollectTimeBonus() + "\n";
			testRailComment += LobbyOperations.isCollectedTimeBonus() + "\n";
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
		
	}
	
	
	//SlotMachinesPresent() check now includes jackpot ticker, +/- balance after spin and dash buttons checks, so we do not waste time 
	@Test
	public void SlotMachinesPresent() throws FindFailed, IOException, APIException {
		String testRailTitle = "All slot machines are present, with their relevant graphics and Toppers (E.G Jackpot, hot new game etc...)";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";

		int ngLoaded = 0;
		int ganLoaded = 0;
		int gdkLoaded = 0;
		int errLoaded = 0;
		
		boolean isJPAndDashChecksDone = false;
		
		
		try
		{
			if ((LobbyOperations.isNextSlotComingSoon()) || (LobbyOperations.isNextSlotEarlyAccess()))
			{				
				LobbyOperations.skipNextEarlyAccessAndComingSoonSlots();
				LobbyOperations.clickNextSlot();
				LobbyOperations.clickClosePopup();
			}
			LobbyOperations.saveCentralSlotRegion();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		while(true)
		{
			if ((LobbyOperations.isNextSlotComingSoon()) || (LobbyOperations.isNextSlotEarlyAccess()))
			{				
				LobbyOperations.skipNextEarlyAccessAndComingSoonSlots();
			}
			else
			{
				try
				{
					LobbyOperations.clickNextSlot();
										
					LobbyOperations.clickCabinetPlayButton();
																							
					switch (SlotOperations.specifySlot())
					{
						case 0:
						{
							System.out.println("[teststat] The User was not placed into the Slot or the Slot Displays incorrectly - FAILED");
							errLoaded++;
							System.out.println("[teststat] FORCE TRYING TO RETURN TO THE LOBBY");
							System.out.println(LobbyOperations.returnToLobby());
																									
							break;
						}
						case 1:
						{
							System.out.println("[testprogress] The User Placed into NexGen Slot - OK");
							ngLoaded++;
							System.out.println(LobbyOperations.returnToLobby());
							
							break;
						}
						case 2:
						{
							System.out.println("[testprogress] The User Placed into GAN Slot - OK");
							ganLoaded++;
							System.out.println(LobbyOperations.returnToLobby());
							
							break;
						}
						case 3:
						{
							System.out.println("[testprogress] The User Placed into GDK Slot - OK");
							gdkLoaded++;
							
							//here implement JP and Dash check
							
							if (SlotOperations.isJPNotValid() && !isJPAndDashChecksDone)
							{
	//REMOVE_COMMENT_BEFORE_MERGING							//AdminOperations.setLevel("chrome", FacebookOperations.userFacebookId, 82);
								
								JackpotValidationCheck();
								
								isJPAndDashChecksDone = true;
							}
							
							//end of JP and Dash check
							System.out.println(LobbyOperations.returnToLobby());
							
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
				catch (FindFailed e)
				{
					testRailComment += e.getMessage();
					testRailComment += "\n Restarting The App. Unable to Continue Test \n";
					BrowserOperations.refreshPage(true);
					testRailComment += "[testres] GAN - "+ganLoaded+"; GDK - "+gdkLoaded+ "; NG - "+ngLoaded+" ; Does Not Load - "+errLoaded + "\n";
					TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
					break;
				}
			}
		}
	}
	
	
	
	public void JackpotValidationCheck() throws FindFailed, APIException, IOException
	{
		String testRailTitle = "Jackpots update their acceptance state when changing coin denomination inside an active machine";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "[testprogress] Jackpot is Not Valid Now - OK" + "\n";
		try
		{
			testRailComment += SlotOperations.clickMaxBetButton() + "\n";
			
			if (SlotOperations.isJPValid())
			{
				testRailComment += "[testres] Jackpot is Valid Now - OK" + "\n";
				TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
				CheckGDKDashButtons();
			}
			else
			{
				testRailComment += "[testres] Jackpot is not Valid Now After Clicking MaxBet Button - FAILED" + "\n";
				TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
			}
				
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
		catch (APIException ex)
		{
			System.out.println(testRailComment);
		}
	}
	
	
	public void CheckGDKDashButtons() throws APIException, IOException
	{
		String testRailTitle = "All Dash buttons are functional for GDK games";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		try
		{
			SlotOperations.storeOrCompareRegion("slot", "store");
			testRailComment += SlotOperations.clickHelpButton() + "\n";
			screen.wait(1.5);
			if (!SlotOperations.storeOrCompareRegion("slot", "compare"))
			{
				testRailComment += ("[testprogress] GameInfo Page Was Opened - OK" + "\n");				
				testRailComment += SlotOperations.exitFromHelp() + "\n";
				
				//testRailComment += ("[testprogress] GameInfo Page Was Closed - OK");
				SlotOperations.storeOrCompareRegion("bet", "store");
				screen.wait(1.5);
				testRailComment += SlotOperations.clickDecraseBetButton() + "\n";
				testRailComment += SlotOperations.clickDecraseBetButton() + "\n";
				testRailComment += SlotOperations.clickDecraseBetButton() + "\n";
				testRailComment += SlotOperations.clickDecraseBetButton() + "\n";
				if (!SlotOperations.storeOrCompareRegion("bet", "compare"))
				{
					testRailComment += ("[testprogress] Bet Amount Was Changed - OK" + "\n");
					SlotOperations.storeOrCompareRegion("bet", "store");
					screen.wait(1.5);
					testRailComment += SlotOperations.clickIncraseBetButton() + "\n";
					testRailComment += SlotOperations.clickIncraseBetButton() + "\n";
					testRailComment += SlotOperations.clickIncraseBetButton() + "\n";
					testRailComment += SlotOperations.clickIncraseBetButton() + "\n";
					if (!SlotOperations.storeOrCompareRegion("bet", "compare"))
					{
						testRailComment += ("[testprogress] Bet Amount Was Changed - OK" + "\n");
						
						/////////////////////////////////DEBUG
						//FacebookOperations.userFacebookId = "100005189688884";
						//////////////////////////////////////
						String GAID = AdminOperations.getGAID("chrome", FacebookOperations.userFacebookId);
						testRailComment += SlotOperations.clickDecraseBetButton() + "\n";
						testRailComment += SlotOperations.clickDecraseBetButton() + "\n";
						testRailComment += SlotOperations.clickDecraseBetButton() + "\n";
						testRailComment += SlotOperations.clickDecraseBetButton() + "\n";
						///////////////////////////////DEBUG
						//String GAID = "6244689";//////////
						////////////////////////////////////
						AdminOperations.storeOrCompareUserBalance("store", GAID);
						
						testRailComment += SlotOperations.clickAutospinActivate() + "\n";
						screen.wait(7.1);
						testRailComment += SlotOperations.clickAutospinDeactivate() + "\n";
						//screen.wait(5.1);
						if (AdminOperations.storeOrCompareUserBalance("compare", GAID) != 0)
						{
							System.out.println("[testprogress] Balance Was Changed After Deactivating Autospin - OK");
							testRailComment += ("[testprogress] Balance Was Changed After Deactivating Autospin - OK" + "\n");
							
							testRailComment += SlotOperations.clickSpinButton() + "\n";
							
							if (AdminOperations.storeOrCompareUserBalance("compare", GAID) != 0)
							{
								System.out.println("[testprogress] Balance Was Changed After Spin - OK");
								testRailComment += ("[testprogress] Balance Was Changed After Spin - OK" + "\n");
								TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
								
								CheckBalanceAdditionsAndSubtractions();
								
								
							}
							else
							{
								System.out.println("[testres] Balance Was Not Changed After Spin - FAILED");
								testRailComment += ("[testres] Balance Was Not Changed After Spin - FAILED" + "\n");
								TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
							}
		
						}
						else
						{
							System.out.println("[testres] Balance Was Not Changed After Deactivating Autospin - FAILED");
							testRailComment += ("[testres] Balance Was Not Changed After Deactivating Autospin - FAILED" + "\n");
							TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
						}
						
					}
					else
					{
						testRailComment += ("[testres] Bet Amount Was Not Changed - FAILED" + "\n");
						System.out.println("[testres] Bet Amount Was Not Changed - FAILED");
						TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
					
					}
					
				}
				else
				{
					testRailComment += ("[testres] Bet Amount Was Not Changed - FAILED" + "\n");
					System.out.println("[testres] Bet Amount Was Not Changed - FAILED");
					TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
				}
								
			}
			else
			{
				testRailComment += "[testres] GameInfo Page Was Not Opened - FAILED" + "\n";
				System.out.println("[testres] GameInfo Page Was Not Opened - FAILED");
				TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
			}
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
		catch (APIException ex)
		{
			System.out.println(testRailComment);
		}
	}
	
	public void CheckBalanceAdditionsAndSubtractions() throws FindFailed, APIException, IOException
	{
		String testRailTitle = "Users balance updates with appropriate additions and subtractions";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		try
			{
			
			///////////////////////////////DEBUG
			//String GAID = "6244689";//////////
			////////////////////////////////////
			
			/////////////////////////////////DEBUG
			//FacebookOperations.userFacebookId = "100005189688884";
			//////////////////////////////////////
			String GAID = AdminOperations.getGAID("chrome", FacebookOperations.userFacebookId);
			
			
			
			AdminOperations.storeOrCompareUserBalance("store", GAID);
			testRailComment += SlotOperations.performLoosingSpinGDK()+ "\n";
			if (AdminOperations.storeOrCompareUserBalance("compare", GAID) > 0)
			{
				testRailComment += "[testres] Balance Was Changed After Loosing Spin - OK" + "\n";
				System.out.println("[testres] Balance Was Changed After Loosing Spin - OK");
				testRailComment += SlotOperations.performWininngSpinGDK()+ "\n";
				if (AdminOperations.storeOrCompareUserBalance("compare", GAID) <= 0)
				{					
					testRailComment += "[testres] Balance Was Changed After Winning Spin - OK" + "\n";
					System.out.println("[testres] Balance Was Changed After Winning Spin - OK");
					TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
				}
				else
				{
					testRailComment += "[testres] Balance Was Not Changed After Winning Spin - FAILED" + "\n";
					System.out.println("[testres] Balance Was Not Changed After Winning Spin - FAILED");
					TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
				
				}
				
			}
			else
			{
				testRailComment += "[testres] Balance Was Not Changed After Loosing Spin - FAILED" + "\n";
				System.out.println("[testres] Balance Was Not Changed After Loosing Spin - FAILED");
				TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
			
			}
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
	}
	
	@Test
	public void IngameEventsPresent(String[] ingameEventsArray) throws FindFailed, IOException, APIException 
	{
		
		String testRailTitle = "Ingame_events are being tracked";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		
				
		String testRailComment = AdminOperations.checkIngameEvents("Chrome",ingameEventsArray, FacebookOperations.userFacebookId);
		
		if (testRailComment.equals(""))
		{
			testRailComment = "Required events are present - OK";
			
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
		else
		{
			String tmp = "Can't find events: /n";
			tmp += testRailComment += " - FAILED";
			
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
		System.out.println(testRailComment);
	}
	
	
	
	@BeforeSuite
	public void beforeSuite(String browser) {
		try {
							
			FacebookOperations.loginFacebook(browser);
			screen.wait(3.0);	
			FacebookOperations.createTestUser();
			screen.wait(3.0);
			FacebookOperations.loginTestUser();
			screen.wait(3.0);						
			FacebookOperations.changeLanguageFacebook(browser);
			screen.wait(3.0);
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