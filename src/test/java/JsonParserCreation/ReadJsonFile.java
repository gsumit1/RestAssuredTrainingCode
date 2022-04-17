package JsonParserCreation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonFile {
	
public static void main(String[] arg ) throws IOException, ParseException  {
		
		JSONParser jp=new JSONParser();
		
		Reader reader=new FileReader(".//demo.json");
		
		
		JSONObject ob= (JSONObject) jp.parse(reader);
		
		System.out.println(ob.get("name"));
		System.out.println(ob.get("place"));
		
		
		System.out.println(ob.get("messages"));
		
		JSONArray ja= (JSONArray) ob.get("messages");
		
		
		Iterator<String> it=ja.iterator();		
		
		while(it.hasNext()) {
			
			System.out.println(it.next());
		}
		
		
		
		
}

}
