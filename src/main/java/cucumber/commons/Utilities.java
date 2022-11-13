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

public class Utilities {
	
	
	public WebDriver driver;
	
	public Utilities(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void  waitForElementPresence(int timeout, By locator)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
	public void  waitForElementPresence(int timeout, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void  waitForElementClickable(int timeout, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	public void  waitForElementClickable(int timeout, By locator)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}
	
	public void  waitForElementInvisible(int timeout, By locator)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}
	
	public void  waitForElementInvisible(int timeout, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.invisibilityOf(element));

	}
	
	public void  waitForAllElementInvisible(int timeout, List<WebElement> elements)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));

	}
	
	public void waitForAllElementPresence(int timeout, By locator)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	

	
	public void waitForURL(int timeout, String URL)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.urlToBe(URL));

	}
	
	public void waitForTitle(int timeout, String title)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.titleIs(title));

	}
	
	public int softAssertEquals(String actual, String expected) {

		if (actual.equals(expected)) {
			return 1;

		} else {
			return 0;

		}

	}

	public int softAssertNotEquals(String actual, String expected) {
		
		if (!actual.equals(expected)) {
			return 1;

		} else {
			return 0;

		}
	}
	

	public int softAssertTrue(Boolean condition) {
		
		if (condition) {
			return 1;
		} else {
			return 0;
		}

	}

	public int softAssertFalse(Boolean condition) {
		
		if (!condition) {
			return 1;
		} else {
			return 0;
		}
		

	}
	

	
	

}
