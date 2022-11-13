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

public class BaseActions extends Utilities {

	WebDriver driver;

	public BaseActions(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

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

	private boolean isSelected(int timeout, WebElement element) {
		waitForElementPresence(timeout, element);
		return element.isSelected();

	}

	public void verifyCurrentURL(String URL) throws IOException {

		String expectedURL = getApplicationURL() + URL;
		waitForURL(10, expectedURL);
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, expectedURL);

	}

	public void verifyCurrentTitle(String title) throws IOException {

		String expectedtitle = title;
		String currenttitle = driver.getTitle();
		softAssertEquals(currenttitle, expectedtitle);

	}

	public void normalClick(WebElement element) {
		waitForElementClickable(5, element);
		element.click();

	}

	public void ClickwithEnter(WebElement element) {
		waitForElementClickable(5, element);
		element.sendKeys(Keys.ENTER);

	}

	public void sendText(WebElement element, String value) {
		waitForElementClickable(5, element);
		element.sendKeys(value);

	}

	public void moveToAndClick(WebElement element) {
		waitForElementClickable(5, element);
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}

	public void hoverToElement(WebElement element) {
		waitForElementClickable(5, element);
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public void doubleClick(WebElement element) {
		waitForElementClickable(5, element);
		Actions act = new Actions(driver);
		act.moveToElement(element).doubleClick(element).build().perform();
	}

	public void rightClick(WebElement element) {
		waitForElementClickable(5, element);
		Actions act = new Actions(driver);
		act.moveToElement(element).contextClick(element).build().perform();
	}

	public void selectByVisibleText(WebElement element, String text) {
		waitForElementClickable(5, element);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
	}

	public void selectByValue(WebElement element, String value) {
		waitForElementClickable(5, element);
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}

	public void selectByIndex(WebElement element, int index) {
		waitForElementClickable(5, element);
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}

	public int getTextAndVerifyWithoutException(WebElement element, String ExpectedText) {
		waitForElementPresence(10, element);
		String actualText = element.getText();
		int counter = softAssertEquals(actualText, ExpectedText);
		return counter;
	}

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

	public String getText(int timeout, WebElement element) {
		waitForElementPresence(timeout, element);
		String text = element.getText();
		return text;
	}

	public void clearText(int timeout, WebElement element) {
		waitForElementPresence(timeout, element);
		element.clear();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateforward() {
		driver.navigate().forward();
	}

	public void switchToFrame(String id) {
		driver.switchTo().frame(id);
	}

	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	public String getRandomString(int numberofChar) {
		String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789";

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numberofChar; i++) {
			int index = (int) ((int) (alphanumeric.length()) * Math.random());

			sb.append(alphanumeric.charAt(index));
		}

		return sb.toString();

	}

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

	public void navigateToFirstChildWindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
	}

	public void navigateToParentWindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(parent);
	}

	public Iterator<String> getallChildWindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		return it;
	}

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

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

}
