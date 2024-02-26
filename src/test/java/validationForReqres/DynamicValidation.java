package validationForReqres;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.when;

public class DynamicValidation {

    @Test
    public void dynamicValidation() {
    	baseURI="https://reqres.in";
		int exceData = 9;
		Response reg = when().get("/api/users?page=2");
		boolean flag = false;
		List<Integer> name = reg.jsonPath().get("data.id");
	
		for (Integer eachname : name) {
			if(eachname.equals(exceData)) {
				flag = true;
				
			}
			
		}
		Assert.assertTrue(flag);
		System.out.println("data verfied");
		reg.then().assertThat().time(Matchers.lessThan(8000l),
				TimeUnit.MILLISECONDS).log().all();
		
    }
}
