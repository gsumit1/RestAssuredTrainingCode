package BasicConcept.log;

import io.restassured.config.LogConfig;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class Logging {

	@Test
	public void request_response_logging() {
		given().baseUri("https://reqres.in/").log().all().when().get("/api/users/2").then().log().all().assertThat()
				.statusCode(200);
	}

	@Test
	public void log_only_if_error() {
		given().baseUri("https://api.postman.com")
				.header("X-Api-Key", "PMAK-5ff2d720d2a39a004250e5da-c658c4a8a1cee3516762cb1a51cba6c5e2").log().all()
				.when().get("/workspaces").then().log().ifError().assertThat().statusCode(200);
	}

	@Test
	public void log_only_if_validation_fails() {
		given().baseUri("https://reqres.in/")
				.config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).
				// log().ifValidationFails().
				when().get("/api/users/2").then().
				// log().ifValidationFails().
				assertThat().statusCode(201);
	}

}
