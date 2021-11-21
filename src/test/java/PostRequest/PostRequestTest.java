package PostRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class PostRequestTest {
	
	
	
	@Test
	public void postRequest() {
		
	    JSONObject obj = new JSONObject();
        obj.put("name", "Sumit");
        obj.put("age", 49);

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        
        given().contentType("application/json; charset=UTF-16").body(obj).post("http://localhost:3000/posts").then().statusCode(201);
		
		
	}
	

}
