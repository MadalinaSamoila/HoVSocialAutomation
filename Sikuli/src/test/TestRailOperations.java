package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

public class TestRailOperations 
{
	/*////////// SHOULD BU UNCOMMENTED AFTER FULL INTEGRATION OF READING CONFIGURATION FILE
	public static String testRailHostAdress;
	public static String testRailLogin;
	public static String testRailPassword;
	public static String testRailRunId;
	
	public static String testRailHostAdress = "https://productmadness.testrail.com/";
	public static String testRailLogin = "a.hilchuk@a1qa.com";
	public static String testRailPassword = "G6K8vVfKaAECBiAChQGU";
	public static String testRailRunId = "27485";
	*/
	public static String getTestIdByTitleInRun(String hostAdress, String login, String password, String runId, String title) throws APIException, IOException
	{
		try
		{
			APIClient client = new APIClient(hostAdress);
			client.setUser(login);
			client.setPassword(password);
			
			JSONArray c = (JSONArray) client.sendGet("get_tests/"+runId);
			String resSrting = null;
			
			for (Object o : c)
			{
				JSONObject obj = (JSONObject) o;				
				String tmp =(String) obj.get("title");			
				if (tmp.equals(title))
				{
					resSrting = obj.get("id").toString();
				}
				
			}
			
			return resSrting;
		}
		catch (APIException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;		
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;		
		}
	}
	
	//status ID: 1-Passed;2-Blocked;3-Untested (not allowed when adding a result);4-Retest;5-Failed
	public static void setResultToTest(String hostAdress, String login, String password, String testId, int statusId, String comment) throws APIException, IOException
	{
		try
		{
			APIClient client = new APIClient(hostAdress);
			client.setUser(login);
			client.setPassword(password);
			
			Map data = new HashMap();
			data.put("status_id", new Integer(statusId));
			data.put("comment", comment);
			JSONObject r = (JSONObject) client.sendPost("add_result/"+testId, data);
			
			
		}
		catch (APIException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
