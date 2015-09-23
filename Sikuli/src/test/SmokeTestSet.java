package test;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.sikuli.script.*;

import com.gurock.testrail.APIException;

public class SmokeTestSet {

	public static void main(String[] args) throws FindFailed, InterruptedException, APIException, IOException, ParseException 
	{
		Screen s= new Screen();
		String[] browsers = {"chrome", "firefox", "iexplore"};
		
		HoVSmokeTests smoke = new HoVSmokeTests();	
		String pathToFile = "config.json";  //replace "config.json" with args[0] before export to jar
		System.out.println("Welcome! \nPlease, make sure that there are no logged in users into Facebook under all browsers. Otherwise, log out and restart the test. \nAlso, make sure that you have a correct configuration file.\nWarning: before running test on Microsoft Edge Browser, all windows will me minimized! \nGood luck :)");
		
		if ((CommonOperations.fillFieldsFromConfigFile(pathToFile))) 
		{
			//for (String i: browsers) 
			//{
				AdminOperations.currentGAID = null;//do not delete, especially after merging
				String i = "chrome";
				CommonOperations.currentBrowser = i;
				try 
				{
					
					BrowserOperations.openBrowser(i);
					s.wait(5.0);				
					FacebookOperations.loginFacebook(i, CommonOperations.fbLogin, CommonOperations.fbPassword);
					s.wait(5.0);	
					FacebookOperations.createTestUser();
					s.wait(5.0);
					FacebookOperations.loginTestUser(FacebookOperations.userLogin.toString());
					s.wait(5.0);				
					FacebookOperations.changeLanguageFacebook(i);
					s.wait(5.0);
					FacebookOperations.makeUsersFriendsWithoutToken("chrome", FacebookOperations.userFacebookPageLink, FacebookOperations.createFriendTestUser(false)[1]);
					smoke.FreshInstallTest(i);
					s.wait(5.0);
					FacebookOperations.makeUsersFriends(FacebookOperations.userFacebookId, FacebookOperations.createFriendTestUser(true)[0]);
					FacebookOperations.initiateTestUserAccount(FacebookOperations.friendFbUserInstalledDetails[0][2], FacebookOperations.friendFbUserInstalledDetails[0][3], i, true);
					s.wait(5.0);
					FacebookOperations.makeUsersFriends(FacebookOperations.userFacebookId, FacebookOperations.createFriendTestUser(true)[0]);
					FacebookOperations.initiateTestUserAccount(FacebookOperations.friendFbUserInstalledDetails[1][2], FacebookOperations.friendFbUserInstalledDetails[1][3], i, true);
					
					smoke.TutorialInstigates();					
					
					AdminOperations.setExclusionGroup(i,  FacebookOperations.userFacebookId, 1); 
					
					BrowserOperations.refreshPage(true);
					s.wait(35.0);
					
					smoke.DailyBonusPresent();
					s.wait(5.0);
					
					smoke.CollectHourlyBonus();
					
					smoke.HelpFanPageOpen();
					BrowserOperations.refreshPage(true);
					s.wait(35.0);
					
					smoke.PlacedInLobby();
					s.wait(5.0);
								
					smoke.BuyAllCoinPackages();
					s.wait(5.0);
					
					smoke.QuickBuyFunctional();
					s.wait(5.0);
					
					smoke.IngameEventsPresent(new String[]{"cabinet_clicked", "catalogue_open", "lobby_ready", "catalogue_open", "coin_package_clicked", "coins_received", "payment_complete"});
					s.wait(5.0);
					
					smoke.LeaderboardDisplaysButtons();
					s.wait(5.0);
					//FacebookOperations.userFacebookId = "100005189688884";
					AdminOperations.setExclusionGroup(i,  FacebookOperations.userFacebookId, 0);
					String GaId = AdminOperations.getGAID(i, FacebookOperations.userFacebookId);
					System.out.println("GaId = "+GaId);
					AdminOperations.addGAIDToCRM(i, GaId);
					s.wait(2.0);
					BrowserOperations.refreshPage(true);
					s.wait(35.0);
					smoke.EnabledCRMsAppear();
					s.wait(5.0);
					AdminOperations.removeGAIDFromCRM(i, GaId);
					s.wait(5.0);
					AdminOperations.setExclusionGroup(i,  FacebookOperations.userFacebookId, 1);
					s.wait(5.0);
					BrowserOperations.refreshPage(true);
					s.wait(35.0);
					smoke.SlotMachinesPresent();
					
					
					
					FacebookOperations.deleteTestUser(FacebookOperations.userFacebookId);
					FacebookOperations.deleteTestUser(FacebookOperations.friendFbUserNonInstalledDetails[0]);
					FacebookOperations.deleteTestUser(FacebookOperations.friendFbUserInstalledDetails[0][0]);
					FacebookOperations.deleteTestUser(FacebookOperations.friendFbUserInstalledDetails[1][0]);
					
					BrowserOperations.closeBrowser(i);
				
					
					
					//BELOW FOR TESTING
					//smoke.GiftSendingCheck();
					
					//System.out.println(FacebookOperations.friendFbUserInstalledDetails[0][0].length());
					/*
					FacebookOperations.createFriendTestUser(true);
					FacebookOperations.createFriendTestUser(true);
					
					for (String k : FacebookOperations.friendFbUserInstalledDetails[0])
					{
						System.out.println(k+"\n");
					}
					for (String k : FacebookOperations.friendFbUserInstalledDetails[1])
					{
						System.out.println(k+"\n");
					}
					
					*/
					
					
					/*BrowserOperations.clickSearch();
					s.keyDown(Key.CTRL);
					s.keyDown("c");
					s.keyUp(Key.CTRL);
					s.keyUp("c");*/ 
					
					
					//FacebookOperations.makeUsersFriendsWithoutToken("chrome", Env.getClipboard(), "https://developers.facebook.com/checkpoint/test-user-login/142701756077717/");
					
					
					
					/*
					for (String k : FacebookOperations.createFriendTestUser(false))
					{
						System.out.println(k+"\n");
					}
					
					for (String k : FacebookOperations.createFriendTestUser(true))
					{
						System.out.println(k+"\n");
					}
					*/
					
					
					//FacebookOperations.userFacebookId = "100005189688884";
					//FacebookOperations.userFacebookId = "577845726";
					//smoke.IngameEventsPresent(new String[]{"big_win", "cabinet_clicked", "catalogue_open"});
					//smoke.SlotMachinesPresent();
					
					//FacebookOperations.makeUsersFriends("130904730594868", "123111368043995");
					//System.out.println(res);
					/*String[] array = {"big_win", "cabinet_clicked", "catalogue_open"};
					String res = AdminOperations.checkIngameEvents("Chrome",array, "577845726");
					System.out.println(res);*/
					//smoke.CheckBalanceAdditionsAndSubtractions();
					
					
					/*SlotOperations.performLoosingSpinGDK();
					SlotOperations.performWininngSpinGDK();*/
					
					
					/*String GAID = "6244689";
				
					AdminOperations.storeOrCompareUserBalance("store", GAID);
					
					SlotOperations.clickAutospinActivate();
					s.wait(5.1);
					SlotOperations.clickAutospinDeactivate();
					//screen.wait(5.1);
					if (AdminOperations.storeOrCompareUserBalance("compare", GAID) != 0)
					{
						System.out.println("[testprogress] Balance Was Changed After Deactivating Autospin - OK");
						//testRailComment += ("[testprogress] Balance Was Changed After Deactivating Autospin - OK");
					}
					else
					{
						System.out.println("[testprogress] Balance Was Not Changed After Deactivating Autospin - FAILED");
						//testRailComment += ("[testprogress] Balance Was Not Changed After Deactivating Autospin - FAILED");
//						TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
					}
					
					*/
					
					
					/*SlotOperations.storeOrCompareRegion("bet", "store");
					System.out.println("pause 5 sec");
					s.wait(5.0);
					if (SlotOperations.storeOrCompareRegion("bet", "compare"))
					{
						System.out.println("SAME");
					}
					else
					{
						System.out.println("NOT_SAME");
					}
					*/
					/*
					if (SlotOperations.isDeraseBetButtonEnabled())
					{
						SlotOperations.clickDecraseBetButton();
					}
					else
					{
						if (SlotOperations.isIncraseBetButtonEnabled())
						{
							SlotOperations.clickDecraseBetButton();
						}
					}
					
					*/
					
					//ABOVE FOR TESTING
				/*		BrowserOperations.openBrowser(i);
					s.wait(5.0);				
					FacebookOperations.loginFacebook(i);
					s.wait(5.0);	
					FacebookOperations.createTestUser();
					s.wait(5.0);
					FacebookOperations.loginTestUser();
					s.wait(5.0);				
					FacebookOperations.changeLanguageFacebook(i);
					s.wait(5.0);
					
					
					smoke.FreshInstallTest(i);
					s.wait(5.0);
					
					smoke.TutorialInstigates();
					s.wait(5.0);
					
					//FacebookOperations.userFacebookId = "100005189688884";
					AdminOperations.setExclusionGroup(i,  FacebookOperations.userFacebookId, 1); 
								
					BrowserOperations.refreshPage(true);
					s.wait(35.0);
					
					smoke.DailyBonusPresent();
					s.wait(5.0);
					
					smoke.CollectHourlyBonus();
					
					smoke.HelpFanPageOpen();
					BrowserOperations.refreshPage(true);
					s.wait(35.0);
					
					smoke.PlacedInLobby();
					s.wait(5.0);
								
					smoke.BuyAllCoinPackages();
					s.wait(5.0);
					
					smoke.QuickBuyFunctional();
					s.wait(5.0);
					
					//FacebookOperations.userFacebookId = "100005189688884";
					AdminOperations.setExclusionGroup(i,  FacebookOperations.userFacebookId, 0);
					String GaId = AdminOperations.getGAID(i, FacebookOperations.userFacebookId);
					System.out.println("GaId = "+GaId);
					AdminOperations.addGAIDToCRM(i, GaId);
					s.wait(2.0);
					BrowserOperations.refreshPage(true);
					s.wait(35.0);
					smoke.EnabledCRMsAppear();
					s.wait(5.0);
					AdminOperations.removeGAIDFromCRM(i, GaId);
					s.wait(5.0);
					AdminOperations.setExclusionGroup(i,  FacebookOperations.userFacebookId, 1);
					s.wait(5.0);
					BrowserOperations.refreshPage(true);
					s.wait(35.0);
					smoke.SlotMachinesPresent();
					
					FacebookOperations.deleteTestUser();
					
					BrowserOperations.closeBrowser(i);
					*/
				} 
				catch (Exception e) 
				{			
					e.printStackTrace();
				}
		//	}
		}
		else
		{
			System.out.println("There was an error during loading configurations file"); 
		}
	
	}
 
}