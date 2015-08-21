package test;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.sikuli.script.*;

import com.gurock.testrail.APIException;

public class Youtube {

	public static void main(String[] args) throws FindFailed, InterruptedException, APIException, IOException, ParseException 
	{
 // TODO Auto-generated method stub
	Screen s= new Screen();
	String[] browsers = {"chrome", "firefox", "iexplore"};
////////////////////////
/*for (String i: browsers) {
	https://developers.facebook.com/apps/600712740047839/payments/
		
	try {
		FacebookOperations.createTestUser();
		
		BrowserOperations.openBrowser(i);
		s.wait(1.5);

		BrowserOperations.clickSearch(i);
		FacebookOperations.loginTestUser();
//		s.click("browser//login_confirmation.png");
		FacebookOperations.deleteTestUser();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
////////////////////////////

HoVSmokeTests smoke = new HoVSmokeTests();
//smoke.TutorialInstigates();
	String i = browsers[0];
	
	String pathToFile = "config.json";  //replace "C:/config.json" with args[0] before export to jar
	if (CommonOperations.areFieldsPresentInConfigurationFile(pathToFile).equals("ok") && (CommonOperations.fillFieldsFromConfigFile(pathToFile))) 
	{
		try 
		{
			
			BrowserOperations.openBrowser(i);
			s.wait(5.0);				
			FacebookOperations.loginFacebook(i);
			s.wait(5.0);	
			FacebookOperations.createTestUser();
			s.wait(5.0);
			FacebookOperations.loginTestUser();
			s.wait(5.0);						 // OK
			FacebookOperations.changeLanguageFacebook(i);
			s.wait(5.0);
			//FacebookOperations.userFacebookId = "106154683071929";
			
			//On Alex's PC russian language sets as default for test user, need to investigate
			smoke.FreshInstallTest(i);
			//s.wait(60.0); 					//retest
			
			smoke.TutorialInstigates();
			s.wait(5.0);
			
			AdminOperations.setExclusionGroup(i,  FacebookOperations.userFacebookId, 1); // NOT TESTED
			
			
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
			
			//FacebookOperations.userFacebookId = "115326662150130"; //DEBUG
			AdminOperations.setExclusionGroup(i,  FacebookOperations.userFacebookId, 0); // NOT TESTED
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
			AdminOperations.setExclusionGroup(i,  FacebookOperations.userFacebookId, 1); // NOT TESTED
			s.wait(5.0);
			
			smoke.SlotMachinesPresent();
			
			FacebookOperations.deleteTestUser();
			
		} 
		catch (Exception e) 
		{			
			e.printStackTrace();
		}
	}
	else
	{
		System.out.println(CommonOperations.areFieldsPresentInConfigurationFile(pathToFile)); 
	}
	


	/*BrowserOperations.openBrowser(i);
	s.wait(1.5);
	
	
	BrowserOperations.clickSearch(i);
	AdminOperations.resetDailyWheel(i);
	
	BrowserOperations.openNewTab(i);
	BrowserOperations.clickSearch(i);
	s.paste("https://apps.facebook.com/hov_uat/?fb_source=bookmark&ref=bookmarks&count=0&fb_bmpos=_0");
	s.type(Key.ENTER);
	s.wait(12.5);
	

	if (s.find("lobby//daily_wheel_exists.png") != null) {
		s.click("lobby//wheel_click_to_spin.png");
		s.wait(7.5);
		s.click("lobby//share_button.png");
		s.click("lobby//daily_wheel_collect.png");
	}
	BrowserOperations.closeBrowser(i);*/
	}
 
}