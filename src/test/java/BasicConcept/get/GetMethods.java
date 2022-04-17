package BasicConcept.get;

import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetMethods {
	String key = "PMAK-61f19b2ffe0a1f11f5e5d562-538d5aed280373c319a7f58652e7765397";
	String baseUrl = "https://api.postman.com";

	@Test
	public void extract_response() {

		Response res =

				given().baseUri(baseUrl).header("X-Api-Key", key).when().get("/workspaces").then().assertThat()
						.statusCode(200).extract().response();

		System.out.println(res.asString());
		
		
		
		

		for (Header h : res.getHeaders()) {
			System.out.println(h.getName() + "   " + h.getValue());

		}

	}
	
	@Test
	public void extract_string() {

		String name =

				given().baseUri(baseUrl).header("X-Api-Key", key).when().get("/workspaces").then().assertThat()
						.statusCode(200).extract().response().path("workspaces.type[1]");

		System.out.println(name);

		assertThat(name, equalTo("personal"));

	}

}
