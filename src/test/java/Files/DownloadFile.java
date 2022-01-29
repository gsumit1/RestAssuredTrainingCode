package Files;

import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.given;

public class DownloadFile {

	//https://github.com/appium/appium/blob/master/sample-code/apps/ApiDemos-debug.apk
	
    @Test
    public void download_file() throws IOException {
        byte[] bytes = given().
                baseUri("https://raw.githubusercontent.com").
                log().all().
        when().
                get("/appium/appium/master/sample-code/apps/ApiDemos-debug.apk").
        then().
                log().all().
                extract().
                response().asByteArray();

        OutputStream os = new FileOutputStream(new File("ApiDemos-debug.apk"));
        os.write(bytes);
        os.close();
    }
}
