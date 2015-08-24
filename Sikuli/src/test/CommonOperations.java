package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CommonOperations 
{
	public static String testRailHostAdress = "";
	public static String testRailLogin = "";
	public static String testRailPassword = "";
	public static String testRailRunId = "";
	public static String fbLogin = "";
	public static String fbPassword = "";
	public static String chromePath = "";
	public static String firefoxPath = "";
	public static String iexplorePath = "";
	public static String hov_load_time = "";
	public static String hov_slot_load_time = "";
	
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
	
	
	/*public static String areFieldsPresentInConfigurationFile(String path) throws ParseException, IOException, FileNotFoundException, NullPointerException
	{
		String res = "";
		try
		{
			JSONParser parser = new JSONParser();
			
			JSONArray a = (JSONArray) parser.parse(new FileReader(path));
			
			if (getFieldFromJsonArray(a, "fb_email").equals(null))
			{
				res += "fb_email field is absent \n";
			}
			if (getFieldFromJsonArray(a, "fb_password").equals(null))
			{
				res += "fb_password field is absent \n";
			}
			if (getFieldFromJsonArray(a, "tr_host").equals(null))
			{
				res += "fb_password field is absent \n";
			}
			if (getFieldFromJsonArray(a, "tr_email").equals(null))
			{
				res += "fb_password field is absent \n";
			}
			if (getFieldFromJsonArray(a, "tr_password").equals(null))
			{
				res += "fb_password field is absent \n";
			}
			if (getFieldFromJsonArray(a, "tr_run_id").equals(null))
			{
				res += "fb_password field is absent \n";
			}
			if (getFieldFromJsonArray(a, "chrome_path").equals(null))
			{
				res += "fb_password field is absent \n";
			}
			if (getFieldFromJsonArray(a, "firefox_path").equals(null))
			{
				res += "fb_password field is absent \n";
			}
			if (getFieldFromJsonArray(a, "iexplore_path").equals(null))
			{
				res += "fb_password field is absent \n";
			}
			if (getFieldFromJsonArray(a, "hov_load_time").equals(null))
			{
				res += "fb_password field is absent \n";
			}
			if (getFieldFromJsonArray(a, "hov_slot_load_time").equals(null))
			{
				res += "fb_password field is absent \n";
			}
			if (res.equals(""))
			{
				res = "ok";
			}
			return res;
			
		}
		catch (FileNotFoundException e)
		{
			
			return "Configuration file not found!";
		}
		catch (IOException e)
		{
			
			return "Unable to read/write the configuration file!";
		}
		catch (ParseException e)
		{
			
			return "It is not a complete JSON file (configuration file)!";
		}	
		catch (NullPointerException e)
		{
			
			return "Some field(s) are absent in configuration file!";
		}	
		
	}
	*/
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
			if (!(getFieldFromJsonArray(a, "tr_run_id").equals(null)))
			{
				testRailRunId = CommonOperations.getFieldFromJsonArray(CommonOperations.getJsonArrayFromFile(path), "tr_run_id");
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
}