package createProjectPojo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtils.JavaLibrary;
import io.restassured.http.ContentType;

public class jsonFilePassing {

	@Test
	public void createProj() {

		baseURI = "http://rmgtestingserver";
		port = 8084;
		//JavaLibrary jlib = new JavaLibrary();

		File f=new File("./jsonfilepass.json");
		
		// step 2 create a pre-condition
		given().body(f).contentType(ContentType.JSON)
		// step 3 Actions
		.when().post("/addProject")
		// step 4 Validation
		.then().assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
		
		
	}
}
