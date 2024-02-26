package rmgYantraProjectTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class getAllProjects {

	public static void main(String[] args) {
		
		
		Response response=RestAssured.get("http://rmgtestingserver:8084/projects");
		
		//Step 3 : Provide Validation
				response.then().log().all();
				int statusCode = response.getStatusCode();
				Assert.assertEquals(200, statusCode);
				System.out.println("Yes Validation passs");
	}

}
