package Performance;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;
public class performanceTest {
	
	@Test
	
	public void test1() {
		
		given().get("https://jsonplaceholder.typicode.com/posts").then().time(lessThan(1000L));
	
		
		
		
	}
	
	

}
