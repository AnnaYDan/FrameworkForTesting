package utilities;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/java/features" }
,glue = {"stepDefinitions"}
,plugin = {"pretty", "html:target/cucumber"}
//,dryRun = true
		)

@Test
public class TestRunner extends AbstractTestNGCucumberTests {

}
