package cucumber.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.commons.BaseActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfilePage extends BaseActions {

	WebDriver driver;

	public ProfilePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[@class='personal-info__item-value mb-0']")
	WebElement profileEmail;

	public int verify_email_address_is_displayed_in_profile_section(String emailAddress) {
		int softErrors= getTextAndVerifyWithoutException(profileEmail, emailAddress);
		return softErrors;
	}
}
