package BasicConcept.validations;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class validation {
	
	//@Test 
	public  void example0() {
		given().get("https://jsonplaceholder.typicode.com/posts/1").then()
		.body("title",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));

	}
	
	//@Test
	public  void example01() {
		given().get("https://jsonplaceholder.typicode.com/posts/1").then()
		.body("userId",equalTo(1));

	}
	
	
	@Test
	public void example2() {
		when().
		get("http://localhost:3000/store").
		then().
		body("book[0].author", equalTo("Nigel Rees"));}
	
	@Test
	public void example3() {
		when().
		get("http://localhost:3000/store").
		then().
		body("book.author[0]", equalTo("Nigel Rees"));}
	
	@Test
	public void example4() {
		when().
		get("http://localhost:3000/store").
		then().
		body("book[-1].category", equalTo("fiction"));	}

	@Test
	public void example5() {
		when()
		.get("http://localhost:3000/store")
		.then()
		.body("book.findAll { it.price < 10 }.title", hasItems("Sayings of the Century", "Moby Dick"));

		}

}
