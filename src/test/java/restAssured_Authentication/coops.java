package restAssured_Authentication;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class coops {

	@Test
	public void coopsAPI()
	{
		given()
		.formParam("client_id", "hayatArtiAPITESTING")
		.formParam("client_secret", "cba9f4de88c616e6312108aa0bcab7a7")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://hayatartiserver.com")
		.formParam("code", "authorization code")
		
		
		.when().post("http://coop.apps.symfonycasts.com/token")
		.then().log().all();
	}
}
