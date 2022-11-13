package cucumber.commons;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.resources.PropertyReader;

/**
 * Base Actions class has all selenium action wrapper methods
 * @author abimu
 *
 */
public class BaseActions extends Utilities {

	// Creating local instance of WebDriver
	WebDriver driver;

	// Creating a construcor to get the latest driver and to pass it on to
	// Utilities.java
	public BaseActions(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	/**
	 * Method to get the current application URL Private
	 * 
	 * @return URL
	 * @throws IOException
	 */
	private String getApplicationURL() throws IOException {
		PropertyReader reader = new PropertyReader();
		String environment = reader.readPropertyValue("global", "Environment");
		String URL = null;
		if (environment.equalsIgnoreCase("PROD"))
			URL = reader.readPropertyValue("global", "PROD_URL");
		else if (environment.equalsIgnoreCase("STAGE"))
			URL = reader.readPropertyValue("global", "STAGE_URL");
		else if (environment.equalsIgnoreCase("QA"))
			URL = reader.readPropertyValue("global", "QA_URL");
		else if (environment.equalsIgnoreCase("DEV"))
			URL = reader.readPropertyValue("global", "DEV_URL");

		return URL;
	}

	/**
	 * Method to check if the element is selected Private
	 * 
	 * @param timeout
	 * @param element
	 * @return boolean value
	 */
	private boolean isSelected(int timeout, WebElement element) {
		waitForElementPresence(timeout, element);
		return element.isSelected();

	}

	/**
	 * Method to get the URL from the feature file and verify against the current
	 * URL
	 * 
	 * @param URL
	 * @throws IOException
	 */
	public void verifyCurrentURL(String URL) throws IOException {

		String expectedURL = getApplicationURL() + URL;
		waitForURL(10, expectedURL);
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, expectedURL);

	}

	/**
	 * Method to get the title from the feature file and verify against the current
	 * title
	 * 
	 * @param title
	 * @throws IOException
	 */
	public void verifyCurrentTitle(String title) throws IOException {

		String expectedtitle = title;
		String currenttitle = driver.getTitle();
		softAssertEquals(currenttitle, expectedtitle);

	}

	/**
	 * Method to perform click on the application after waiting for 5 seconds
	 * 
	 * @param element
	 */
	public void normalClick(WebElement element) {
		waitForElementClickable(5, element);
		element.click();

	}

	/**
	 * Method to perform click on the application after waiting for 5 seconds using
	 * Keyboard ENTER
	 * 
	 * @param element
	 */
	public void ClickwithEnter(WebElement element) {
		waitForElementClickable(5, element);
		element.sendKeys(Keys.ENTER);

	}

	/**
	 * Method to send value to a text box in the application after waiting for the
	 * element for 5 seconds
	 * 
	 * @param element
	 * @param value
	 */
	public void sendText(WebElement element, String value) {
		waitForElementClickable(5, element);
		element.sendKeys(value);

	}

	/**
	 * Method to perform click on the application after moving to the element post
	 * waiting for 5 seconds
	 * 
	 * @param element
	 */
	public void moveToAndClick(WebElement element) {
		waitForElementClickable(5, element);
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}

	/**
	 * Method to move to an element
	 * 
	 * @param element
	 */
	public void hoverToElement(WebElement element) {
		waitForElementClickable(5, element);
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	/**
	 * Method to double click on a element
	 * 
	 * @param element
	 */
	public void doubleClick(WebElement element) {
		waitForElementClickable(5, element);
		Actions act = new Actions(driver);
		act.moveToElement(element).doubleClick(element).build().perform();
	}

	/**
	 * Method to perform context click on a element
	 * 
	 * @param element
	 */
	public void rightClick(WebElement element) {
		waitForElementClickable(5, element);
		Actions act = new Actions(driver);
		act.moveToElement(element).contextClick(element).build().perform();
	}

	/**
	 * Method to select using text in dropdown
	 * 
	 * @param element
	 * @param text
	 */
	public void selectByVisibleText(WebElement element, String text) {
		waitForElementClickable(5, element);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
	}

	/**
	 * Method to select using value in dropdown
	 * 
	 * @param element
	 * @param value
	 */
	public void selectByValue(WebElement element, String value) {
		waitForElementClickable(5, element);
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}

	/**
	 * Method to select using index in dropdown
	 * 
	 * @param element
	 * @param index
	 */
	public void selectByIndex(WebElement element, int index) {
		waitForElementClickable(5, element);
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}

	/**
	 * Method to get the text and verify without creating hard exception
	 * 
	 * @param element
	 * @param ExpectedText
	 * @return int counter
	 */
	public int getTextAndVerifyWithoutException(WebElement element, String ExpectedText) {
		waitForElementPresence(10, element);
		String actualText = element.getText();
		int counter = softAssertEquals(actualText, ExpectedText);
		return counter;
	}

	/**
	 * Method to get the text and verify if the text contains the expected text
	 * without creating hard exception
	 * 
	 * @param element
	 * @param ExpectedText
	 * @return int counter
	 */
	public int getTextAndVerifyContainsWithoutException(WebElement element, String ExpectedText) {
		int counter;
		waitForElementPresence(10, element);
		String actualText = element.getText();
		if (ExpectedText.contains(actualText))
			counter = 0;
		else
			counter = 1;

		return counter;
	}

	/**
	 * 
	 * Method to get text from an element
	 * 
	 * @param timeout
	 * @param element
	 * @return
	 */
	public String getText(int timeout, WebElement element) {
		waitForElementPresence(timeout, element);
		String text = element.getText();
		return text;
	}

	/**
	 * Method to clear text from a textbox
	 * 
	 * @param timeout
	 * @param element
	 */
	public void clearText(int timeout, WebElement element) {
		waitForElementPresence(timeout, element);
		element.clear();
	}

	/**
	 * Method to refresh the page
	 */
	public void refreshPage() {
		driver.navigate().refresh();
	}

	/**
	 * Method to navigate back
	 */
	public void navigateBack() {
		driver.navigate().back();
	}

	/**
	 * Method to navigate forward
	 */
	public void navigateforward() {
		driver.navigate().forward();
	}

	/**
	 * Method to switch to the frame using id
	 * 
	 * @param id
	 */
	public void switchToFrame(String id) {
		driver.switchTo().frame(id);
	}

	/**
	 * Method to switch to frame using element
	 * 
	 * @param element
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * Method to get random string generated
	 * 
	 * @param numberofChar
	 * @return
	 */
	public String getRandomString(int numberofChar) {
		String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789";

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numberofChar; i++) {
			int index = (int) ((int) (alphanumeric.length()) * Math.random());

			sb.append(alphanumeric.charAt(index));
		}

		return sb.toString();

	}

	/**
	 * Method to click based on the value of the button
	 * 
	 * @param timeout
	 * @param locator
	 * @param expectedValue
	 */
	public void clickByValue(int timeout, By locator, String expectedValue) {
		waitForAllElementPresence(timeout, locator);
		List<WebElement> elements = driver.findElements(locator);
		for (WebElement webElement : elements) {
			String value = webElement.getAttribute("value");

			if (value.equals(expectedValue)) {
				webElement.click();
				break;
			}
		}
	}

	/**
	 * Method to click based on the text of the button
	 * 
	 * @param timeout
	 * @param locator
	 * @param expectedValue
	 */
	public void clickByText(int timeout, By locator, String expectedValue) {
		waitForAllElementPresence(timeout, locator);
		List<WebElement> elements = driver.findElements(locator);
		for (WebElement webElement : elements) {
			String value = webElement.getText();

			if (value.equals(expectedValue)) {
				webElement.click();
				break;
			}
		}
	}

	/**
	 * Method to navigate to the first child window
	 */
	public void navigateToFirstChildWindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
	}

	/**
	 * Method to navigate back to parent window
	 */
	public void navigateToParentWindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(parent);
	}

	/**
	 * Method to get all the child windows
	 * 
	 * @return Iterator
	 */
	public Iterator<String> getallChildWindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		return it;
	}

	/**
	 * Method to switch to a window based on the title
	 * 
	 * @param title
	 */
	public void switchToWindowByTitle(String title) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
			String window = it.next();
			driver.switchTo().window(window);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}

	}

	/**
	 * Method to navigate to the child window based on the window number
	 * 
	 * @param windowNumber
	 */
	public void navigateToChildWindow(int windowNumber) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String windowName = null;
		for (int i = 0; i < windowNumber; i++) {
			if (it.hasNext()) {
				windowName = it.next();
			}

		}
		driver.switchTo().window(windowName);

	}

	/**
	 * Method to accept any alerts
	 */
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	/**
	 * Method to dismiss any alrets
	 */
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

}
