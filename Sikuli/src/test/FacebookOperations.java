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


public class FacebookOperations {
	public static URL userLogin;
	public static String userId;
	public static String userEmail;
	public static String userPassword;
	
	static Screen screen= new Screen();
	public static App browser;
	
	public static void createTestUser () throws Exception, IOException {
		
		URL url = new URL("https://graph.facebook.com/600712740047839/accounts/test-users?installed=false&name=MuddyAutomatedTester&permissions=read_stream&method=post&access_token=600712740047839|vu3RyiAd-1K5zXZN4l4pocttOEk");
		
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
	    userId = id;
	    
	    System.out.println("user login link"+userLogin);
	    System.out.println("user id"+userId);
	    
	    screen.paste("https://developers.facebook.com/apps/600712740047839/payments/");
		screen.type(Key.ENTER);
	    
		screen.click("browser//facebook_canvas_payments_click.png");
		
		screen.paste(userId);
		screen.type(Key.END);
		screen.click("browser//facebook_save_changes.png");
	}
	
	public static void deleteTestUser () throws Exception {
		
		URL deleteUrl = new URL("https://graph.facebook.com/v2.4/"+userId+"?method=delete&access_token=600712740047839|vu3RyiAd-1K5zXZN4l4pocttOEk");
		HttpURLConnection con = (HttpURLConnection) deleteUrl.openConnection();

		// optional default is GET
		con.setRequestMethod("DELETE");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'DELETE' request to URL : " + deleteUrl);
		System.out.println("Response Code : " + responseCode);

	}

	public static void loginTestUser() throws Exception{
		
		screen.paste(userLogin.toString());
		screen.type(Key.ENTER);
		screen.click("browser//login_as_button.png");
		screen.wait(0.5);
		screen.click("browser//login_confirmation.png");
	}
}
