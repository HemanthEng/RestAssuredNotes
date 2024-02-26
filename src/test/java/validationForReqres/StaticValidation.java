package validationForReqres;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class StaticValidation {

    @Test
    public void staticResp() {
        // Pre-requisites
        int expData = 8; // The expected ID is 8 because we are fetching user 8
        baseURI = "https://reqres.in";
        
        // Actions
        Response resp = when().get(baseURI + "/api/users/8");
        
        // Validation
        int actData = resp.jsonPath().getInt("data.id");
        Assert.assertEquals(actData, expData);
        
        resp.then().assertThat().time(Matchers.lessThan(8000l),TimeUnit.MILLISECONDS).log().all();
    }
}

