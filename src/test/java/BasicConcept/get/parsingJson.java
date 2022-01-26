package BasicConcept.get;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.response.Response;

public class parsingJson {
	
public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		
		
		
		Response response = given().when().get("https://jsonplaceholder.typicode.com/posts/1").then()
				.statusCode(200).and().extract().response();
		
		
		
		
		System.out.println(readMethod(response).get("id"));
		System.out.println(readMethod(response).get("title"));
		System.out.println(readMethod(response).get("body"));
	}

	
	public static JSONObject readMethod(Response response) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser rowData = new JSONParser();
		
		
		
		
		
		JSONObject jsonObject = (JSONObject) rowData.parse(response.asString());
		
		jsonObject.get(jsonObject);
		
		return(jsonObject);
	} 

}
