package test;

import org.sikuli.script.*;

public class Youtube {

public static void main(String[] args) throws FindFailed, InterruptedException {
 // TODO Auto-generated method stub
Screen s= new Screen();
String[] browsers = {"chrome", "firefox", "iexplore"};

for (String i: browsers) {
	
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
}
