package bDDapprochReqresProject;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtils.JavaLibrary;
import io.restassured.http.ContentType;

public class Tc1 {

	@Test(priority=1)
	public void CreateProject()
	{
		// Step 1 : Create the Pre-Request - Requestbody means given method
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Hemanth");
		jobj.put("job", "SDET");
		

		// step 2 create a pre-condition
		given().body(jobj).contentType(ContentType.JSON)
				// step 3 Actions
				.when().post("https://reqres.in/api/users")
				// step 4 Validation
				.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}
	
	@Test(priority=2)
	public void getAllProjects()
	{
		when().get("https://reqres.in/api/users?page=2")
		.then().statusCode(200).contentType(ContentType.JSON).log().all();
	}
	
	@Test(priority=3)
	public void updateput()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Yash");
		jobj.put("job", "QualityAnalist");
		
		when().put("https://reqres.in/api/users/2")
		.then().statusCode(200).contentType(ContentType.JSON).log().all();
	}
	@Test(priority=4)
	public void patch()
	{
		
		JSONObject jobj = new JSONObject();
		jobj.put("job", "Acting");
		
		when().patch("https://reqres.in/api/users/2")
		.then().statusCode(200).contentType(ContentType.JSON).log().all();
	}
	
	@Test(priority=5)
	public void CreateProject2()
	{
		

		// Step 1 : Create the Pre-Request - Requestbody means given method
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Amrutha");
		jobj.put("job", "Teacher");
		
		given().body(jobj).contentType(ContentType.JSON)
		// step 3 Actions
		.when().post("https://reqres.in/api/users")
		// step 4 Validation
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}
	@Test(priority=6)
	public void deleteProject2()
	{
		
			when().delete("https://reqres.in/api/users/2")
			.then().statusCode(204).log().all();

	}
}
