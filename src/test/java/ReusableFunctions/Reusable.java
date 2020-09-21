package ReusableFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;


public class Reusable extends StaticVariable{
	public WebDriver driver; 
	
	public static void takeScreenshot(WebDriver driver, long ms)
	{
		if (StaticVariable.screenshot.equalsIgnoreCase("True")) 
		{
			int maxWaitTime = Integer.parseInt(StaticVariable.MAX_WAIT_TIME);
			// waitForelement(ObjectName, pageName);
			driver.manage().timeouts().implicitlyWait(maxWaitTime, TimeUnit.SECONDS);
			try 
			{
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(
				System.getProperty("user.dir")+StaticVariable.PATH + ms + ".jpg");
				FileUtils.copyFile(source, destinationPath);
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				StaticVariable.message.embed(screenshot, "image/png");
			}catch (Exception e) {
				System.out.println("Exception while taking ScreenShot " + e.getMessage());
			}
		}
	}
	
	public static String getHostName() {
		try {
			InetAddress myHost = InetAddress.getLocalHost();
			System.out.println(myHost.getHostName());
			return myHost.getHostName();
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public static void deleteDir() {
		try {
            File f = new File("C:\\Users\\pc\\eclipse-workspace\\Automation\\target\\cucumber-reports\\Screenshot");
            FileUtils.forceDelete(f); //delete directory
            FileUtils.forceMkdir(f); //create directory
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}
}
