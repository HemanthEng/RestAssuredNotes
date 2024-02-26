package Validation;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class dynamicResponseValidation {
	
	@Test
	public void dynamicRes()
	{
		//prerequisites
				String expData="TY_PROJ_13845";
				baseURI = "http://rmgtestingserver";
				port = 8084;
				
				//actions
				Response resp=when().get("/projects");
				
				//validation
				boolean flag=false;
				
				List<String> pID=resp.jsonPath().get("projectId");
				
				for(String projectID:pID)
				{
					if(projectID.equalsIgnoreCase(expData))
					{
						flag=true;
					}
				}
				Assert.assertTrue(flag);
				System.out.println("data verified");
				resp.then().assertThat().time(Matchers.lessThan(8000l),TimeUnit.MILLISECONDS).log().all();
				
				
	}
}
