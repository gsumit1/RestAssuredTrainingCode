package BasicConcept.header;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AutomateHeaders {

    @Test
    public void multiple_headers(){
        Header header = new Header("header", "header1");
               
        Header matchHeader = new Header("x-mock-match-request-headers", "header");
        
        given().
                baseUri("https://d2a58293-8341-42b7-84c1-75882c567109.mock.pstmn.io").
                header(header).
                header(matchHeader).
        when().
                get("/get").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }

    @Test
    public void multiple_headers_using_Headers(){
        Header header = new Header("header", "header1");
        Header matchHeader = new Header("x-mock-match-request-headers", "header");

        Headers headers = new Headers(header, matchHeader);

        given().
        		baseUri("https://d2a58293-8341-42b7-84c1-75882c567109.mock.pstmn.io").
                headers(headers).
        when().
                get("/get").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }

    @Test
    public void multiple_headers_using_map(){
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("header", "header1");
        headers.put("x-mock-match-request-headers", "header");

        given().
        		baseUri("https://d2a58293-8341-42b7-84c1-75882c567109.mock.pstmn.io").
                headers(headers).
        when().
                get("/get").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }

    @Test
    public void multi_value_header_in_the_request(){
        Header header1 = new Header("multiValueHeader", "header1");
        Header header2 = new Header("multiValueHeader", "header2");

        Headers headers = new Headers(header1, header2);

        given().
        		baseUri("https://d2a58293-8341-42b7-84c1-75882c567109.mock.pstmn.io").
     //           headers(headers).
                headers(headers).
                log().headers().
        when().
                get("/get").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }

    @Test
    public void assert_response_headers(){
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("header", "header1");
        headers.put("x-mock-match-request-headers", "header");

        given().
        		baseUri("https://d2a58293-8341-42b7-84c1-75882c567109.mock.pstmn.io").
                headers(headers).
        when().
                get("/get").
        then().
                assertThat().
                statusCode(200).
                headers("responseHeader", "resValue12",
                        "X-RateLimit-Limit", "120");
    }

    @Test
    public void extract_response_headers(){
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("header", "header1");
        headers.put("x-mock-match-request-headers", "header");

        Headers extractedHeaders = given().
                baseUri("https://d2a58293-8341-42b7-84c1-75882c567109.mock.pstmn.io").
                headers(headers).
        when().
                get("/get").
        then().
                assertThat().
                statusCode(200).
                extract().
                headers();
        /*
        for(Header header: extractedHeaders){
            System.out.print("header name = " + header.getName() + ", ");
            System.out.println("header value = " + header.getValue());
        }*/

        System.out.println("header name = " + extractedHeaders.get("responseHeader").getName());
        System.out.println("header value = " + extractedHeaders.get("responseHeader").getValue());
        
        
        
        
        
        //System.out.println("header value = " + extractedHeaders.getValue("responseHeader"));
    }

    @Test
    public void extract_multivalue_response_header(){
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("header", "header1");
        headers.put("x-mock-match-request-headers", "header");

        Headers extractedHeaders = given().
                baseUri("https://d2a58293-8341-42b7-84c1-75882c567109.mock.pstmn.io").
                headers(headers).
        when().
                get("/get").
        then().
                assertThat().
                statusCode(200).
                extract().
                headers();

        List<String> values = extractedHeaders.getValues("multiValueHeader");
        for(String value:values){
            System.out.println(value);
        }
    }
}
