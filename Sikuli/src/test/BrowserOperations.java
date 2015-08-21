package test;

import org.sikuli.script.*;



enum Browsers {
	chrome(CommonOperations.chromePath), firefox(CommonOperations.firefoxPath), iexplore(CommonOperations.iexplorePath);
		
	private String browserAddress;
	
	Browsers(String address) {
		browserAddress = address;
	}
	
	public String getBrowserAddress() {
		return this.browserAddress;
	}
}

public class BrowserOperations {
	public static App browser;
	static Screen screen= new Screen();
	private static String browserName;
	
	
	
	public static void openBrowser(String name) {
		App.open(Browsers.valueOf(name).getBrowserAddress());
		//browser = new App(Browsers.valueOf(name).getBrowserAddress()).open();
		browserName = name;
		
	}

	public static void closeBrowser(String name) {
		browser.close();
		
	}
	
	public static void openNewTab (/*String name*/) {
		//try {
			//screen.click("browser/"+name+"_new_tab.png");
			screen.keyDown(Key.CTRL);
			screen.keyDown("t");
			screen.keyUp(Key.CTRL);
			screen.keyUp("t");
		//} catch (FindFailed e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
	}
	
	public static void clickSearch (/*String name*/) {
		/*try {
			screen.click("browser/"+name+"_search.png");
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		screen.keyDown(Key.CTRL);
		screen.keyDown("l");
		screen.keyUp(Key.CTRL);
		screen.keyUp("l");
	}
	
	public static void closeTab (/*String name*/) {
		/*try {
			screen.click("browser/"+name+"_close_tab.png");
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		screen.keyDown(Key.CTRL);
		screen.keyDown("w");
		screen.keyUp(Key.CTRL);
		screen.keyUp("w");
	}
	public static void refreshPage (boolean isFromFB) throws FindFailed {
		/*try {
			screen.click("browser/"+name+"_close_tab.png");
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if (isFromFB)
		{
			screen.click("browser//facebook_top.png");
		}
		screen.keyDown(Key.CTRL);
		screen.keyDown("r");
		screen.keyUp(Key.CTRL);
		screen.keyUp("r");
	}
	
	public static String getBrowserName()
	{
		return browserName;
	}
	
}
