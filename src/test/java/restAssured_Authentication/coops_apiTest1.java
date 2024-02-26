package restAssured_Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class coops_apiTest1 {

	
		@Test
		public void coopsAPI()
		{
			Response res = given()
			.formParam("client_id", "hayatArtiAPITESTING")
			.formParam("client_secret", "cba9f4de88c616e6312108aa0bcab7a7")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "http://hayatartiserver.com")
			.formParam("code", "authorization code")
			
			.when().post("http://coop.apps.symfonycasts.com/token");
			
			String accToken=res.jsonPath().get("access_token");
			
			System.out.println(accToken);
			
			given().auth().oauth2(accToken).pathParam("UserID", 4846)
			.when().post("http://coop.apps.symfonycasts.com/api/{UserID}/eggs-count")
			.then().log().all();
		}
	
	
}
