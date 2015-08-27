package test;

import org.sikuli.script.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.*;


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
	private static Screen screen= new Screen();
	private static String browserName;
	private static WebDriver driver;
	
	
	public static void openBrowser(String name) {
		if (name.equals("edge"))
		{
			screen.keyDown(Key.WIN);
			screen.keyDown("d");
			screen.keyUp(Key.WIN);
			screen.keyUp("d");
		
			System.setProperty("webdriver.edge.driver", "lib\\webdriver\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			
			screen.wait(5.2);
			screen.keyDown(Key.WIN);
			screen.keyDown(Key.UP);
			screen.keyUp(Key.WIN);
			screen.keyUp(Key.UP);
			try 
			{
				screen.click("browser/"+name+"_search.png");
			} 
			catch (FindFailed e) 
			{
				e.printStackTrace();
			}						
		}
		else
		{
			App.open(Browsers.valueOf(name).getBrowserAddress());
		}
		browserName = name;
		
	}

	public static void closeBrowser(String name) 
	{
		if (name.equals("edge"))
		{
			driver.close();
		}
		else
		{
			browser.close();
		}
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
	public static void refreshPage (boolean isFromFB) {
		/*try {
			screen.click("browser/"+name+"_close_tab.png");
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try
		{
			if (isFromFB)
			{
				screen.click("browser//facebook_top.png");
			}
			screen.keyDown(Key.CTRL);
			screen.keyDown("r");
			screen.keyUp(Key.CTRL);
			screen.keyUp("r");
		}
		catch (FindFailed e)
		{
			screen.keyDown(Key.CTRL);
			screen.keyDown("r");
			screen.keyUp(Key.CTRL);
			screen.keyUp("r");
		}
		
	}
	
	public static String getBrowserName()
	{
		return browserName;
	}
	
}
