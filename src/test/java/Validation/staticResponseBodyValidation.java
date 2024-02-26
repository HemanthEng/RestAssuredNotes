package Validation;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.port;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class staticResponseBodyValidation {

	@Test
	public void staticRespose()
	{
		//prerequisites
		String expData="tyss14990234";
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		//actions
		Response resp=when().get("/projects");
		
		//validation
		String actData=resp.jsonPath().get("[4].projectId");
		Assert.assertEquals(actData,expData);
		
		resp.then().assertThat().time(Matchers.lessThan(8000l),TimeUnit.MILLISECONDS).log().all();
		
	}
	
}
