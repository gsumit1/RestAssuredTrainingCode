package BasicConcept.parameter;

import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class c_parameter {
	
	
	public void queryparameter() {
			given().queryParam("text", "testcaseOne").when().get("http://md5.jsontest.com").then().assertThat().body("md5",
					equalTo("7489a25fc99976f06fecb807991c61cf"));
		

	} 
	
	
	public static void pathParam() {
		given().pathParam("countryCode", "ca").pathParam("zipCode", "90210").when()
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
