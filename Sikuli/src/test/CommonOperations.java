package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;


public class CommonOperations 
{
	//for external
	public static String testRailHostAdress = "";
	public static String testRailLogin = "";
	public static String testRailPassword = "";
	public static String testRailRunId_chrome = "";
	public static String testRailRunId_firefox = "";
	public static String testRailRunId_iexplore = "";
	public static String fbLogin = "";
	public static String fbPassword = "";
	public static String chromePath = "";
	public static String firefoxPath = "";
	public static String iexplorePath = "";
	public static String hov_load_time = "";
	public static String hov_slot_load_time = "";
	
	//for internal
	public static String currentBrowser;
	private static Frame mainFrame;
	
	private static void maximizeWondow()
	{
		Screen s = new Screen();
		s.keyDown(Key.WIN);
		s.keyDown(Key.UP);
		s.keyUp(Key.WIN);
		s.keyUp(Key.UP);
		
        s.keyDown(Key.WIN);
		s.keyDown(Key.DOWN);
		s.keyUp(Key.WIN);
		s.keyUp(Key.DOWN);
		
		s.keyDown(Key.WIN);
		s.keyDown(Key.LEFT);
		s.keyUp(Key.WIN);
		s.keyUp(Key.LEFT);
		
		s.keyDown(Key.WIN);
		s.keyDown(Key.UP);
		s.keyUp(Key.WIN);
		s.keyUp(Key.UP);
	}
	
	public static String setDisplayResolutionMode(int mode, boolean returnOldResolution)
	{
		
		Screen s = new Screen();
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice();
		GraphicsConfiguration gc = device.getDefaultConfiguration();
		DisplayMode oldMode = device.getDisplayMode();
		DisplayMode[] DISPLAY_MODES = new DisplayMode[]
		{
	        new DisplayMode(1024, 768, oldMode.getBitDepth(),oldMode.getRefreshRate()),
	        new DisplayMode(1366, 768, oldMode.getBitDepth(),oldMode.getRefreshRate()),
	        new DisplayMode(1600, 900, oldMode.getBitDepth(),oldMode.getRefreshRate()), 
	        new DisplayMode(1920, 1080, oldMode.getBitDepth(),oldMode.getRefreshRate())
	    };
		
		
			try
			{
				if (!returnOldResolution)
				{
					mainFrame = new Frame(gc);
		            mainFrame.setUndecorated(true);
		            mainFrame.setIgnoreRepaint(true);
		            device.setFullScreenWindow(mainFrame);
					device.setDisplayMode(DISPLAY_MODES[mode]);
					
			        mainFrame.hide();
			        maximizeWondow();
			        s.wait(1.5);
			        try 
			        {
			      	    s.click("externalPages//System_notify_closePopup.png");
			        }
			        catch (FindFailed ex)
			        {}
			        s.wait(5.5);
				}
		       
				else
				{
				mainFrame.dispose();
				maximizeWondow();
				s.wait(3.5);
				}
				return "[testprogress] Resolution was changed to "+ DISPLAY_MODES[mode].getWidth() + " x "+ DISPLAY_MODES[mode].getHeight() + " \n";
			
		}
		catch (Exception e)
		{
			mainFrame.dispose();
			maximizeWondow();
			s.wait(3.5);
			return "[testprogress] Can't change screen resolution to "+ DISPLAY_MODES[mode].getWidth() + " x "+ DISPLAY_MODES[mode].getHeight()+ "  \n" + e.getMessage()+"\n";
		}
	}
	
	
	public static JSONArray getJsonArrayFromFile(String path) throws ParseException, IOException, FileNotFoundException 
	{
		try
		{
			
			JSONParser parser = new JSONParser();
			
			JSONArray a = (JSONArray) parser.parse(new FileReader(path));
			
			return a;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found!");
			e.printStackTrace();
			return null;
		}
		catch (IOException e)
		{
			System.out.println("Unable to read/write the file!");
			e.printStackTrace();
			return null;
		}
		catch (ParseException e)
		{
			System.out.println("It is not a JSON file!");
			e.printStackTrace();
			return null;
		}	
	}
	
	public static String getFieldFromJsonArray(JSONArray a, String field)
	{
		String res = null;
		
		for (Object o : a)
		{
			JSONObject person = (JSONObject) o;
			
			res = (String) person.get(field);
			//System.out.println(res);
		}
		return res;				
	}
	
	public static boolean fillFieldsFromConfigFile(String path) throws ParseException, IOException, FileNotFoundException, NullPointerException
	{
		try
		{
			JSONArray a = CommonOperations.getJsonArrayFromFile(path);
			if (!(getFieldFromJsonArray(a, "fb_email").equals(null)))
			{
				fbLogin = CommonOperations.getFieldFromJsonArray(CommonOperations.getJsonArrayFromFile(path), "fb_email");
			}
			if (!(getFieldFromJsonArray(a, "fb_password").equals(null)))
			{
				fbPassword = CommonOperations.getFieldFromJsonArray(CommonOperations.getJsonArrayFromFile(path), "fb_password");		
			}
			if (!(getFieldFromJsonArray(a, "tr_host").equals(null)))
			{
				testRailHostAdress = CommonOperations.getFieldFromJsonArray(CommonOperations.getJsonArrayFromFile(path), "tr_host");
			}
			if (!(getFieldFromJsonArray(a, "tr_email").equals(null)))
			{
				testRailLogin = CommonOperations.getFieldFromJsonArray(CommonOperations.getJsonArrayFromFile(path), "tr_email");
			}
			if (!(getFieldFromJsonArray(a, "tr_password").equals(null)))
			{
				testRailPassword = CommonOperations.getFieldFromJsonArray(CommonOperations.getJsonArrayFromFile(path), "tr_password");
			}
			if (!(getFieldFromJsonArray(a, "tr_run_id_chrome").equals(null)))
			{
				testRailRunId_chrome = CommonOperations.getFieldFromJsonArray(CommonOperations.getJsonArrayFromFile(path), "tr_run_id_chrome");
			}
			if (!(getFieldFromJsonArray(a, "tr_run_id_firefox").equals(null)))
			{
				testRailRunId_firefox = CommonOperations.getFieldFromJsonArray(CommonOperations.getJsonArrayFromFile(path), "tr_run_id_firefox");
			}
			if (!(getFieldFromJsonArray(a, "tr_run_id_iexplore").equals(null)))
			{
				testRailRunId_iexplore = CommonOperations.getFieldFromJsonArray(CommonOperations.getJsonArrayFromFile(path), "tr_run_id_iexplore");
			}
			
			
			if (!(getFieldFromJsonArray(a, "chrome_path").equals(null)))
			{
				chromePath = CommonOperations.getFieldFromJsonArray(CommonOperations.getJsonArrayFromFile(path), "chrome_path");	
			}
			if (!(getFieldFromJsonArray(a, "firefox_path").equals(null)))
			{
				firefoxPath += CommonOperations.getFieldFromJsonArray(CommonOperations.getJsonArrayFromFile(path), "firefox_path");	
			}
			if (!(getFieldFromJsonArray(a, "iexplore_path").equals(null)))
			{
				iexplorePath = CommonOperations.getFieldFromJsonArray(CommonOperations.getJsonArrayFromFile(path), "iexplore_path");
			}
			if (!(getFieldFromJsonArray(a, "hov_load_time").equals(null)))
			{
				hov_load_time = CommonOperations.getFieldFromJsonArray(CommonOperations.getJsonArrayFromFile(path), "hov_load_time");
			}
			if (!(getFieldFromJsonArray(a, "hov_slot_load_time").equals(null)))
			{
				hov_slot_load_time = CommonOperations.getFieldFromJsonArray(CommonOperations.getJsonArrayFromFile(path), "hov_slot_load_time");
			}		
			
			return true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Configuration file not found!");
			return false;
		}
		catch (IOException e)
		{
			System.out.println( "Unable to read/write the configuration file!");
			return false;
		}
		catch (ParseException e)
		{
			System.out.println( "Can't parse JSON file (configuration file)!");
			return false;
		}	
		catch (NullPointerException e)
		{
			System.out.println( "Some field(s) are absent in configuration file!");
			return false;
		}	
		 		
	}
	
	public static String getRunIdByBrowser()
	{
		switch (currentBrowser)
		{
			case "chrome":
			{
				return testRailRunId_chrome;
			}
			case "firefox":
			{
				return testRailRunId_firefox;
			}
			case "iexplore":
			{
				return testRailRunId_iexplore;
			}
			default:
			{
				return testRailRunId_chrome;
			}
		}
	}
	
	
	
	
}