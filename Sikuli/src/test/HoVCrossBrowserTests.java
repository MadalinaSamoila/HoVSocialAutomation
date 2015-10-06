package test;

import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.gurock.testrail.APIException;

public class HoVCrossBrowserTests 
{
	Screen s = new Screen();
	
	public void RefreshDuringTutorial() throws APIException, IOException
	{
		String testRailTitle = "Refreshing the app having not engaged in the tutorial, will place the user into it upon a second return";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		try
		{
			testRailComment += LobbyOperations.isTimeBonusTutorialStepPresent()+" \n";
			BrowserOperations.refreshPage(true);
			s.wait(Double.parseDouble(CommonOperations.hov_load_time));
			testRailComment += LobbyOperations.isTimeBonusTutorialStepPresent()+" \n";
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
			
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		
		}
	}
	
	
	//INCLUDES DailyWheelOnlyInside
	public void DailyWheelNoDefects() throws APIException, IOException
	{
		String testRailTitle = "No spelling / grammatical / graphical defects with the daily bonus wheel popup";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		try
		{
			String GAID = AdminOperations.getGAID("chrome", FacebookOperations.userFacebookId);									
			AdminOperations.storeOrCompareUserBalance("store", GAID);
			testRailComment += LobbyOperations.isDailyWheelPresent()+" \n";
			DailyWheelOnlyInside(GAID);
			
			testRailComment += LobbyOperations.clickDailyWheelSpin()+" \n";
			testRailComment += LobbyOperations.isDailyWheelCloseDisabledPresent()+" \n";
			if (LobbyOperations.isDailyWheelSharePresent())
			{
				System.out.println("[testprogress] Daily Wheel Share is ticked - DISABLING SHARE - OK");
				testRailComment += "[testprogress] Daily Wheel Share is ticked - DISABLING SHARE - OK \n";	
				testRailComment += LobbyOperations.untickDailyWheelShare();	
			}
			testRailComment += LobbyOperations.clickDailyWheelCollect()+" \n";
			if (AdminOperations.storeOrCompareUserBalance("compare", GAID) > 0)
			{
				testRailComment += "[testres] Balance Was Changed After Daily Wheel Spin - OK" + "\n";
				System.out.println("[testres] Balance Was Changed After Daily Wheel Spin - OK");
				TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
			}
			else
			{
				testRailComment += "[testres] Balance Was Not Changed After Daily Wheel Spin - FAILED" + "\n";
				System.out.println("[testres] Balance Was Not Changed After Daily Wheel Spin - FAILED");
				TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
			
			}
			
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		
		}
	}
	
	public void DailyWheelOnlyInside(String GAID) throws APIException, IOException
	{
		String testRailTitle = "The bonus wheel can only be spun by clicking inside of the wheel";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		try
		{
			AdminOperations.storeOrCompareUserBalance("store", GAID);
			testRailComment += LobbyOperations.clicksOutsideDailyWheel();
			s.type(Key.SPACE);
			testRailComment += "Space Button Was Pressed";
			if (AdminOperations.storeOrCompareUserBalance("compare", GAID) == 0)
			{
				testRailComment += "[testres] Balance Was Not Changed After Daily Wheel Outside Clicks - OK" + "\n";
				System.out.println("[testres] Balance Was Not Changed After Daily Wheel Outside Clicks - OK");
				TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
			}
			else
			{
				testRailComment += "[testres] Balance Was Changed After Daily Wheel Outside Clicks - FAILED" + "\n";
				System.out.println("[testres] Balance Was Changed After Daily Wheel Outside Clicks - FAILED");
				TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
			
			}
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		
		}
	}
	
	public void TopBarAllExpectedElements(boolean isSocial) throws APIException, IOException //BALANCE == 2.030.000; level = 1; xp = 0 | Launch after adding user to the ExclusionGroup == 1
	{
		String testRailTitle = "All expected fields are displayed within the Top Bar without graphical defects";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		
		try
		{
			LobbyOperations.closeShopInviteBoxGiftBoxPopup();
			LobbyOperations.clickCloseButtonCRM();
		}
		catch (FindFailed e)
		{
			
		}
		
		try
		{
			testRailComment += LobbyOperations.balanceFieldIsPresent() + "\n";
			testRailComment += LobbyOperations.shopButtonsArePresent()+ "\n";
			testRailComment += LobbyOperations.levelBarIsPresent()+ "\n";
			testRailComment += LobbyOperations.isTimeBonusEnabled()+ "\n";
			testRailComment += LobbyOperations.loyaltyButtonIsPresent()+ "\n";
			if (isSocial)
			{
				testRailComment += LobbyOperations.giftButtonIsPresent()+ "\n";
			}
			testRailComment += LobbyOperations.isLobbyReturned(0)+ "\n";
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
		
	}
	
	public void ShopUnderVariousResolutions(boolean isLoyaltyEnabled, int[] modes) throws APIException, IOException
	{
		String testRailTitle = "All expected fields are displayed within the Top Bar without graphical defects";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		
		try
		{
			testRailComment += LobbyOperations.isBuyButtonPresentAndClick();
			for (int x : modes)
			{
				testRailComment += CommonOperations.setDisplayResolutionMode(x, false);
				testRailComment += LobbyOperations.isShopOpened(isLoyaltyEnabled);
				testRailComment += CommonOperations.setDisplayResolutionMode(x, true);
			}
			testRailComment += LobbyOperations.closeShopInviteBoxGiftBoxPopup();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		
		}
	}
	
	public void ShopReturnsToLobby(boolean isLoyaltyEnabled) throws APIException, IOException
	{
		String testRailTitle = "User can close the shop via a relevant close button";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		
		try
		{
			testRailComment += LobbyOperations.isBuyButtonPresentAndClick() + "\n";
			testRailComment += LobbyOperations.isShopOpened(isLoyaltyEnabled) + "\n";
			testRailComment += LobbyOperations.closeShopInviteBoxGiftBoxPopup() + "\n";
			testRailComment += LobbyOperations.isLobbyReturned(0) + "\n";
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);	
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			
     		TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		
		}
	}
	
	public void ShopCongratulationsPopup() throws APIException, IOException //initial balance = 2.030.000; After purchase 9.000.000 (30$)+ upsale
	{
		String testRailTitle = "Congratulation pop-up appears after closing the Upsale Wheel pop-up and is free of spelling / graphical defects";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		
		try
		{
			testRailComment += LobbyOperations.shopCongratulationPopupPresent() + "\n";
			
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);	
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			
     		TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
		
	}
}
