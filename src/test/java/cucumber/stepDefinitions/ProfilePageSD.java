package cucumber.stepDefinitions;

import cucumber.globals.Globals;
import cucumber.pages.ProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfilePageSD {

	public Globals global;

	public ProfilePageSD(Globals global) {

		this.global = global;

	}

	@Then("Verify email address {string} is displayed in profile section")
	public void verify_email_address_is_displayed_in_profile_section(String emailAddress) {
		global.softErrors=new ProfilePage(global.driver).verify_email_address_is_displayed_in_profile_section(emailAddress);
		global.takeScreenshot=true;

	}

}
