package BasicConcept.SSL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class sslValidation {
	
	
	@Test
	public void ssl_validation() {
		
		String response = 
				given().get("https://jsonplaceholder.typicode.com/photos/1")
				.then()
				.contentType(ContentType.JSON)
				.extract()
				.path("url");
		System.out.println(response.toString());
		given().relaxedHTTPSValidation().get(response).then().statusCode(200);
		
		
		
		
	}

}
