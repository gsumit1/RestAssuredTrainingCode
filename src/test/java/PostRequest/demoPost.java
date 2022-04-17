package PostRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
public class demoPost {
	
public static void main(String[] arg )  {
		
		JSONObject obj=new JSONObject();
		
		obj.put("name", "Sumit");
		obj.put("place", "Noida");
		
		
		JSONArray list=new JSONArray();
		
		list.add("msg1");
		list.add("msg2");
		list.add("msg3");
		
		
		obj.put("messages",list);
		
		given().contentType("application/json").body(obj).when().post("http://localhost:3000/Posts")
		.then().assertThat().statusCode(201);
		
	
}
}
