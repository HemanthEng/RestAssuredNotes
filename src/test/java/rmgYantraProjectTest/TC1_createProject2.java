package rmgYantraProjectTest;

import org.json.simple.JSONObject;

import GenericUtils.JavaLibrary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC1_createProject2 {

	public static void main(String[] args) {
		//rmgtestingserver:8084/

		 JavaLibrary lib= new JavaLibrary();

			// Step 1 : Create the Pre-Request - Requestbody means given method
			
			JSONObject jobj = new JSONObject();
			jobj.put("createdBy", "Yash");
			jobj.put("projectName", "Toxic"+lib.getRandomNumber());
			jobj.put("status", "Active");
			jobj.put("teamSize", 111);

			RequestSpecification given = RestAssured.given();
			given.body(jobj);
			given.contentType(ContentType.JSON);
			
			//Step 2 : Perform the Action
			
			Response response=given.post("http://rmgtestingserver:8084/addProject");
			
			System.out.println(response.getStatusCode());
			System.out.println(response.asString());
			
			System.out.println(response.contentType());
			System.out.println(response.prettyPeek());
			//System.out.println(response.prettyPrint());
			//System.out.println(response.prettyPeek());
		//output: 201
			/*
			{
    "msg": "Successfully Added",
    "createdBy": "Yash",
    "projectName": "Toxic133",
    "projectId": "TY_PROJ_13862",
    "createdOn": "21/02/2024",
    "status": "Active"
}
			}*/
			
	}

}
