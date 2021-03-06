package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.Keys;
import org.sikuli.script.*;

public class AdminOperations {
	
	static double balance;
	static Screen s = new Screen();
	static String selectAll = Keys.chord(Keys.CONTROL,"a");
	static String currentGAID;
	
	public static void resetDailyWheel (String browser, String GAID) {
		
		WebDriver driver;
		
		System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "lib\\webdriver\\MicrosoftWebDriver.exe");
		
		switch(browser) {
		case "chrome": 	driver = new ChromeDriver();
						break;
		case "firefox": driver = new FirefoxDriver();
						break;
		case "iexplore":driver = new InternetExplorerDriver();
						break;
		case "edge":	driver = new EdgeDriver();
						break;		
		default:		driver = new ChromeDriver();
						break;
		}
		
		driver.get("http://hov-uat-aio01.productmadness.com/admin/game_accounts/"+GAID+"#summary");
		if (driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")) != null) {
			s.wait(2.1);
			driver.findElement(By.id("admin_email")).sendKeys(selectAll);	
			driver.findElement(By.id("admin_email")).sendKeys(CommonOperations.fbLogin);	
			driver.findElement(By.id("admin_password")).sendKeys(selectAll);	
			driver.findElement(By.id("admin_password")).sendKeys(CommonOperations.fbPassword);
			driver.findElement(By.id("admin_password")).sendKeys(Key.ENTER);
			/*driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
			s.wait(2.1);
			if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
				
				/*driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(selectAll);		
				driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
				driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(selectAll);
				driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
				
				driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
				
				try {
					driver.wait(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}*/
			
		}
		s.wait(2.1);
		driver.findElement(By.xpath("//div[4]/div[2]/ul/li[2]/a")).click();
		
		driver.findElement(By.xpath("//div[@id='bonuses']/form/table/tbody/tr/td/input")).click();
		driver.findElement(By.xpath("//div[@id='bonuses']/form/table/tbody/tr[3]/td/input")).click();
		driver.findElement(By.xpath("//div[@id='bonuses']/form/table/tbody/tr[6]/td/input")).click();
		
		driver.findElement(By.xpath("//div[@id='bonuses']/form/div[2]/div/div[2]/button")).click();
		
		/*try {
			driver.wait(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		s.wait(7.1);
		driver.close();
		
	}
	
	public static void resetUserLevel (String browser, String GAID, int level) {
		
		WebDriver driver;
		
		System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "lib\\webdriver\\MicrosoftWebDriver.exe");
		switch(browser) {
		case "chrome": 	driver = new ChromeDriver();
						break;
		case "firefox": driver = new FirefoxDriver();
						break;
		case "iexplore":driver = new InternetExplorerDriver();
						break;
		default:		driver = new ChromeDriver();
						break;
		}
		
		driver.get("http://hov-uat-aio01.productmadness.com/admin/game_accounts/"+GAID+"#summary");
		
		if (driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")) != null) {
			s.wait(2.1);
			driver.findElement(By.id("admin_email")).sendKeys(selectAll);	
			driver.findElement(By.id("admin_email")).sendKeys(CommonOperations.fbLogin);	
			driver.findElement(By.id("admin_password")).sendKeys(selectAll);	
			driver.findElement(By.id("admin_password")).sendKeys(CommonOperations.fbPassword);
			driver.findElement(By.id("admin_password")).sendKeys(Key.ENTER);
		/*	driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
			s.wait(2.1);
			if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
				driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(selectAll);		
				driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
				driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(selectAll);
				driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
				
				driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
				
				try {
					driver.wait(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}*/
			
		}
		s.wait(2.1);
		driver.findElement(By.xpath("//div[4]/div[2]/ul/li/a")).click();
		
		driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr[3]/td[3]/form/div[3]/input")).sendKeys(new Integer(level).toString());
		
		driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr[3]/td[3]/form/div[4]/button")).click();
		
		/*try {
			driver.wait(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		s.wait(7.1);
		driver.close();
		
	}
	
	public static double storeOrCompareUserBalance (String mode, String GAID)
	{
		double res = 0;
		
		if (mode.equals("store"))
		{
			balance = AdminOperations.getUserBalance("chrome", GAID);
		}
		
		if (mode.equals("compare"))
		{
			double currentBalance = AdminOperations.getUserBalance("chrome", GAID);
			/*if (balance == currentBalance)
			{
				res = true;
				balance = currentBalance;
			}
			
			else
			{
				res = false;
				balance = currentBalance;
			}*/
			
			res = (balance - currentBalance);
			balance = currentBalance;
		}
		return res;
	}
	
	public static void resetUserBalance (String browser, String GAID, double balance) {
		
		WebDriver driver;
		
		System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "lib\\webdriver\\MicrosoftWebDriver.exe");
		
		switch(browser) {
		case "chrome": 	driver = new ChromeDriver();
						break;
		case "firefox": driver = new FirefoxDriver();
						break;
		case "iexplore":driver = new InternetExplorerDriver();
						break;
		default:		driver = new ChromeDriver();
						break;
		}
		
		driver.get("http://hov-uat-aio01.productmadness.com/admin/game_accounts/"+GAID+"#summary");
		
		if (driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")) != null) {
			s.wait(2.1);
			driver.findElement(By.id("admin_email")).sendKeys(selectAll);	
			driver.findElement(By.id("admin_email")).sendKeys(CommonOperations.fbLogin);	
			driver.findElement(By.id("admin_password")).sendKeys(selectAll);	
			driver.findElement(By.id("admin_password")).sendKeys(CommonOperations.fbPassword);
			driver.findElement(By.id("admin_password")).sendKeys(Key.ENTER);
			/*driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
			s.wait(2.1);
			if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
				driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(selectAll);		
				driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
				driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(selectAll);
				driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
				
				driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
				
				try {
					driver.wait(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}*/
			
		}
		s.wait(2.1);
		driver.findElement(By.xpath("//div[4]/div[2]/ul/li/a")).click();
		
		Select droplist  = new Select(driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr/td[3]/form/div[2]/select")));
		//droplist.selectByValue("Set to");
		droplist.selectByIndex(1);
		driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr/td[3]/form/div[3]/input")).sendKeys(String.valueOf(balance));
		
		driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr/td[3]/form/div[4]/button")).click();	
		
		/*try {
			driver.wait(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		s.wait(7.1);
		driver.close();
		
	}
	
public static double getUserBalance (String browser, String GAID) {
		
		WebDriver driver;
		
		System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "lib\\webdriver\\MicrosoftWebDriver.exe");
		
		switch(browser) {
		case "chrome": 	driver = new ChromeDriver();
						break;
		case "firefox": driver = new FirefoxDriver();
						break;
		case "iexplore":driver = new InternetExplorerDriver();
						break;
		default:		driver = new ChromeDriver();
						break;
		}
		
		driver.get("http://hov-uat-aio01.productmadness.com/admin/game_accounts/"+GAID+"#summary");

		if (driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")) != null) {
			/*
			driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
			s.wait(2.1);
			if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
				driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(selectAll);		
				driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
				driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(selectAll);
				driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
				
				driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
				
				/*try {
					driver.wait(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}*/
			s.wait(2.1);
			driver.findElement(By.id("admin_email")).sendKeys(selectAll);	
			driver.findElement(By.id("admin_email")).sendKeys(CommonOperations.fbLogin);	
			driver.findElement(By.id("admin_password")).sendKeys(selectAll);	
			driver.findElement(By.id("admin_password")).sendKeys(CommonOperations.fbPassword);
			driver.findElement(By.id("admin_password")).sendKeys(Key.ENTER);
		}
		s.wait(2.1);
		driver.findElement(By.xpath("//div[4]/div[2]/ul/li/a")).click();
		
		String balanceString = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td[2]")).getText().replace(",", "");
		double balance = Double.parseDouble(balanceString);
		s.wait(7.1);
		driver.close();
		
		return balance;
		
		
	}


public static void resetHourlyBonus (String browser, String GAID) {
	
	WebDriver driver;
	
	System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
	System.setProperty("webdriver.edge.driver", "lib\\webdriver\\MicrosoftWebDriver.exe");
	
	switch(browser) {
	case "chrome": 	driver = new ChromeDriver();
					break;
	case "firefox": driver = new FirefoxDriver();
					break;
	case "iexplore":driver = new InternetExplorerDriver();
					break;
	default:		driver = new ChromeDriver();
					break;
	}
	
	driver.get("http://hov-uat-aio01.productmadness.com/admin/game_accounts/"+GAID+"#summary");
	
	if (driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")) != null) {
	/*	
		driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
		s.wait(2.1);
		if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
			driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(selectAll);		
			driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
			driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(selectAll);
			driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
			
			driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
			
			try {
				driver.wait(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

*/
		s.wait(2.1);
		driver.findElement(By.id("admin_email")).sendKeys(selectAll);	
		driver.findElement(By.id("admin_email")).sendKeys(CommonOperations.fbLogin);	
		driver.findElement(By.id("admin_password")).sendKeys(selectAll);	
		driver.findElement(By.id("admin_password")).sendKeys(CommonOperations.fbPassword);
		driver.findElement(By.id("admin_password")).sendKeys(Key.ENTER);
	}
	
	s.wait(2.1);
	driver.findElement(By.xpath("//div[4]/div[2]/ul/li[2]/a")).click();
	
	driver.findElement(By.xpath("//div[@id='bonuses']/form/table/tbody/tr[7]/td/input")).click();
	
	driver.findElement(By.xpath("//div[@id='bonuses']/form/div[2]/div/div[2]/button")).click();
	
	/*try {
		driver.wait(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	s.wait(7.1);
	driver.close();
		
}

public static void addGAIDToCRM (String browser, String GAID) {
	
	WebDriver driver;
	
	System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
	System.setProperty("webdriver.edge.driver", "lib\\webdriver\\MicrosoftWebDriver.exe");
	
	switch(browser) {
	case "chrome": 	driver = new ChromeDriver();
					break;
	case "firefox": driver = new FirefoxDriver();
					break;
	case "iexplore":driver = new InternetExplorerDriver();
					break;
	default:		driver = new ChromeDriver();
					break;
	}
	

	Actions action = new Actions(driver);
	
	driver.get("http://hov-uat-aio01.productmadness.com/admin/crm/actions/1683/edit");

	if (driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")) != null) {
		s.wait(2.1);
		driver.findElement(By.id("admin_email")).sendKeys(selectAll);	
		driver.findElement(By.id("admin_email")).sendKeys(CommonOperations.fbLogin);	
		driver.findElement(By.id("admin_password")).sendKeys(selectAll);	
		driver.findElement(By.id("admin_password")).sendKeys(CommonOperations.fbPassword);
		driver.findElement(By.id("admin_password")).sendKeys(Key.ENTER);
		/*
		driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
		s.wait(2.1);
		if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
			driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(selectAll);		
			driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
			driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(selectAll);
			driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
			
			driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
			*/
			/*try {
				driver.wait(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/
		
	}
	s.wait(2.1);
	action.moveToElement(driver.findElement(By.xpath("//form[@id='edit_crm_action_1683']/div[23]/div/div[2]/div/div/div/textarea"))).doubleClick().perform();
	s.wait(2.1);
	driver.findElement(By.xpath("//form[@id='edit_crm_action_1683']/div[23]/div/div[2]/div/div/div/textarea")).sendKeys(GAID);	
	driver.findElement(By.xpath("//div[2]/button")).click();
	
	/*try {
		driver.wait(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	s.wait(7.1);
	driver.close();
	
}	

public static void removeGAIDFromCRM (String browser, String GAID) {
	
	WebDriver driver;
	
	System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
	System.setProperty("webdriver.edge.driver", "lib\\webdriver\\MicrosoftWebDriver.exe");
	
	switch(browser) {
	case "chrome": 	driver = new ChromeDriver();
					break;
	case "firefox": driver = new FirefoxDriver();
					break;
	case "iexplore":driver = new InternetExplorerDriver();
					break;
	default:		driver = new ChromeDriver();
					break;
	}
	

	Actions action = new Actions(driver);
	
	driver.get("http://hov-uat-aio01.productmadness.com/admin/crm/actions/1683/edit");

	if (driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")) != null) {
		s.wait(2.1);
		driver.findElement(By.id("admin_email")).sendKeys(selectAll);	
		driver.findElement(By.id("admin_email")).sendKeys(CommonOperations.fbLogin);	
		driver.findElement(By.id("admin_password")).sendKeys(selectAll);	
		driver.findElement(By.id("admin_password")).sendKeys(CommonOperations.fbPassword);
		driver.findElement(By.id("admin_password")).sendKeys(Key.ENTER);
	/*	driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
		s.wait(2.1);
		if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
			driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(selectAll);		
			driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
			driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(selectAll);
			driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
			
			driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
			*/
		/*	try {
				driver.wait(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/
		
	}
	s.wait(2.1);
	action.moveToElement(driver.findElement(By.xpath("//form[@id='edit_crm_action_1683']/div[23]/div/div[2]/div/div/div/textarea"))).doubleClick().perform();
	s.wait(2.1);
	driver.findElement(By.xpath("//form[@id='edit_crm_action_1683']/div[23]/div/div[2]/div/div/div/textarea")).sendKeys(Keys.BACK_SPACE);
	
	driver.findElement(By.xpath("//div[2]/button")).click();
	
	/*try {
		driver.wait(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	s.wait(7.1);
	driver.close();
	
}


public static String getGAID (String browser, String userFacebookID) {
	if (currentGAID == null)
	{
		WebDriver driver;
		
		System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "lib\\webdriver\\MicrosoftWebDriver.exe");
		
		switch(browser) {
		case "chrome": 	driver = new ChromeDriver();
						break;
		case "firefox": driver = new FirefoxDriver();
						break;
		case "iexplore":driver = new InternetExplorerDriver();
						break;
		default:		driver = new ChromeDriver();
						break;
		}
			
		driver.get("http://hov-uat-aio01.productmadness.com/admin/game_accounts?utf8=%E2%9C%93&search_type=social_network_id&search_value[]="+userFacebookID+"&commit=Search");
	
		if (driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")) != null) {
			s.wait(2.1);
			driver.findElement(By.id("admin_email")).sendKeys(selectAll);	
			driver.findElement(By.id("admin_email")).sendKeys(CommonOperations.fbLogin);	
			driver.findElement(By.id("admin_password")).sendKeys(selectAll);	
			driver.findElement(By.id("admin_password")).sendKeys(CommonOperations.fbPassword);
			driver.findElement(By.id("admin_password")).sendKeys(Key.ENTER);
			/*
			driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
			s.wait(2.1);
			if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
				driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(selectAll);		
				driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
				driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(selectAll);
				driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
				
				driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
				*/
				/*try {
					driver.wait(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}*/
			
		}
		s.wait(2.1);
		driver.findElement(By.xpath("//div[4]/div[2]/ul/li/a")).click();
		
		String GAID = driver.findElement(By.xpath("//div/div/div/div/table/tbody/tr/td[2]")).getText();
		s.wait(7.1);
		driver.close();
		
		return GAID;
	}
	else
	{
		return currentGAID;
	}
}

public static void setExclusionGroup (String browser, String userFacebookID, int groupId) {
	
	WebDriver driver;
	
	System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
	System.setProperty("webdriver.edge.driver", "lib\\webdriver\\MicrosoftWebDriver.exe");
	
	switch(browser) {
	case "chrome": 	driver = new ChromeDriver();
					break;
	case "firefox": driver = new FirefoxDriver();
					break;
	case "iexplore":driver = new InternetExplorerDriver();
					break;
	default:		driver = new ChromeDriver();
					break;
	}
		
	driver.get("http://hov-uat-aio01.productmadness.com/admin/game_accounts?utf8=%E2%9C%93&search_type=social_network_id&search_value[]="+userFacebookID+"&commit=Search");

	if (driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")) != null) {
		s.wait(2.1);
		driver.findElement(By.id("admin_email")).sendKeys(selectAll);	
		driver.findElement(By.id("admin_email")).sendKeys(CommonOperations.fbLogin);	
		driver.findElement(By.id("admin_password")).sendKeys(selectAll);	
		driver.findElement(By.id("admin_password")).sendKeys(CommonOperations.fbPassword);
		driver.findElement(By.id("admin_password")).sendKeys(Key.ENTER);
		/*
		driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
		s.wait(2.1);
		if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {			
			
			driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(selectAll);		
			driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
			driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(selectAll);
			driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
			
			driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
			
			/*try {
				driver.wait(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		*/
	}
	s.wait(2.1);
	driver.findElement(By.xpath("//div[4]/div[2]/ul/li/a")).click();
	
	driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr[5]/td[3]/form/div[3]/input")).sendKeys(Integer.toString(groupId));
	driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr[5]/td[3]/form/div[3]/input")).sendKeys(Key.ENTER);
	//driver.findElement(By.xpath("//tr[4]/td[3]/form/div[4]/button")).click();
	
	/*try {
		driver.wait(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	s.wait(7.1);
	driver.close();
	
}
	
public static void setLevel(String browser, String userFacebookID, int level)	
{
	WebDriver driver;
	
	System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
	System.setProperty("webdriver.edge.driver", "lib\\webdriver\\MicrosoftWebDriver.exe");
	
	switch(browser) {
	case "chrome": 	driver = new ChromeDriver();
					break;
	case "firefox": driver = new FirefoxDriver();
					break;
	case "iexplore":driver = new InternetExplorerDriver();
					break;
	default:		driver = new ChromeDriver();
					break;
	}
		
	driver.get("http://hov-uat-aio01.productmadness.com/admin/game_accounts?utf8=%E2%9C%93&search_type=social_network_id&search_value[]="+userFacebookID+"&commit=Search");

	if (driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")) != null) {
		s.wait(2.1);
		driver.findElement(By.id("admin_email")).sendKeys(selectAll);	
		driver.findElement(By.id("admin_email")).sendKeys(CommonOperations.fbLogin);	
		driver.findElement(By.id("admin_password")).sendKeys(selectAll);	
		driver.findElement(By.id("admin_password")).sendKeys(CommonOperations.fbPassword);
		driver.findElement(By.id("admin_password")).sendKeys(Key.ENTER);
		/*
		driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
		s.wait(2.1);
		if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {			
			
			driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(selectAll);		
			driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
			driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(selectAll);
			driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
			
			driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
			
			/*try {
				driver.wait(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		*/
	}
	s.wait(2.1);
	driver.findElement(By.xpath("//div[4]/div[2]/ul/li/a")).click();
	driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr[3]/td[3]/form/div[3]/input")).sendKeys(Integer.toString(level));
	driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr[3]/td[3]/form/div[3]/input")).sendKeys(Key.ENTER);
	s.wait(7.1);
	driver.close();
	
	
	
}


public static String checkIngameEvents(String browser, String[] requiredEventsArray, String userFacebookID)
{
	
	WebDriver driver;
	
	String absentEvents = "";
	
	System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
	System.setProperty("webdriver.edge.driver", "lib\\webdriver\\MicrosoftWebDriver.exe");
	
	switch(browser) {
	case "chrome": 	driver = new ChromeDriver();
					break;
	case "firefox": driver = new FirefoxDriver();
					break;
	case "iexplore":driver = new InternetExplorerDriver();
					break;
	default:		driver = new ChromeDriver();
					break;
	}
		
	driver.get("http://hov-uat-aio01.productmadness.com/admin/game_accounts?utf8=%E2%9C%93&search_type=social_network_id&search_value[]="+userFacebookID+"&commit=Search");

	if (driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")) != null) 
	{
		s.wait(2.1);
		driver.findElement(By.id("admin_email")).sendKeys(selectAll);	
		driver.findElement(By.id("admin_email")).sendKeys(CommonOperations.fbLogin);	
		driver.findElement(By.id("admin_password")).sendKeys(selectAll);	
		driver.findElement(By.id("admin_password")).sendKeys(CommonOperations.fbPassword);
		driver.findElement(By.id("admin_password")).sendKeys(Key.ENTER);		
	}
	s.wait(2.1);
	driver.findElement(By.xpath("//div[4]/div/ul/li[5]/a")).click();
	driver.findElement(By.xpath("//form[@id='events_filter_form']/div[2]/div/button")).click();
	int columnCount = driver.findElements(By.xpath("//form[@id='events_filter_form']/div[2]/div/ul/li")).size();
	int requiredEventsArrayItemsAmount = requiredEventsArray.length;
	int matchAmount = 0;
	
	for (String event : requiredEventsArray)
	{
		boolean isFind = false;
		for (int i=1; i<=columnCount; i++ )
		{	
			try
			{
				
				if ((driver.findElement(By.xpath("//form[@id='events_filter_form']/div[2]/div/ul/li["+i+"]/a/label")).getText()).equals(event))
				{
					matchAmount++;
					isFind = true;
					break;
				}
				else
				{
					if ((i==columnCount) && !isFind)
					{
						absentEvents += event + "\n";
					}
				}
			}
			catch (Exception e)
			{
				absentEvents += event + "\n";
				System.out.println(e.getMessage());
			}
		}
	}
	System.out.println("Found "+ matchAmount+ " / " + requiredEventsArrayItemsAmount+" : " + absentEvents);
	driver.close();
	
	return absentEvents;
}

}
