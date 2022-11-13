package cucumber.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.commons.BaseActions;

/**
 * Homepage Page File
 * @author abimu
 *
 */
public class HomePage extends BaseActions {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By heroBanner = By.className("hero-content");

	public void verify_homepage_banner_is_displayed() {

		waitForElementPresence(10, heroBanner);

	}
}
