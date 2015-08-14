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
	
	}
	
	@Test
	public void PlacedInLobby() {
		
	}
	
	@Test 
	public void DailyBonusPresent() {
		
	}
	
	@Test
	public void EnabledCRMsAppear() {
		
	}
	
	@Test
	public void HelpFanPageOpen() {
		
	}
	
	@Test
	public void BuyAllCoinPackages() {
		
		if (LobbyOperations.isBuyButtonPresentAndClick())
		{
			System.out.println("[testprogress] Lobby Buy Button is Present and Clicked - OK");
			
			if (LobbyOperations.isShopOpened())
			{
				
				
				System.out.println("[testprogress] Shop Opened - OK");
				
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
			}
			else
			{
				System.out.println("[teststat] Shop Popup is Absent - FAILED");
			}
		}
		else
		{
			System.out.println("[testprogress] Lobby Buy Button is Absent - UNABLE_TO_CONTINUE");
		}
	}
	
	@Test
	public void QuickBuyFunctional() {
		
	}
	
	@Test
	public void CollectHourlyBonus() {
		
		if (LobbyOperations.isTimeBonusEnabled())
		{
			System.out.println("[testprogress] Time Bonus Enabled - OK");
			
			if (LobbyOperations.clickCollect())
			{
				System.out.println("[testprogress] Time Bonus Clicked - OK");
				
				if (LobbyOperations.isCollected())
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
