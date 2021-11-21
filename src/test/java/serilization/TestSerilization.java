package serilization;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
public class TestSerilization {
	
	
	//@Test
	public void testSerilization() {
		
		Address a=new Address("251","Sumit1","Tester1");
		
		given().contentType(ContentType.JSON).body(a).when().post("http://localhost:3000/posts").then().statusCode(201);
		
		
		
	}
	
	@Test
	public void testDeserilization() {
		
		
	Address a=given().contentType(ContentType.JSON).when().get("http://localhost:3000/posts?id=251").as(Address.class);
		System.out.println(a.getName());
	}
	
	
	
	

}
