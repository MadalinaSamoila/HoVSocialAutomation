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
		
	}
	
	@Test
	public void QuickBuyFunctional() {
		
	}
	
	@Test
	public void CollectHourlyBonus() {
		
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
