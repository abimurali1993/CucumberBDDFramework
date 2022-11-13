package cucumber.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import cucumber.commons.BaseActions;

public class ApplicationGlobal extends BaseActions {

	WebDriver driver;

	public ApplicationGlobal(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void verify_user_is_navigated_to_page_with_url(String pageName, String URL) throws IOException {
		verifyCurrentURL(URL);
	}

}
