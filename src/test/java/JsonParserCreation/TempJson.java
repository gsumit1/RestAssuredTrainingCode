package JsonParserCreation;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TempJson {
	
	public static void main(String[] arg )  {
		
		JSONObject obj=new JSONObject();
		
		obj.put("name", "Sumit");
		obj.put("place", "Noida");
		
		
		JSONArray list=new JSONArray();
		
		list.add("msg1");
		list.add("msg2");
		list.add("msg3");
		
		
		obj.put("messages",list);
		
		try {
			FileWriter file = new FileWriter(".//demo.json");
			file.write(obj.toJSONString());
			file.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println(obj);
		
	
	}

}
