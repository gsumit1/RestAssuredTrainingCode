package BasicConcept.parameter;

import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class c_parameter {
	
	@Test
	public void queryparameter() {
			
		Map<String, String> h=new HashMap<String,String>();
		h.put("text", "testcaseOne");
		
		given().queryParams(h).log().all().when().get("http://md5.jsontest.com").then().assertThat().log().all().body("md5",
				equalTo("4ff1c9b1d1f23c6def53f957b1ed827f"));
		
		
		/*
			given().queryParam("text", "testcaseOne").when().get("http://md5.jsontest.com").then().assertThat().body("md5",
					equalTo("4ff1c9b1d1f23c6def53f957b1ed827f"));
		
			
			
			https://google.com?searchString="RestAssured"
				
			given().queryParam("searchString", "RestAssured").when().get("https://simple-tool-rental-api.glitch.me/tools").then().statusCode(200);

			https://simple-tool-rental-api.glitch.me/tools?searchString="RestAssured" & searchString="Java"
	
			given().queryParam("searchString", "RestAssured").queryParam("searchString", "java").when().get("https://simple-tool-rental-api.glitch.me/tools").then().statusCode(200);

			Map<String, String> h1=new HashMap<String,String>();
			h.put("searchString", "RestAssured");
			given().queryParams(h1).when().get("https://simple-tool-rental-api.glitch.me/tools").then().statusCode(200);
*/
	
	} 
	
	@Test
	public static void pathParam() {
		given().pathParam("countryCode", "us").pathParam("zipCode", "90210").log().all().when()
				.get("http://api.zippopotam.us/{countryCode}/{zipCode}").then().assertThat()
				.body("country", equalTo("United States"));

	}
	
	@Test //Example of multiple param
	public static void Param1() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("testData");
		list.add("my");
		given().param("id", "2").param("listparam", list).get("http://localhost:3000/posts").asString();
		
		given().param("id", "2").param("a", "test").param("listparam", list).get("http://localhost:3000/testDemo")
				.asString();
	}

}
