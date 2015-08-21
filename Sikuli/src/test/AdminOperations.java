package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.sikuli.script.*;

public class AdminOperations {
	
	
	public static void resetDailyWheel (String browser, String GAID) {
		
		WebDriver driver;
		
		System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
		
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
			
			driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
			if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
				
				driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
				driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
				
				driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
				
				try {
					driver.wait(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}

		driver.findElement(By.xpath("//div[4]/div[2]/ul/li[2]/a")).click();
		
		driver.findElement(By.xpath("//div[@id='bonuses']/form/table/tbody/tr/td/input")).click();
		driver.findElement(By.xpath("//div[@id='bonuses']/form/table/tbody/tr[3]/td/input")).click();
		driver.findElement(By.xpath("//div[@id='bonuses']/form/table/tbody/tr[6]/td/input")).click();
		
		driver.findElement(By.xpath("//div[@id='bonuses']/form/div[2]/div/div[2]/button")).click();
		
		try {
			driver.wait(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		
	}
	
	public static void resetUserLevel (String browser, String GAID, int level) {
		
		WebDriver driver;
		
		System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
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
			
			driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
			if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
				
				driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
				driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
				
				driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
				
				try {
					driver.wait(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		driver.findElement(By.xpath("//div[4]/div[2]/ul/li/a")).click();
		
		driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr[3]/td[3]/form/div[3]/input")).sendKeys(new Integer(level).toString());
		
		driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr[3]/td[3]/form/div[4]/button")).click();
		
		try {
			driver.wait(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		
	}
	
	public static void resetUserBalance (String browser, String GAID, double balance) {
		
		WebDriver driver;
		
		System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
		
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
			
			driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
			if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
				
				driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
				driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
				
				driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
				
				try {
					driver.wait(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		driver.findElement(By.xpath("//div[4]/div[2]/ul/li/a")).click();
		
		Select droplist  = new Select(driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr/td[3]/form/div[2]/select")));
		droplist.selectByValue("label=Set to");
		
		driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr/td[3]/form/div[3]/input")).sendKeys(String.valueOf(balance));
		
		driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr/td[3]/form/div[4]/button")).click();	
		
		try {
			driver.wait(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		
	}
	
public static double getUserBalance (String browser, String GAID) {
		
		WebDriver driver;
		
		System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
		
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
			
			driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
			if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
				
				driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
				driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
				
				driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
				
				try {
					driver.wait(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		driver.findElement(By.xpath("//div[4]/div[2]/ul/li/a")).click();
		
		String balanceString = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td[2]")).getText();
		double balance = Double.parseDouble(balanceString);
		
		driver.close();
		
		return balance;
		
		
	}


public static void resetHourlyBonus (String browser, String GAID) {
	
	WebDriver driver;
	
	System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
	
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
		
		driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
		if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
			
			driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
			driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
			
			driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
			
			try {
				driver.wait(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}


	driver.findElement(By.xpath("//div[4]/div[2]/ul/li[2]/a")).click();
	
	driver.findElement(By.xpath("//div[@id='bonuses']/form/table/tbody/tr[7]/td/input")).click();
	
	driver.findElement(By.xpath("//div[@id='bonuses']/form/div[2]/div/div[2]/button")).click();
	
	try {
		driver.wait(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.close();
		
}

public static void addGAIDToCRM (String browser, String GAID) {
	
	WebDriver driver;
	
	System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
	
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
		
		driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
		if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
			
			driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
			driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
			
			driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
			
			try {
				driver.wait(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	action.moveToElement(driver.findElement(By.xpath("//form[@id='edit_crm_action_1683']/div[23]/div/div[2]/div/div/div/textarea"))).doubleClick().perform();
	
	driver.findElement(By.xpath("//form[@id='edit_crm_action_1683']/div[23]/div/div[2]/div/div/div/textarea")).sendKeys(GAID);
	
	driver.findElement(By.xpath("(//div[2]/button")).click();
	
	try {
		driver.wait(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.close();
	
}	

public static void removeGAIDFromCRM (String browser, String GAID) {
	
	WebDriver driver;
	
	System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
	
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
		
		driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
		if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
			
			driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
			driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
			
			driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
			
			try {
				driver.wait(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	action.moveToElement(driver.findElement(By.xpath("//form[@id='edit_crm_action_1683']/div[23]/div/div[2]/div/div/div/textarea"))).doubleClick().perform();
	
	driver.findElement(By.xpath("//form[@id='edit_crm_action_1683']/div[23]/div/div[2]/div/div/div/textarea")).sendKeys(Keys.BACK_SPACE);
	
	driver.findElement(By.xpath("(//div[2]/button")).click();
	
	try {
		driver.wait(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.close();
	
}


public static String getGAID (String browser, String userFacebookID) {
	
	WebDriver driver;
	
	System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
	
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
		
		driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
		if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
			
			driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
			driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
			
			driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
			
			try {
				driver.wait(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	driver.findElement(By.xpath("//div[4]/div[2]/ul/li/a")).click();
	
	String GAID = driver.findElement(By.xpath("//div/div/div/div/table/tbody/tr/td[2]")).getText();
	
	driver.close();
	
	return GAID;
}

public static void setExclusionGroup (String browser, String userFacebookID, int groupId) {
	
	WebDriver driver;
	
	System.setProperty("webdriver.ie.driver", "lib\\webdriver\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "lib\\webdriver\\chromedriver.exe");
	
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
		
		driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
		if (driver.findElement(By.xpath("//div[@id='loginform']/div/input")) != null) {
			
			driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys(CommonOperations.fbLogin);
			driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys(CommonOperations.fbPassword);
			
			driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
			
			try {
				driver.wait(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	driver.findElement(By.xpath("//div[4]/div[2]/ul/li/a")).click();
	
	driver.findElement(By.xpath("//tr[4]/td[3]/form/div[3]/input")).sendKeys(Integer.toString(groupId));
	
	driver.findElement(By.xpath("//tr[4]/td[3]/form/div[4]/button")).click();
	
	try {
		driver.wait(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.close();
	
}
	
	

}
