package BasicConcept.log;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import org.testng.annotations.Test;

public class loggingDemo {
	
	String key = "PMAK-61f19b2ffe0a1f11f5e5d562-538d5aed280373c319a7f58652e776539";
	String baseUrl = "https://api.postman.com";

	 @Test
	    public void validate_status_code(){
	        given().baseUri(baseUrl).header("X-Api-Key",key).
	        when().log().ifValidationFails().
	                get("/workspaces").
	        then().
	                assertThat().log().ifError().
	                statusCode(200).body("workspaces.size", hasSize(3),
	                			"workspaces.name[0]",equalTo("MyWorkspace1"));
	    }

}
