package Data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import io.ous.jtoml.ParseException;




public class JsonDataReader 
{
	public String FirstName,LastName,Email,Password;
	
	public void JsonReader() throws ParseException, IOException, org.json.simple.parser.ParseException 
	{
		String filePath = System.getProperty("user.dir") + "/src/test/java/Data/UserData.Json";
		
		File srcfile = new File(filePath);
		
		
		
		JSONParser parser = new JSONParser();
		JSONArray jarry = (JSONArray) parser.parse(new FileReader(srcfile));
		
	    for (Object jsonObj : jarry)
	    {
	    	JSONObject person = (JSONObject) jsonObj;
	    	FirstName = (String) person.get("FirstName");
	    	System.out.println(FirstName);
	    	LastName = (String) person.get("LastName");
	    	System.out.println(LastName);
	    	Email = (String) person.get("Email");
	    	System.out.println(Email);
	    	Password = (String) person.get("Password");
	    	System.out.println(Password);	
	    }
	    
	}

}
