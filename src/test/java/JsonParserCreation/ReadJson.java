package JsonParserCreation;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {

	public static void main(String arg[]) throws IOException, ParseException {

		JSONParser parser = new JSONParser();

		Reader reader = new FileReader(".//test.json");

		JSONObject ob = (JSONObject) parser.parse(reader);
		
		
		
		given().contentType("application/json; charset=UTF-16").body(ob.toJSONString()).post("http://localhost:3000/posts").then().statusCode(201);

		
		
		/*
		String name = (String) ob.get("name");

		System.out.println(name);

		Long age = (Long) ob.get("age");

		System.out.println(age);
		
		
		
		JSONArray msg=(JSONArray) ob.get("messages");
		
		
		Iterator<String> it=msg.iterator();
		
		while(it.hasNext()) {
			
			System.out.println(it.next());
			
			
		}*/
		
		
		
		
		
		

	}

}
