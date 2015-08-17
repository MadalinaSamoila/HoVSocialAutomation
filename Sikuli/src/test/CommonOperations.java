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
		}
		return res;
		
		
	}
}
