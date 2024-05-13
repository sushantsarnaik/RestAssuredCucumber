package StepDefinitions;

import io.cucumber.java.en.Given;

public class TestStep {
	
	@Given("Test one")
	public void test_one() {
		System.out.println("Test one step");
	}
	
	@Given("Test two")
	public void test_two() {
	    System.out.println("Test two step");
	}

}
