package BasicConcept.header;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;

public class Headers {
	
	String key="PMAK-61f19b2ffe0a1f11f5e5d562-538d5aed280373c319a7f58652e7765397";
	String baseUrl="https://api.postman.com";

    @Test
    public void validate_status_code(){
    	
    	/*
    	Map<String,String> m=new HashMap<String, String>();
    	
    	
    	m.put("X-Api-Key",key);
    	m.put("header","header1");
    	m.put("x-mock-match-request-headers","header");
    	*/
    	
    
    	Header header1=new Header("X-Api-Key",key);
    	Header header2=new Header("header","header1");
    	Header header3=new Header("x-mock-match-request-headers","header");
  
    	
    	
    	//Headers m=new Headers(header1,header2, header3);
    	
      
    }

}
