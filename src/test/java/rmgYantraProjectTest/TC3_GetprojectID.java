package rmgYantraProjectTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TC3_GetprojectID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_13845");

		// Step 3 : Provide Validation
		response.then().log().all();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		System.out.println("Yes Project is Present");
	}

}
