package cucumber.stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.reporter.FileUtil;

import cucumber.globals.Globals;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
public Globals global;
	
	public Hooks(Globals global)
	{
		this.global=global;
	}
	
	
	@After
	public void teardown()
	{
		global.driver.quit();
		global.softErrors=0;
	}

	
	@AfterStep
	public void takeScreenshot(Scenario scenario) throws IOException
	{
		Boolean takeScreenshot=global.takeScreenshot;
		WebDriver driver= global.driver;
		if (scenario.isFailed())
		{
			File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] filecontent=FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(filecontent, "image/png", "Screenshot attached");
		}
		else if (takeScreenshot)
		{
			File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] filecontent=FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(filecontent, "image/png", "Screenshot attached");
			
		}
		
	}
	

}
