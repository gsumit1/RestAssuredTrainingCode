package BasicConcept.get;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class A_getMethod1 {
	
	//@Test
	public void getTest() {
		given().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200);		
	}
	
	@Test
	public void getTestLog() {
		given().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200).log().all();		
	}
	

}
