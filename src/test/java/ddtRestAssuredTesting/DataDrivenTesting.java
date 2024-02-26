package ddtRestAssuredTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import GenericUtils.JavaLibrary;
import PojoClassImplemantation.pojoClass;
import io.restassured.http.ContentType;

public class DataDrivenTesting {

		@DataProvider(name="getData")
		public Object[][] data()
		{
			Object[][] data=new Object[3][4];
			
			data[0][0]="hemanth";
			data[0][1]="tutorial";
			data[0][2]="OnGoing";
			data[0][3]=9;
			
			data[1][0]="Amrutha";
			data[1][1]="College";
			data[1][2]="OnGoing";
			data[1][3]=13;
			
			data[2][0]="Surabhi";
			data[2][1]="nursury";
			data[2][2]="OnGoing";
			data[2][3]=11;
		
		return data;
	}
		
		@Test(dataProvider="getData")
		public void ddt(String createdBy,String projectName,String status,int teamSize)
		{
			JavaLibrary  jlib=new JavaLibrary();
			pojoClass cp=new pojoClass(createdBy,projectName+jlib.getRandomNumber(),status,teamSize);
			baseURI="http://rmgtestingserver";
			port=8084;
		
			given()
			.body(cp)
			.contentType(ContentType.JSON)
			
			//Actions
			.when()
			.post("/addProject")
			
			//validation
			.then().log().all();
		
		}
}
