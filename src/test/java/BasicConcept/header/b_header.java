package BasicConcept.header;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class b_header {
	
	@Test
	public void gerHeader() {
		
		
	Response response=given().get("https://jsonplaceholder.typicode.com/posts");
	

	for(Header a:response.getHeaders()) {
		
		System.out.println(a.getName()+" --------"+a.getValue());
		
	}
		
		
	}

}
