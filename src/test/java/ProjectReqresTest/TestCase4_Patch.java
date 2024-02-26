package ProjectReqresTest;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase4_Patch {

	public static void main(String[] args) {
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Ammrutha");
	

		RequestSpecification update = RestAssured.given();
		update.body(jobj);
		update.contentType(ContentType.JSON);
		
		//Step 2 : Perform the Action
		
		Response response=update.patch("https://reqres.in/api/users/2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
		System.out.println(response.contentType());
		//System.out.println(response.prettyPrint());
		//System.out.println(response.prettyPeek());

	}

}
