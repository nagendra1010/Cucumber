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
	ReusableFunctions.ConfigFileReader configReader = new ReusableFunctions.ConfigFileReader();
	@Before
	public void setUpScenario(Scenario scenario) {
		StaticVariable.message = scenario;
		System.out.println("RUNNING SCENARIO --> " + scenario.getName());
		StaticVariable.SCENARIO_NAME = scenario.getName().trim();
		// Store all the TestProperties parameters in Static Variables
		StaticVariable.LOCALPATH = configReader.getPropertyFromPropertiesFile("LOCALPATH");
		StaticVariable.BROWSER = configReader.getPropertyFromPropertiesFile("BROWSER");
		StaticVariable.SCREENSHOTS = configReader.getPropertyFromPropertiesFile("SCREENSHOTS");
		StaticVariable.HIGHLIGHTS = configReader.getPropertyFromPropertiesFile("HIGHLIGHTS");
		StaticVariable.chromeDriverpath = configReader.getPropertyFromPropertiesFile("chromeDriverpath");
		StaticVariable.OBJECTREPOSITORY = configReader.getPropertyFromPropertiesFile("OBJECTREPOSITORY");
		StaticVariable.CaseHandlingSystem_URL = configReader.getPropertyFromPropertiesFile("facebookURL");
		StaticVariable.MAX_WAIT_TIME = configReader.getPropertyFromPropertiesFile("MAX_WAIT_TIME");
		StaticVariable.TESTDATAREPO = configReader.getPropertyFromPropertiesFile("TESTDATA");
		StaticVariable.SHAREDRESULTS = configReader.getPropertyFromPropertiesFile("SHAREDRESULTS");
		StaticVariable.SHAREDPATH = configReader.getPropertyFromPropertiesFile("SHAREDPATH");
	}

	@After
	public void embedScreenshot(Scenario scenario) throws IOException 
	{
		if (scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				System.out.println("Screenshot taken!!");
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(
				System.getProperty("user.dir")+StaticVariable.LOCALPATH +"Screenshot\\"+System.currentTimeMillis()+ scenario.getName() + ".jpg");
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