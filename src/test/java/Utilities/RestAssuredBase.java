package Utilities;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAssuredBase {

	Properties configProperties;
	Logger logger;
	Response response;

	public RestAssuredBase() {
		logger = LogManager.getLogger(RestAssuredBase.class);
		
		loadProperties();
	}
	
	/**
	 * Method to initialise baseURI from config.properties file
	 */
	public void initialiseBaseURI() {
		try {
			baseURI=configProperties.getProperty("BaseURI");
		}catch(Exception e) {
			fail("Fail to initialise baseURI, Error :" + e.getMessage());
			logger.info("Fail to initialise baseURI, Error :" + e.getMessage());
		}
	}

	/**
	 * method used to load configuration properties from config.properties file
	 */
	public void loadProperties() {
		try {
			logger.info("Into load properties method");
			configProperties = new Properties();
			configProperties.load(new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/Config/config.properties"));
			logger.info("Config properties loaded successfully");
		} catch (Exception e) {
			fail("Fail to load properties, Error :" + e.getMessage());
			logger.info("Fail to load properties, Error :" + e.getMessage());
		}
	}
	
	/**
	 * Method to hit getListUsers API
	 */
	public void hitApiGetListUsers() {
		try {
			logger.info("Into hit api get list users method");
			initialiseBaseURI();
			response=given().get(configProperties.getProperty("listUsers.path"));
			logger.info("triggered getListUser api, Response :"+response.asPrettyString());
			System.out.println("triggered getListUser api, Response :"+response.asPrettyString());
		}catch(Exception e) {
			fail("Fail to hit get list user API, Error :" + e.getMessage());
			logger.info("Fail to hit get list user API, Error :" + e.getMessage());
		}
	}
	
	/**
	 * @description - Method to validate specific field from response
	 * @param fieldPath - json path of the field you want to validate value.
	 */
	public void validateFieldFromResponse(String fieldPath, String expectedValue) {
		try {
			logger.info("Validating specific field from the response.");
			JsonPath jsonPath=new JsonPath(response.asPrettyString());
			assertEquals(expectedValue, jsonPath.getString(fieldPath));
		}catch (Exception e) {
			fail("Fail to validate field value from response, Field Path :"+fieldPath+", Error :" + e.getMessage());
			logger.info("Fail to validate field value from response, Field Path :"+fieldPath+", Error :" + e.getMessage());
		}
	}

}
