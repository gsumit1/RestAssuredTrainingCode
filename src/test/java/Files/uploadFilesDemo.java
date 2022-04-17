package Files;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.testng.annotations.Test;

public class uploadFilesDemo {
		@Test
		public void upload() {
			given().baseUri("https://postman-echo.com").multiPart("file", new File(".//demo.json")).log().all().when()
					.post("/post").then().log().all().assertThat().statusCode(200);
		}
		
		
		@Test
		public void download() throws IOException {
					byte[] bytes=
					given().baseUri("https://raw.githubusercontent.com").log().all().when()
					.get("/appium/appium/master/sample-code/apps/ApiDemos-debug.apk").then().log().all()
					.extract().response().asByteArray();
					
					
					
					OutputStream os=new FileOutputStream(new File("downlaoded.apk"));
					os.write(bytes);
					os.close();
			
			
			
			
					
					
			
			
			
			
			
		}

	}


