package test;

import org.sikuli.script.*;

public class AdminOperations {
	
	static Screen screen= new Screen();
	
	public static void resetDailyWheel (String browser) {
		
		screen.paste("http://hov-uat-aio01.productmadness.com/admin/game_accounts/6237064#bonuses");
		screen.type(Key.ENTER);
		screen.wait(1.5);
		try {
			screen.click("admin/sign_in_admin.png");
		
			screen.wait(2.5);
			
			screen.click("admin//admin_bonuses_tab.png");
		
			screen.wait(2.5);

			screen.click(screen.find("admin//"+browser+"_admin_daily_bonus.png").find("browser//"+browser+"_checkbox.png"));
			screen.click(screen.find("admin//"+browser+"_admin_friends_bonus.png").find("browser//"+browser+"_checkbox.png"));
			screen.click(screen.find("admin//"+browser+"_admin_wheel_bonus.png").find("browser//"+browser+"_checkbox.png"));
			
			screen.click("admin//admin_reset_selected.png");
			screen.wait(3.5);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void resetUserLevel (String browser, int UAID, int level) {
		
	}
	
	public static void resetUserBalance (String browser, int UAID, int balance) {
		
	}
	
	

}
