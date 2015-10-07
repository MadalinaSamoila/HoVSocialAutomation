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
	
	public void QuickBuyDuringShopDisabled() throws APIException, IOException
	{
		String testRailTitle = "The user is unable to open the shop at the same time as making use of the quick buy drop down";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		
		try
		{
			testRailComment += LobbyOperations.isBuyButtonPresentAndClick() + "\n";
			testRailComment += LobbyOperations.quickBuyBuyBlurredClick() + "\n";
			try
			{
				testRailComment += LobbyOperations.isQuickBuyDropDownPresent()+ " - NOT OK - FAILED\n";
				TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
			}
			catch (FindFailed e)
			{
				testRailComment += e.getMessage() + "OK \n";
				testRailComment += LobbyOperations.closeShopInviteBoxGiftBoxPopup() + "\n";
				TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
			}
			
				
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			
     		TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
	}
	
	public void BalanceTenBln() throws APIException, IOException
	{
		String testRailTitle = "There is sufficient space within the Top Bar to display 10 billion coins";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		
		try
		{
			String GAID = AdminOperations.getGAID("chrome", FacebookOperations.userFacebookId);	
			double previousBalance = AdminOperations.getUserBalance("chrome", GAID);
			AdminOperations.resetUserBalance("chrome", GAID, 10000000000.0);
			BrowserOperations.refreshPage(true);
			s.wait(35.5);
			testRailComment += LobbyOperations.balanceFieldTenBln() + "\n";
			AdminOperations.resetUserBalance("chrome", GAID, previousBalance);
			BrowserOperations.refreshPage(true);
			s.wait(35.5);
			TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
			
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			
     		TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
	}
	
	public void TimeBonusOutsideLobby() throws APIException, IOException
	{
		String testRailTitle = "There is sufficient space within the Top Bar to display 10 billion coins";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		
		try
		{
			String GAID = AdminOperations.getGAID("chrome", FacebookOperations.userFacebookId);									
			AdminOperations.storeOrCompareUserBalance("store", GAID);
			
			testRailComment += LobbyOperations.isTimeBonusEnabled() + "\n";
			
			
			if ((LobbyOperations.isNextSlotComingSoon()) || (LobbyOperations.isNextSlotEarlyAccess()))
			{				
				LobbyOperations.skipNextEarlyAccessAndComingSoonSlots();
			}
			else
			{
				testRailComment += LobbyOperations.clickNextSlot() + "\n";
				
				testRailComment += LobbyOperations.clickCabinetPlayButton() + "\n";
				
				testRailComment += LobbyOperations.isTimeBonusDisabledAndClick(true) + "\n";
				
				testRailComment += LobbyOperations.isTimeBonusDisabledTooltipPresent() + "\n";
				
				if (AdminOperations.storeOrCompareUserBalance("compare", GAID) > 0)
				{
					testRailComment += "[testres] Balance Was Changed After Click On Disabled Time Bonus - FAILED" + "\n";
					System.out.println("[testres] Balance Was Changed After Click On Disabled Time Bonus - FAILED");
					TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
				}
				else
				{
					testRailComment += "[testres] Balance Was Not Changed After Click On Disabled Time Bonus - OK" + "\n";
					System.out.println("[testres] Balance Was Not Changed After Click On Disabled Time Bonus - OK");
					TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
				
				}
				LobbyOperations.returnToLobby();
			}
			
		
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			
     		TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
	}
	
	
	public void LobbyBlurs() throws APIException, IOException
	{
		String testRailTitle = "Lobby blurs when user loses app focus, and returns to normal state when user regains app focus";
		String testRailTestId = TestRailOperations.getTestIdByTitleInRun(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,  CommonOperations.getRunIdByBrowser(),  testRailTitle);
		String testRailComment = "";
		boolean isChecked = false;
		try
		{	
			if (FacebookOperations.clickFbSearch())
			{
				s.wait(1.5);
				testRailComment += "[testprogress] FB Search Clicked \n";
				testRailComment += LobbyOperations.lobbyBlurred() + "\n";
				isChecked = true;
				FacebookOperations.clickFbSearch();
			}
			
			if (FacebookOperations.clickFriendButton())
			{
				s.wait(1.5);
				testRailComment += "[testprogress] FB Friends Button Clicked \n";
				testRailComment += LobbyOperations.lobbyBlurred() + "\n";
				isChecked = true;
				FacebookOperations.clickFriendButton();
			}
			
			if (FacebookOperations.clickMailButton())
			{
				s.wait(1.5);
				testRailComment += "[testprogress] FB Mail Button Clicked \n";
				testRailComment += LobbyOperations.lobbyBlurred() + "\n";
				isChecked = true;
				FacebookOperations.clickMailButton();
			}
			
			if (FacebookOperations.clickNotificationButton())
			{
				s.wait(1.5);
				testRailComment += "[testprogress] FB Mail Button Clicked \n";
				testRailComment += LobbyOperations.lobbyBlurred() + "\n";
				isChecked = true;
				FacebookOperations.clickNotificationButton();
			}
			
			if (FacebookOperations.clickPrivacyButton())
			{
				s.wait(1.5);
				testRailComment += "[testprogress] FB Mail Button Clicked \n";
				testRailComment += LobbyOperations.lobbyBlurred() + "\n";
				isChecked = true;
				FacebookOperations.clickPrivacyButton();
			}
			
			if (isChecked)
			{
				TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 1, testRailComment);
			}
			else
			{
				testRailComment += "[testres] The App Was Unable To Click FB Buttons - Please Retest \n";
				TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 4, testRailComment);
			}
			
		}
		catch (FindFailed e)
		{
			testRailComment += e.getMessage();
			
     		TestRailOperations.setResultToTest(CommonOperations.testRailHostAdress,  CommonOperations.testRailLogin,  CommonOperations.testRailPassword,testRailTestId, 5, testRailComment);
		}
	}
}
