package RequestChaining;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChainingFOrReq {


	@Test
	public void reqchain() {
		baseURI = "https://reqres.in/";
		
		int expData=9;

		Response resp =when().get("/api/users?page=2");
		
		List<Integer> list=resp.jsonPath().get("data.id");
		
		for(Integer getList:list)
		{
			if(getList==(expData))
			{
				when().get("/api/users/"+getList)
				.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
			}
		}
		
		
	}
}