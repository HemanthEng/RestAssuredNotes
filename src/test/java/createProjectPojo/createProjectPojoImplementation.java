package createProjectPojo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;
import java.util.HashMap;

import org.json.simple.JSONObject;

import GenericUtils.JavaLibrary;
import PojoClassImplemantation.pojoClass;
import io.restassured.http.ContentType;

public class createProjectPojoImplementation {

	
	public static void main(String[] args) {

		baseURI = "http://rmgtestingserver";
		port = 8084;
		JavaLibrary jlib = new JavaLibrary();

		
		
		pojoClass pc = new pojoClass("Hemanth", "hayatarti"+jlib.getRandomNumber(), "ongoing", 11);
		// step 2 create a pre-condition
		given().body(pc).contentType(ContentType.JSON)
		// step 3 Actions
		.when().post("/addProject")
		// step 4 Validation
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
		
		/*
		 * { "msg": "Successfully Added", "createdBy": "Hemanth", "projectName":
		 * "hayatarti426", "projectId": "hayatarti125", "createdOn": "22/02/2024",
		 * "status": "ongoing" }
		 */
	}
}
