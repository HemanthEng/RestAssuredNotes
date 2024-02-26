package ProjectReqresTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TestCase6_DeleteProject2 {

	public static void main(String[] args) {
		
		
		Response delete = RestAssured.delete("https://reqres.in/api/users/2");
		
		//Step 3 : Provide Validation
		delete.then().log().all();
				int statusCode = delete.getStatusCode();
				Assert.assertEquals(204, statusCode);
				System.out.println("Yes Validation passs");
	}

}
