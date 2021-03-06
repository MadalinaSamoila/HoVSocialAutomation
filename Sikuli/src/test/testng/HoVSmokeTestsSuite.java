package test.testng;

import org.testng.annotations.Test;
import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gurock.testrail.APIException;

import test.AdminOperations;
import test.BrowserOperations;
import test.CommonOperations;
import test.FacebookOperations;
import test.LobbyOperations;
import test.SlotOperations;
import test.TestRailOperations;

public class HoVSmokeTestsSuite {
	
	
	@Parameters({"browser"})
	@Test(priority=1)
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
	
	@Test(dependsOnMethods={"FreshInstallTest"})
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
	
	
	
	@Test(dependsOnMethods={"TutorialInstigates"})
	public void DailyBonusPresent() throws FindFailed, APIException, IOException {
		String testRailTitle = "Daily Bonus is present in build, opening upon load (if in a ready status) and functions as expected";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		//preconditions
		AdminOperations.setExclusionGroup("chrome",  FacebookOperations.userFacebookId, 1); 
		BrowserOperations.refreshPage(true);
		Screen s = new Screen();
		s.wait(35.0);
		//end preconditions
		
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
	
	
	@Test(dependsOnMethods={"DailyBonusPresent"})
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
	
	@Test(dependsOnMethods={"CollectHourlyBonus"})
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
			
			//postconditions
			BrowserOperations.refreshPage(true);
			Screen s = new Screen();
			s.wait(35.0);
			//end postconditions
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
			//postconditions
			BrowserOperations.refreshPage(true);
			Screen s = new Screen();
			s.wait(35.0);
			//end postconditions
		}
	}
	
	@Test(dependsOnMethods={"HelpFanPageOpen"})
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
	
	@Test(dependsOnMethods={"PlacedInLobby"})
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
	
	@Test(dependsOnMethods={"BuyAllCoinPackages"})
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
	
	@Test(dependsOnMethods={"QuickBuyFunctional"})
	public void EnabledCRMsAppear() throws FindFailed, APIException, IOException {
		String testRailTitle = "CRM's that are enabled appear and function as expected";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		//preconditions
		AdminOperations.setExclusionGroup("chrome",  FacebookOperations.userFacebookId, 0);
		String GaId = AdminOperations.getGAID("chrome", FacebookOperations.userFacebookId);
		System.out.println("GaId = "+GaId);
		AdminOperations.addGAIDToCRM("chrome", GaId);
		Screen s = new Screen();
		s.wait(2.0);
		BrowserOperations.refreshPage(true);
		s.wait(35.0);
		//end preconditions
		
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
			//postconditions
			AdminOperations.removeGAIDFromCRM("chrome", GaId);
			s.wait(5.0);
			AdminOperations.setExclusionGroup("chrome",  FacebookOperations.userFacebookId, 1);
			s.wait(5.0);
			BrowserOperations.refreshPage(true);
			s.wait(35.0);
			//end postconditions
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
			//postconditions
			AdminOperations.removeGAIDFromCRM("chrome", GaId);
			s.wait(5.0);
			AdminOperations.setExclusionGroup("chrome",  FacebookOperations.userFacebookId, 1);
			s.wait(5.0);
			BrowserOperations.refreshPage(true);
			s.wait(35.0);
			//end postconditions
		}
	}
	
	
	
	
	
	
	
	@Test(dependsOnMethods={"EnabledCRMsAppear"})
	public void SlotMachinesPresent() throws FindFailed, IOException, APIException {
		String testRailTitle = "All slot machines are present, with their relevant graphics and Toppers (E.G Jackpot, hot new game etc...)";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";

		int ngLoaded = 0;
		int ganLoaded = 0;
		int gdkLoaded = 0;
		int errLoaded = 0;
		try
		{
			if ((LobbyOperations.isNextSlotComingSoon()) || (LobbyOperations.isNextSlotEarlyAccess()))
			{				
				LobbyOperations.skipNextEarlyAccessAndComingSoonSlots();
				LobbyOperations.clickNextSlot();
				LobbyOperations.clickCloseGameInfoPopup();
			}
			LobbyOperations.saveCentralSlotRegion();
		}
		catch (FindFailed e)
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
	
	
	@Parameters({"browser"})
	@BeforeSuite		
	public void beforeSuite( String browser) {
		
		try {
			final Screen screen= new Screen();	
			CommonOperations.fillFieldsFromConfigFile("config.json");
			BrowserOperations.openBrowser(browser);
			screen.wait(5.0);	
			FacebookOperations.loginFacebook(browser, CommonOperations.fbLogin, CommonOperations.fbPassword);
			screen.wait(3.0);	
			FacebookOperations.createTestUser();
			screen.wait(3.0);
			FacebookOperations.loginTestUser(FacebookOperations.userLogin.toString());
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
			FacebookOperations.deleteTestUser(FacebookOperations.userFacebookId);
			FacebookOperations.deleteTestUser(FacebookOperations.friendFbUserNonInstalledDetails[0]);
			FacebookOperations.deleteTestUser(FacebookOperations.friendFbUserInstalledDetails[0][0]);
			FacebookOperations.deleteTestUser(FacebookOperations.friendFbUserInstalledDetails[1][0]);
			BrowserOperations.closeBrowser(CommonOperations.currentBrowser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
