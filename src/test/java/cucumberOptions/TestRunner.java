package cucumberOptions;
import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;

import ReusableFunctions.Reusable;
import ReusableFunctions.StaticVariable;
//import ReusableFunctions.Reusable;
//import Variables.StaticVariables;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import com.cucumber.listener.ExtentCucumberFormatter;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = true,
		features = "src/test/java/features",
		glue= "stepDefinations",
		tags="@RegressionTest",
		monochrome=true,
		plugin= {"com.cucumber.listener.ExtentCucumberFormatter:","json:target/cucumber.json","junit:target/cukes.xml"})

public class TestRunner {
	@BeforeClass 
	public static void startExecution() 
	{ 
		String reportpath = "target\\cucumber-reports\\report.html"; 
		File file = new File(reportpath);
		Reusable.deleteDir();
		ExtentCucumberFormatter extent = new ExtentCucumberFormatter(file); 
	}
	
	@AfterClass
	public static void writeExtentReport()
	{
		Reporter.loadXMLConfig(new File("config/report.xml"));
		
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Developer", "Nagendra Sahoo");
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Application", StaticVariable.Application);
		Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		Reporter.setSystemInfo("HostName", Reusable.getHostName());
	}

}  
