package BasicConcept.get;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class A_getMethod {
	
	@Test 
	public  void example1() {
	
		given().when().get("https://simple-tool-rental-api.glitch.me/tools").then().statusCode(200);
		
		given().when().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200);
		
		int status=given().when().get("https://simple-tool-rental-api.glitch.me/tools").then().extract().statusCode();
		
		System.out.println(status);
		//given().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200);
	}


}

