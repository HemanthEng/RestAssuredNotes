package RequestChaining;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import GenericUtils.JavaLibrary;
import PojoClassImplemantation.pojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class requestChainingClass {

	@Test
	public void reqchain() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JavaLibrary jlib = new JavaLibrary();

		pojoClass cp = new pojoClass("Hemannt", "projectNameYantra"+jlib.getRandomNumber(), "Not Active", 13);

		Response resp = given().body(cp).contentType(ContentType.JSON)

				// Actions
				.when().post("addProject");

		String ProjectId = resp.jsonPath().get("projectId");

		System.out.println(ProjectId+"======>This is the Project id");

		// validation
		resp.then().log().all();
		// create one request(get single project)
		given().pathParam("pid", ProjectId)
		.when().get("/projects/{pid}")
		.then().assertThat().statusCode(200).log().all();

	}
}
