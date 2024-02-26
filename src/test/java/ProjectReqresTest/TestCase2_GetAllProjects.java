package ProjectReqresTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TestCase2_GetAllProjects {

	public static void main(String[] args) {

		//Step1 : Create a pre-requeisit
		//Step 2 : Perform the actions
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		//Step 3 : Provide Validation
		response.then().log().all();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		System.out.println("Yes Validation passs");

	}

}
