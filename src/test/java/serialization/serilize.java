package serialization;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClassImplemantation.Employee;

public class serilize {

	
	@Test
	public void empSer() throws Throwable, JsonMappingException, IOException {
		
		int [] phoneNumber= {9321,4567};
		
		ObjectMapper omap= new ObjectMapper(); //from jackson mapper
		Employee emp=new Employee("Hemanth",phoneNumber,31);
		omap.writerWithDefaultPrettyPrinter().writeValue(new File("./hemanth.json"), emp);
	}
}
