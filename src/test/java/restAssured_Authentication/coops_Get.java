package restAssured_Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
 public class coops_Get {

			@Test
			public void gettest()
			{
			when().get("http://coop.apps.symfonycasts.com/authorize")
			.then().log().all();
			}
}
