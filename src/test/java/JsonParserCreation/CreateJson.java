package JsonParserCreation;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CreateJson {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		JSONObject obj = new JSONObject();
		
		
	//	Map<String, String> m=new HashMap<String, String>();
		obj.put("name", "Sumit");
		obj.put("age", 49);

		JSONArray list = new JSONArray();
		list.add("msg 1");
		list.add("msg 2");
		list.add("msg 3");
		
		
		JSONObject obj1 = new JSONObject();
		
		
		obj1.put("streetName", "name");
		
		
		obj.put("address", obj1);

		obj.put("messages", list);
		
		
		
		
		
		

		try {
			@SuppressWarnings("resource")
			FileWriter file = new FileWriter(".//test123.json");
			file.write(obj.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(obj);

	}

}


