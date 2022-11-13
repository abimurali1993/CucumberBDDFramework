package cucumber.stepDefinitions;

import cucumber.globals.Globals;
import cucumber.pages.HomePage;
import io.cucumber.java.en.Then;

public class HomePageSD {

	public Globals global;

	public HomePageSD(Globals global) {
		this.global = global;
	}

	@Then("Verify homepage banner is displayed")
	public void verify_homepage_banner_is_displayed() {

		new HomePage(global.driver).verify_homepage_banner_is_displayed();
		global.takeScreenshot=true;

	}

}
