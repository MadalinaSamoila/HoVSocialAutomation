package test;

import org.sikuli.script.*;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;



enum Browsers {
	chrome(System.getenv("CHROME_ADDRESS")), firefox(System.getenv("FIREFOX_ADDRESS")), iexplore(System.getenv("IEXPLORE_ADDRESS"));
		
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
		browser = new App(Browsers.valueOf(name).getBrowserAddress()).open();
		browserName = name;
		
	}

	public static void closeBrowser(String name) {
		browser.close();
		
	}
	
	public static void openNewTab (String name) {
		try {
			screen.click("browser/"+name+"_new_tab.png");
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void clickSearch (String name) {
		try {
			screen.click("browser/"+name+"_search.png");
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeTab (String name) {
		try {
			screen.click("browser/"+name+"_close_tab.png");
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getBrowserName()
	{
		return browserName;
	}
	
}
