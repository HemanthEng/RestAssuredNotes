package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import PojoClassImplemantation.Employee;

public class deserialization {

	@Test
	public void empDeserialization() throws Throwable, Throwable, Throwable{

		ObjectMapper omap= new ObjectMapper(); //from jackson mapper
		Employee data=omap.readValue(new File("./hemanth.json"), Employee.class);
		System.out.println("createdBy===>"+data.getCreatedBy());
		System.out.println("Age===>"+data.getAge());
		System.out.println("Age===>"+data.getPhoneNumber()[1]);
		
	
	}
}
