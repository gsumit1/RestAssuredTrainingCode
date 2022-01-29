package BasicConcept.get;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class A_getMethod {
	
	@Test 
	public  void example1() {
		
		given()
		.when()
		.then();
		given().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200);
	}


}
