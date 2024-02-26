package rmgYantraProjectTest;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC4_PUT {

	public static void main(String[] args) {
		
		JSONObject jobj=	new JSONObject();
		jobj.put("createdBy", "AmruthaEarlierItwasHemanth");
		jobj.put("projectName", "hayatArti386");
		jobj.put("status", "Active");
		jobj.put("teamSize", 21); // team size also updates earlier it was 12
		
		RequestSpecification update = RestAssured.given();
		update.body(jobj);
		update.contentType(ContentType.JSON);
		
		Response response = update.put("http://rmgtestingserver:8084/projects/TY_PROJ_13845");
		
		response.then().log().all();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		System.out.println("Yes Updated Hemanth");
		
		

	}

}
