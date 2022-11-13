package cucumber.stepDefinitions;

import cucumber.globals.Globals;
import cucumber.pages.CommonPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;

public class CommonSD {

	public Globals global;

	public CommonSD(Globals global) {

		this.global = global;

	}

	@Then("Verify login button is displayed in the header section")
	public void verify_login_button_is_displayed_in_the_header_section() {
		new CommonPage(global.driver).verify_login_button_is_displayed_in_the_header_section();
		global.takeScreenshot=true;
	}

	@When("User clicks on the login button in the header section")
	public void user_clicks_on_the_login_button_in_the_header_section() {
		new CommonPage(global.driver).user_clicks_on_the_login_button_in_the_header_section();
		
	}

	@Then("Verify user name {string} is displayed in the header")
	public void verify_user_name_is_displayed_in_the_header(String userName) {

		global.softErrors=new CommonPage(global.driver).verify_user_name_is_displayed_in_the_header(userName);
		global.takeScreenshot=true;
	}

	@When("User clicks on products link from the header section")
	public void user_clicks_on_products_link_from_the_header_section() {
		new CommonPage(global.driver).user_clicks_on_products_link_from_the_header_section();
		global.takeScreenshot=true;
	}

}