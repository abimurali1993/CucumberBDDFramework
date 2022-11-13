package cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.commons.BaseActions;

/**
 * Common Page File
 * @author abimu
 *
 */
public class CommonPage extends BaseActions {

	WebDriver driver;

	public CommonPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@data-icon='user']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@data-name-pattern='Welcome NAME']")
	WebElement welcomeName;

	@FindBy(id = "navbarDropdown0")
	WebElement productsMenu;

	public void verify_login_button_is_displayed_in_the_header_section() {

		waitForElementClickable(10, loginBtn);

	}

	public void user_clicks_on_the_login_button_in_the_header_section() {

		moveToAndClick(loginBtn);

	}

	public int verify_user_name_is_displayed_in_the_header(String userName) {

		int softErrors=getTextAndVerifyContainsWithoutException(welcomeName, userName);
		return softErrors;

	}

	public void user_clicks_on_products_link_from_the_header_section() {
		normalClick(productsMenu);
	}

}
