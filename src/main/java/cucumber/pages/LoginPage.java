package cucumber.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.CaseFormat;

import cucumber.commons.BaseActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage extends BaseActions {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "react-form-field-loginID")
	WebElement userNameField;

	@FindBy(id = "react-form-field-password")
	WebElement passwordField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtn;

	@FindBy(className = "invalid-feedback")
	WebElement emailError;

	By loader = By.className("pie");

	@Then("Verify the login popup window is displayed")
	public void verify_the_login_popup_window_is_displayed() {
		waitForElementClickable(10, userNameField);
	}

	@When("User provides email address {string} and password {string} and clicks on sign in button")
	public void user_provides_email_address_and_password_and_clicks_on_sign_in_button(String email, String password) {
		sendText(userNameField, email);
		sendText(passwordField, password);
		normalClick(signInBtn);
		waitForElementInvisible(10, loader);
	}

	@When("Verify appropriate error message is displayed for {string} field")
	public void verify_appropriate_error_message_is_displayed_for_field(String field) {

		switch (field) {
		case "emailAddress":

			waitForElementPresence(10, emailError);

			break;

		case "password":
			waitForElementPresence(10, emailError);

			break;
		}

	}
}
