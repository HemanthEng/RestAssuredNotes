package restAssured_Authentication;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtils.JavaLibrary;
import io.restassured.http.ContentType;
public class auth2 {

	@Test
	public void auth2zero()
	{
		JavaLibrary jlib = new JavaLibrary();
		JSONObject jobj=new JSONObject();
		jobj.put("name", "t20_20024"+jlib.getRandomNumber());
		
		given().auth().oauth2("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")
		.body(jobj).contentType(ContentType.JSON)
		.when().post("https://api.github.com/user/repos")
		.then().statusCode(201).log().all();
		
		
	}
}
