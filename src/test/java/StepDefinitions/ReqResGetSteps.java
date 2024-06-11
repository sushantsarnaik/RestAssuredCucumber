package StepDefinitions;

import Utilities.RestAssuredBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ReqResGetSteps {
	RestAssuredBase base=new RestAssuredBase();
	
	@Given("User hits reqRes get list users api")
	public void userHitsReqResGetListUsersAPI() {
	    base.hitApiGetListUsers();
	}
	
	@Then("User validates field {string} from response with value {string}")
	public void user_validates_field_from_response_with_value(String fieldPath, String expectedValue) {
	    base.validateFieldFromResponse(fieldPath, expectedValue);
	}

}
