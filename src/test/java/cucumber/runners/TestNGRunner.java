	package cucumber.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber/features",
glue="cucumber.stepDefinitions", tags= "@Homepage", monochrome = true, dryRun = false, plugin = {"html:target/cucmberReport.html","json:target/cucmberReport.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
/**
 * Test RUnner class
 * @author abimu
 *
 */
public class TestNGRunner extends AbstractTestNGCucumberTests {
	
	/*
	 * @Override
	 * 
	 * @DataProvider(parallel = true) public Object[][] scenarios() { return
	 * super.scenarios();
	 * 
	 * }
	 */
}
