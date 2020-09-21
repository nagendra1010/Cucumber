package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.cucumber.listener.Reporter;

import Cucumber.Automation.Base;
import ReusableFunctions.StaticVariable;
import cucumber.api.java.Before;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks extends Base {
	@Before
	public void setUpScenario(Scenario scenario) {
		System.out.println("Before scenario");
		StaticVariable.message = scenario;
	}

	@After
	public void embedScreenshot(Scenario scenario) throws IOException 
	{
		System.out.println("After scenario");
		if (scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				System.out.println("Screenshot taken!!");
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(
				System.getProperty("user.dir")+StaticVariable.PATH +System.currentTimeMillis()+ scenario.getName() + ".jpg");
				FileUtils.copyFile(source, destinationPath);
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
				driver.quit();
			}
			catch (WebDriverException wde) {
				System.err.println(wde.getMessage());
				driver.quit();
			} 
			catch (ClassCastException cce) {
				cce.printStackTrace();
				driver.quit();
			}
			catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				driver.quit();
			}
		} 
		else {
			driver.quit();
		}
	}
}