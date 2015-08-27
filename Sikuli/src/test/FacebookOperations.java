package test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.sikuli.script.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class FacebookOperations {
	public static URL userLogin;
	public static String userFacebookId;
	public static String userEmail;
	public static String userPassword;
	
	static Screen screen= new Screen();
	public static App browser;
	
	public static void createTestUser () throws Exception, IOException {
		
		URL url = new URL("https://graph.facebook.com/600712740047839/accounts/test-users?installed=false&name=AutomatedTester&language=en&region=uk&permissions=read_stream&method=post&access_token=600712740047839|vu3RyiAd-1K5zXZN4l4pocttOEk");
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JSONParser jsonParser = new JSONParser();
	    JSONObject object = (JSONObject) jsonParser.parse(response.toString());
	    //JSONObject object = (JSONObject) jsonArray.get(0);
	    String loginUrl = (String) object.get("login_url");
	    String id = (String) object.get("id");
	    
	    userLogin = new URL(loginUrl);
	    userFacebookId = id;
	    
	    System.out.println("user login link"+userLogin);
	    System.out.println("user id"+userFacebookId);
	    
	    BrowserOperations.clickSearch();
	    screen.paste("https://developers.facebook.com/apps/600712740047839/payments/");
		screen.type(Key.ENTER);
	    screen.wait(5.1);
		screen.click("browser//facebook_canvas_payments_click.png");
		
		screen.paste(userFacebookId);
		screen.wait(2.1);
		screen.type(Key.ENTER);
		screen.wait(0.5);
		/*screen.type(Key.TAB);
		screen.type(Key.PAGE_DOWN);
		screen.wait(5.1);
		screen.type(Key.PAGE_DOWN);
		screen.click("browser//facebook_save_changes.png");*/
		screen.type(Key.ENTER);
	}
	
	public static void deleteTestUser () throws Exception {
		
		URL deleteUrl = new URL("https://graph.facebook.com/v2.4/"+userFacebookId+"?method=delete&access_token=600712740047839|vu3RyiAd-1K5zXZN4l4pocttOEk");
		HttpURLConnection con = (HttpURLConnection) deleteUrl.openConnection();

		// optional default is GET
		con.setRequestMethod("DELETE");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'DELETE' request to URL : " + deleteUrl);
		System.out.println("Response Code : " + responseCode);

	}

	public static void loginTestUser() throws Exception{
		BrowserOperations.clickSearch();
		screen.paste(userLogin.toString());
		screen.type(Key.ENTER);
		screen.wait(5.5);
		screen.click("browser//login_as_button.png");
		screen.wait(5.5);
		screen.click("browser//login_confirmation.png");
	}
	
	public static void loginFacebook(String browser) throws Exception
	{
		BrowserOperations.clickSearch();
		screen.paste("https://www.facebook.com/login.php");
		screen.type(Key.ENTER);
		screen.wait(15.0);
		
		if ((browser.equals("iexplore")) || (browser.equals("edge")))
		{
			
			screen.click("browser//facebook_login.png");
			screen.paste(CommonOperations.fbLogin);
			screen.type(Key.TAB);
			screen.paste(CommonOperations.fbPassword);
			screen.type(Key.ENTER);
		}
		else
		{
			screen.type(Key.TAB);
			screen.paste(CommonOperations.fbLogin);
			screen.type(Key.TAB);
			screen.paste(CommonOperations.fbPassword);
			screen.type(Key.ENTER);
		}
		
		
	}
	public static void changeLanguageFacebook(String browser) throws Exception
	{
		BrowserOperations.clickSearch();
		screen.paste("https://www.facebook.com/settings?tab=language&section=primary&view");
		screen.type(Key.ENTER);
		screen.wait(15.0);
		
		screen.click("browser//"+browser+"_downArrow.png");
		screen.type("e");
		screen.type("n");
		screen.type("g");
		screen.type(Key.DOWN);
		screen.type(Key.ENTER);
		screen.type(Key.TAB);
		screen.type(Key.ENTER);
	}
	
}