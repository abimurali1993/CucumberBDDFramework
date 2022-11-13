package cucumber.commons;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
/**
 * Utilities class have all wait and assertion wrapper methods
 * @author abimu
 *
 */
public class Utilities {
	
	//Creating local instance of the driver
	public WebDriver driver;
	
	//Creating a constructor to get the latest driver
	public Utilities(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/**
	 * Method to wait for element presence using By locator
	 * @param timeout
	 * @param locator
	 */
	public void  waitForElementPresence(int timeout, By locator)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
	/**
	 * Method to wait for element presence
	 * @param timeout
	 * @param element
	 */
	public void  waitForElementPresence(int timeout, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	/**
	 * Method to wait for element to be clickable
	 * @param timeout
	 * @param element
	 */	
	public void  waitForElementClickable(int timeout, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	/**
	 * Method to wait for element to be clickable with By locator
	 * @param timeout
	 * @param locator
	 */	
	public void  waitForElementClickable(int timeout, By locator)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}
	
	/**
	 * Method to wait for element to be invisible using By locator
	 * @param timeout
	 * @param locator
	 */	
	public void  waitForElementInvisible(int timeout, By locator)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}
	
	/**
	 * Method to wait for element to be invisible
	 * @param timeout
	 * @param element
	 */	
	public void  waitForElementInvisible(int timeout, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.invisibilityOf(element));

	}
	
	/**
	 * Method to wait for all element to be invisible
	 * @param timeout
	 * @param elements
	 */		
	public void  waitForAllElementInvisible(int timeout, List<WebElement> elements)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));

	}
	
	/**
	 * Method for all elements to be present
	 * @param timeout
	 * @param locator
	 */	
	public void waitForAllElementPresence(int timeout, By locator)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	/**
	 * Method for URL to be displayed
	 * @param timeout
	 * @param URL
	 */	
	public void waitForURL(int timeout, String URL)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.urlToBe(URL));

	}
	
	/**
	 * Method for title to be displayed
	 * @param timeout
	 * @param title
	 */	
	public void waitForTitle(int timeout, String title)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.titleIs(title));

	}
	
	/**
	 * Soft Assertion Equals
	 * @param actual
	 * @param expected
	 * @return
	 */
	public int softAssertEquals(String actual, String expected) {

		if (actual.equals(expected)) {
			return 1;

		} else {
			return 0;

		}

	}
	
	/**
	 * Soft Assertion not equals
	 * @param actual
	 * @param expected
	 * @return
	 */
	public int softAssertNotEquals(String actual, String expected) {
		
		if (!actual.equals(expected)) {
			return 1;

		} else {
			return 0;

		}
	}
	
	/**
	 * Soft Assertion True
	 * @param condition
	 * @return
	 */
	public int softAssertTrue(Boolean condition) {
		
		if (condition) {
			return 1;
		} else {
			return 0;
		}

	}

	
	/**
	 * Soft Assertion False
	 * @param condition
	 * @return
	 */
	public int softAssertFalse(Boolean condition) {
		
		if (!condition) {
			return 1;
		} else {
			return 0;
		}
		

	}
	

	
	

}
