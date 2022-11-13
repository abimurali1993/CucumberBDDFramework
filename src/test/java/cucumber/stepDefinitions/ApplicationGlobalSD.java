package cucumber.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import cucumber.globals.Globals;
import cucumber.pages.ApplicationGlobal;
import cucumber.resources.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ApplicationGlobalSD {

	public Globals global;

	public ApplicationGlobalSD(Globals global) {

		this.global = global;

	}

	@Given("User is in the homepage of similac.com application")
	public void user_is_in_the_homepage_of_similac_com_application() throws IOException {
		DriverManager manager = new DriverManager();
		global.driver = manager.launchApplication();
		global.takeScreenshot = false;
	}

	@Then("Verify user is navigated to {string} page with URL {string}")
	public void verify_user_is_navigated_to_page_with_url(String pageName, String URL) throws IOException {

		ApplicationGlobal applicationGlobal = new ApplicationGlobal(global.driver);
		applicationGlobal.verify_user_is_navigated_to_page_with_url(pageName, URL);
		global.takeScreenshot = true;

	}

	@Then("Evaluate the validations")
	public void evaluate_the_validations() {
		if (global.softErrors > 0) {
			Assert.assertTrue(false);
		}
	}

}
