package StepDefinitions;

import Utilities.RestAssuredBase;
import io.cucumber.java.en.Given;

public class TestStep {
	
	RestAssuredBase base=new RestAssuredBase();
	
	@Given("Test one")
	public void test_one() {
		System.out.println("Test one step");
	}
	
	@Given("Test two")
	public void test_two() {
	    base.loadProperties();
	}

}
