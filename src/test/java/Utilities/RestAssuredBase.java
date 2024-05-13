package Utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.util.Properties;

public class RestAssuredBase {

	Properties configProperties;

	public RestAssuredBase() {
		loadProperties();
	}

	/**
	 * method used to load configuration properties from config.properties file
	 */
	public void loadProperties() {
		try {
			configProperties = new Properties();
			configProperties.load(new FileInputStream(
					System.getProperty("user.dir") + "src/test/resources/Config/config.properties"));
		} catch (Exception e) {
			fail("Fail to load properties, Error :" + e.getMessage());
		}
	}
	
	
	

}
