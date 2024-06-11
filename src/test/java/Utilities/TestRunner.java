package Utilities;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.EXECUTION_DRY_RUN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/test/java/StepDefinitions")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value="StepDefinitions")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value="src/test/resources/Features")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME,value = "@getListUser1")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME,value = "false")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/cucumber.html")




public class TestRunner {

}
