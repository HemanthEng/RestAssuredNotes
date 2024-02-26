package ProjectReqresTest;

import org.json.simple.JSONObject;

import GenericUtils.JavaLibrary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase1_CreateProject {

	public static void main(String[] args) {

		 JavaLibrary lib= new JavaLibrary();

		// Step 1 : Create the Pre-Request - Requestbody means given method
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Hemanth"+lib.getRandomNumber());
		jobj.put("job", "SDET");
	

		RequestSpecification given = RestAssured.given();
		given.body(jobj);
		given.contentType(ContentType.JSON);
		
		//Step 2 : Perform the Action
		
		Response response=given.post("https://reqres.in/api/users");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
		System.out.println(response.contentType());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());
		
	}

}
