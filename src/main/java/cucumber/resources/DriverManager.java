package cucumber.resources;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Driver Manager
 * @author abimu
 *
 */
public class DriverManager extends PropertyReader {

	public WebDriver driver;
	/**
	 * Method to invoke the browser
	 * @return
	 * @throws IOException
	 */
	private WebDriver invokeBrowser() throws IOException {
		String browserProp = readPropertyValue("global", "Browser");
		String browserMaven= System.getProperty("browser");
		String bypass = readPropertyValue("global", "Bypass");
		int waitTimeValue = Integer.parseInt(readPropertyValue("global", "WaitTime"));
		Boolean flag = false;
		if (bypass.equalsIgnoreCase("true"))
			flag = true;

		String browser= browserMaven!=null ? browserMaven:browserProp;
		
		String gridExecution=readPropertyValue("global", "GRID_Execution");
		if(gridExecution.equalsIgnoreCase("false"))
		{
		
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.setAcceptInsecureCerts(flag);
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
			} else if (browser.equalsIgnoreCase("edge")) {
				EdgeOptions options = new EdgeOptions();
				options.setAcceptInsecureCerts(flag);
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(options);
			}
			
		}
		else
		{
			String hub= readPropertyValue("global", "GRID_HUB");
			DesiredCapabilities capability= new DesiredCapabilities();
			capability.setBrowserName(browser);			
			driver= new RemoteWebDriver(new URL(hub),capability);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeValue));

		return driver;

	}
	
	/**
	 * Launch application method
	 * @return
	 * @throws IOException
	 */
	public WebDriver launchApplication() throws IOException {
		String environmentProp = readPropertyValue("global", "Environment");
		String environmentMvn= System.getProperty("environment");
		
		String environment= environmentMvn!=null ? environmentMvn:environmentProp;
		
		driver = invokeBrowser();
		if (environment.equalsIgnoreCase("PROD"))
			driver.get(readPropertyValue("global", "PROD_URL"));
		else if (environment.equalsIgnoreCase("STAGE"))
			driver.get(readPropertyValue("global", "STAGE_URL"));
		else if (environment.equalsIgnoreCase("QA"))
			driver.get(readPropertyValue("global", "QA_URL"));
		else if (environment.equalsIgnoreCase("DEV"))
			driver.get(readPropertyValue("global", "DEV_URL"));

		return driver;
	}

}
