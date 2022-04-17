package BasicConcept.get;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class AutomateGet {
	
	String key="PMAK-61f19b2ffe0a1f11f5e5d562-538d5aed280373c319a7f58652e7765397";
	String baseUrl="https://api.postman.com";

    @Test
    public void validate_status_code(){
    	
    	given().baseUri(baseUrl).header("X-Api-Key",key).
    	when().get("/workspaces").
    	then().statusCode(200).
    	body("workspaces.name[0]", equalTo("MyWorkspace1"));
      	
    	/*
        given().baseUri(baseUrl).header("X-Api-Key",key).
        when().
                get("/workspaces").
        then().
                assertThat().
                statusCode(200).body(
                			"workspaces.name[0]",equalTo("MyWorkspace1"));*/
    }

     
    @Test
    public void validate_response_body(){
        given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", key).
        when().
                get("/workspaces").
        then().
                log().all().
                assertThat().
                statusCode(200).
                body("workspaces.name", hasItems("MyWorkspace1", "MyDemoWorkSpace","Training"),
                        "workspaces.type", hasItems("personal", "personal","personal"),
                        "workspaces[0].name", equalTo("MyWorkspace1"),
                        "workspaces[1].name", is(equalTo("MyDemoWorkSpace")),
                        "workspaces.size()", equalTo(3),
                        "workspaces.name", hasItem("MyDemoWorkSpace")
                );
    }

   

    @Test
    public void extract_response(){
        Response res = given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", key).
        when().
                get("/workspaces").
        then().
                assertThat().
                statusCode(200).
                extract().
                response();
        System.out.println("response = " + res.asString());
    }

    @Test
    public void extract_single_value_from_response(){
        String name = given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", key).
        when().
                get("/workspaces").
        then().
                assertThat().
                statusCode(200).
                extract().
                response().path("workspaces[0].name");
        System.out.println("workspace name = " + name);
   }

    @Test
    public void hamcrest_assert_on_extracted_response(){
        String name = given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", key).
        when().
                get("/workspaces").
        then().
                assertThat().
                statusCode(200).
                extract().
                response().path("workspaces[0].name");
        System.out.println("workspace name = " + name);

       // assertThat(name, equalTo("My Workspace"));
        //Assert.assertEquals(name, "My Workspace");
     }
}
