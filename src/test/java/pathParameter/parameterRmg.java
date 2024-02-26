package pathParameter;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class parameterRmg {

	
	@Test
	public void pathParameter()
	{
		given().pathParam("pid", "TY_PROJ_-1325218320")
		.when().get("http://rmgtestingserver:8084/projects/{pid}")
		.then().assertThat().statusCode(200).log().all();
	}
	
	@Test
	public void queryParameter()
	{
		given().queryParam("page", 2)
		.when().get("https://reqres.in/api/users")
		.then().assertThat().statusCode(200).log().all();
	}
	
	@Test
	public void formParameter()
	{
		given()
		.formParam("createdBy", "Amrutha")
		.formParam("projectName", "tution")
		.formParam("status", "ongoing")
		.formParam("teamSize", 7)
		.when().post("http://rmgtestingserver:8084/addProject")
		.then().assertThat().statusCode(200).log().all();
	}
	//note : form parameter wont work because only when developer mention in swagger doc it will work
}
