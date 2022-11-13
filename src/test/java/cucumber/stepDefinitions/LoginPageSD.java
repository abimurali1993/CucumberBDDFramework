package cucumber.stepDefinitions;

import cucumber.globals.Globals;
import cucumber.pages.CommonPage;
import cucumber.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSD {

	public Globals global;

	public LoginPageSD(Globals global) {

		this.global = global;

	}

	@Then("Verify the login popup window is displayed")
	public void verify_the_login_popup_window_is_displayed() {

		new LoginPage(global.driver).verify_the_login_popup_window_is_displayed();
		global.takeScreenshot=true;

	}

	@When("User provides email address {string} and password {string} and clicks on sign in button")
	public void user_provides_email_address_and_password_and_clicks_on_sign_in_button(String email, String password) {
		new LoginPage(global.driver).user_provides_email_address_and_password_and_clicks_on_sign_in_button(email,
				password);
		global.takeScreenshot=true;

	}

	@When("Verify appropriate error message is displayed for {string} field")
	public void verify_appropriate_error_message_is_displayed_for_field(String field) {
		new LoginPage(global.driver).verify_appropriate_error_message_is_displayed_for_field(field);
		global.takeScreenshot=true;

	}

}
