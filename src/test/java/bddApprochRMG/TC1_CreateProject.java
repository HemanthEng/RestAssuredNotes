package bddApprochRMG;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtils.JavaLibrary;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class TC1_CreateProject {

	
	@Test(priority=1, enabled=false)
	public void createProject1_Test() {
		// BDD approch

		// Step1 Make RestAssured class as static in importStatement aslo make it as
		// .* to create all method as static
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
	

		JavaLibrary jlib = new JavaLibrary();

		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Hemanth");
		jobj.put("projectName", "hayatArti" + jlib.getRandomNumber());
		jobj.put("status", "Active");
		jobj.put("teamSize", 12);

		// step 2 create a pre-condition
		given().body(jobj).contentType(ContentType.JSON)
				// step 3 Actions
				.when().post("/addProject")
				// step 4 Validation
				.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();

	}
	/*
	{
    "projectId": "TY_PROJ_13887",
    "projectName": "hayatArti36",
    "teamSize": 12,
    "createdBy": "Hemanth",
    "createdOn": "21/02/2024",
    "status": "Active"
     }
	 */
	
	@Test(priority=2, enabled=false)
	public void getAllProjects() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		when().get("/projects")
		.then().statusCode(200).log().all();
	}
	
	@Test(priority=3, enabled=false)
	public void getProjectID() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		when().get("/projects/TY_PROJ_13887")
		.then().statusCode(200).log().all();
	}
	
	@Test(priority=4, enabled=false)
	public void UpdateProject() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JavaLibrary jlib = new JavaLibrary();

		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Yash"); //name udpated from Hemanth to Yash
		jobj.put("projectName", "Toxic");
		jobj.put("status", "Active");
		jobj.put("teamSize", 111); //team size changed form 12 to 111

		// step 2 create a pre-condition
		given().body(jobj).contentType(ContentType.JSON)
		.when().get("/projects/TY_PROJ_13887")
		.then().statusCode(200).log().all();
	}
	
	@Test(priority=5, enabled=false)
	public void createProject2_Test() {
		// BDD approch

		// Step1 Make RestAssured class as static in importStatement aslo make it as
		// .* to create all method as static
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
	

		JavaLibrary jlib = new JavaLibrary();

		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "leoDass");
		jobj.put("projectName", "leo" + jlib.getRandomNumber());
		jobj.put("status", "Active");
		jobj.put("teamSize", 100);

		// step 2 create a pre-condition
		given().body(jobj).contentType(ContentType.JSON)
				// step 3 Actions
				.when().post("/addProject")
				// step 4 Validation
				.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
		System.out.println("Hemanth this is Project2");
		
		/*
		 * { "msg": "Successfully Added", "createdBy": "leoDass", "projectName":
		 * "leo288", "projectId": "TY_PROJ_13906", "createdOn": "21/02/2024", "status":
		 * "Active" }
		 */

	}
	
	@Test(priority=6)
	public void deleteProject2() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		when().delete("/projects/TY_PROJ_13906")
		.then().statusCode(204).log().all();
	}
	

}
