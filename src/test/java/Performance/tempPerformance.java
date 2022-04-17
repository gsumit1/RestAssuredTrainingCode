package Performance;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;


import org.testng.annotations.Test;

public class tempPerformance {
	
	String key="PMAK-61f19b2ffe0a1f11f5e5d562-538d5aed280373c319a7f58652e7765397";
	String baseUrl="https://api.postman.com";

    @Test
    public void validate_status_code(){
        given().baseUri(baseUrl).header("X-Api-Key",key).
        when().
                get("/workspaces").
        then().
                assertThat().
                statusCode(200).time(lessThan(30L));
    }

}
