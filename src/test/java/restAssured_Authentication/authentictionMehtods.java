package restAssured_Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class authentictionMehtods {
	
		@Test
		public void basicAuth()
		{
			
			given().auth().basic("rmgyantra","rmgy@9999") //usn and psw of the application
			.when().get("hhtps://rmgtestingserver:8084/login") //url
			.then().log().all(); 
	    }
		
		@Test
		public void preemptive()
		{
			//when there is no mandatory to entery usn and psw agian and again for example: flipkart
			given().auth().preemptive().basic("rmgyantra","rmgy@9999") //usn and psw of the application
			.when().get("hhtps://rmgtestingserver:8084/login") //url
			.then().log().all(); 
	    }
		
		@Test
		public void digestiveAuth()
		{
			//when it is mandatory to enter the usn and psw everytime to open the application 
			given().auth().digest("rmgyantra","rmgy@9999") //usn and psw of the application
			.when().get("hhtps://rmgtestingserver:8084/login") //url
			.then().log().all(); 
	    }
}
