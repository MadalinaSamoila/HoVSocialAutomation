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
	
	
	public static void resetDailyWheel (String browser, String UAID) {
		
		WebDriver driver;
		
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
		
		driver.get("http://hov-uat-aio01.productmadness.com/admin/game_accounts/"+UAID+"#summary");
		driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
		driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys("muddyrogue@gmail.com");
		driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys("ciorivopsite");

		driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();


		driver.findElement(By.xpath("//div[4]/div[2]/ul/li[2]/a")).click();
		
		driver.findElement(By.xpath("//div[@id='bonuses']/form/table/tbody/tr/td/input")).click();
		driver.findElement(By.xpath("//div[@id='bonuses']/form/table/tbody/tr[3]/td/input")).click();
		driver.findElement(By.xpath("//div[@id='bonuses']/form/table/tbody/tr[6]/td/input")).click();
		
		driver.findElement(By.xpath("//div[@id='bonuses']/form/div[2]/div/div[2]/button")).click();
		

		
	}
	
	public static void resetUserLevel (String browser, String UAID, int level) {
		
		WebDriver driver;
		
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
		
		driver.get("http://hov-uat-aio01.productmadness.com/admin/game_accounts/"+UAID+"#summary");
		driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
		driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys("muddyrogue@gmail.com");
		driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys("ciorivopsite");

		driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
		
		driver.findElement(By.xpath("//div[4]/div[2]/ul/li/a")).click();
		
		driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr[3]/td[3]/form/div[3]/input")).sendKeys(new Integer(level).toString());
		
		driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr[3]/td[3]/form/div[4]/button")).click();
		
	}
	
	public static void resetUserBalance (String browser, String UAID, double balance) {
		
		WebDriver driver;
		
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
		
		driver.get("http://hov-uat-aio01.productmadness.com/admin/game_accounts/"+UAID+"#summary");
		driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
		driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys("muddyrogue@gmail.com");
		driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys("ciorivopsite");

		driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
		
		driver.findElement(By.xpath("//div[4]/div[2]/ul/li/a")).click();
		
		Select droplist  = new Select(driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr/td[3]/form/div[2]/select")));
		droplist.selectByValue("label=Set to");
		
		driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr/td[3]/form/div[3]/input")).sendKeys(String.valueOf(balance));
		
		driver.findElement(By.xpath("//div[@id='game-accounts-form']/div/div/table/tbody/tr/td[3]/form/div[4]/button")).click();		
		
	}
	
public static double getUserBalance (String browser, String UAID) {
		
		WebDriver driver;
		
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
		
		driver.get("http://hov-uat-aio01.productmadness.com/admin/game_accounts/"+UAID+"#summary");
		driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
		driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys("muddyrogue@gmail.com");
		driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys("ciorivopsite");

		driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
		
		driver.findElement(By.xpath("//div[4]/div[2]/ul/li/a")).click();
		
		String balanceString = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td[2]")).getText();
		double balance = Double.parseDouble(balanceString);
		
		return balance;
		
		
	}


public static void resetHourlyBonus (String browser, String UAID) {
	
	WebDriver driver;
	
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
	
	driver.get("http://hov-uat-aio01.productmadness.com/admin/game_accounts/"+UAID+"#summary");
	driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
	driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys("muddyrogue@gmail.com");
	driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys("ciorivopsite");

	driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();


	driver.findElement(By.xpath("//div[4]/div[2]/ul/li[2]/a")).click();
	
	driver.findElement(By.xpath("//div[@id='bonuses']/form/table/tbody/tr[7]/td/input")).click();
	
	driver.findElement(By.xpath("//div[@id='bonuses']/form/div[2]/div/div[2]/button")).click();
		
}

public static void addUAIDToCRM (String browser, String UAID) {
	
	WebDriver driver;
	
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
	driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
	driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys("muddyrogue@gmail.com");
	driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys("ciorivopsite");

	driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
	
	action.moveToElement(driver.findElement(By.xpath("//form[@id='edit_crm_action_1683']/div[23]/div/div[2]/div/div/div/textarea"))).doubleClick().perform();
	
	driver.findElement(By.xpath("//form[@id='edit_crm_action_1683']/div[23]/div/div[2]/div/div/div/textarea")).sendKeys(UAID);
	
	driver.findElement(By.xpath("(//div[2]/button")).click();
	
}	

public static void removeUAIDFromCRM (String browser, String UAID) {
	
	WebDriver driver;
	
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
	driver.findElement(By.xpath("//form[@id='new_admin']/div[5]/div/a")).click();
	driver.findElement(By.xpath("//div[@id='loginform']/div/input")).sendKeys("muddyrogue@gmail.com");
	driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input")).sendKeys("ciorivopsite");

	driver.findElement(By.xpath("//div[@id='login_button_inline']/label")).click();
	
	action.moveToElement(driver.findElement(By.xpath("//form[@id='edit_crm_action_1683']/div[23]/div/div[2]/div/div/div/textarea"))).doubleClick().perform();
	
	driver.findElement(By.xpath("//form[@id='edit_crm_action_1683']/div[23]/div/div[2]/div/div/div/textarea")).sendKeys(Keys.BACK_SPACE);
	
	driver.findElement(By.xpath("(//div[2]/button")).click();
	
}
	
	

}
