package BasicConcept.get;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AutomateGet {

    @Test
    public void validate_status_code(){
        given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", "PMAK-5ff2d720d2a39a004250e5da-c658c4a8a1cee3516762cb1a51cba6c5e2").
        when().
                get("/workspaces").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }

   @Test
    public void validate_response_body(){
        given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", "PMAK-5ff2d720d2a39a004250e5da-c658c4a8a1cee3516762cb1a51cba6c5e2").
        when().
                get("/workspaces").
        then().
                log().all().
                assertThat().
                statusCode(200).
                body("workspaces.name", hasItems("Team Workspace", "My Workspace", "My Workspace2"),
                        "workspaces.type", hasItems("team", "personal", "personal"),
                        "workspaces[0].name", equalTo("Team Workspace"),
                        "workspaces[0].name", is(equalTo("Team Workspace")),
                        "workspaces.size()", equalTo(3),
                        "workspaces.name", hasItem("Team Workspace")
                );
    }

    @Test
    public void validate_response_body_hamcrest_learnings(){
        given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", "PMAK-5ff2d720d2a39a004250e5da-c658c4a8a1cee3516762cb1a51cba6c5e2").
        when().
                get("/workspaces").
        then().
 //               log().all().
                assertThat().
                statusCode(200).
                body("workspaces.name", containsInAnyOrder("Team Workspace", "My Workspace2", "My Workspace"),
                        "workspaces.name", is(not(emptyArray())),
                        "workspaces.name", hasSize(3),
 //                       "workspaces.name", everyItem(startsWith("My"))
                        "workspaces[0]", hasKey("id"),
                        "workspaces[0]", hasValue("Team Workspace"),
                        "workspaces[0]", hasEntry("id", "52bfb725-5a1a-4c38-8c05-24343951d389"),
                        "workspaces[0]", not(equalTo(Collections.EMPTY_MAP)),
                        "workspaces[0].name", allOf(startsWith("Team"), containsString("Workspace"))
                );
    }

    @Test
    public void extract_response(){
        Response res = given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", "PMAK-5ff2d720d2a39a004250e5da-c658c4a8a1cee3516762cb1a51cba6c5e2").
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
                header("X-Api-Key", "PMAK-5ff2d720d2a39a004250e5da-c658c4a8a1cee3516762cb1a51cba6c5e2").
        when().
                get("/workspaces").
        then().
                assertThat().
                statusCode(200).
                extract().
                response().path("workspaces[0].name");
        System.out.println("workspace name = " + name);
     //   System.out.println("workspace name = " + JsonPath.from(res).getString("workspaces[0].name"));
    //    System.out.println("workspace name = " + jsonPath.getString("workspaces[0].name"));
    //    System.out.println("workspace name = " + res.path("workspaces[0].name"));
    }

    @Test
    public void hamcrest_assert_on_extracted_response(){
        String name = given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", "PMAK-5ff2d720d2a39a004250e5da-c658c4a8a1cee3516762cb1a51cba6c5e2").
        when().
                get("/workspaces").
        then().
                assertThat().
                statusCode(200).
                extract().
                response().path("workspaces[0].name");
        System.out.println("workspace name = " + name);

     //   assertThat(name, equalTo("Team Workspace1"));
        Assert.assertEquals(name, "Team Workspace1");
        //   System.out.println("workspace name = " + JsonPath.from(res).getString("workspaces[0].name"));
        //    System.out.println("workspace name = " + jsonPath.getString("workspaces[0].name"));
        //    System.out.println("workspace name = " + res.path("workspaces[0].name"));
    }
}
