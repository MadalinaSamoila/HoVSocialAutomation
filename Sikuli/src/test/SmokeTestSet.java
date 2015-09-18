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
				AdminOperations.currentGAID = null;
				String i = "chrome";
				CommonOperations.currentBrowser = i;
				try 
				{
					
					smoke.SlotMachinesPresent();
					
					
					String GAID = "6244689";
				/*	
					AdminOperations.storeOrCompareUserBalance("store", GAID);
					
					//SlotOperations.clickAutospinActivate();
					s.wait(5.1);
				//	SlotOperations.clickAutospinDeactivate();
					//screen.wait(5.1);
					if (!AdminOperations.storeOrCompareUserBalance("compare", GAID))
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