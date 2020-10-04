package ReusableFunctions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import ReusableFunctions.StaticVariable;

import junit.framework.Assert;


public class Reusable extends StaticVariable{
	public WebDriver driver; 
	
	public static void takeScreenshot(WebDriver driver, long ms)
	{
		if (StaticVariable.SCREENSHOTS.equalsIgnoreCase("True")) 
		{
			int maxWaitTime = Integer.parseInt(StaticVariable.MAX_WAIT_TIME);
			// waitForelement(ObjectName, pageName);
			ReusableFunctions.GetDrivers.Driver.manage().timeouts().implicitlyWait(maxWaitTime, TimeUnit.SECONDS);
			try 
			{
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(
				System.getProperty("user.dir")+StaticVariable.LOCALPATH +"Screenshot"+"\\"+ ms + ".jpg");
				FileUtils.copyFile(source, destinationPath);
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
				byte[] screenshot = ((TakesScreenshot) ReusableFunctions.GetDrivers.Driver).getScreenshotAs(OutputType.BYTES);
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
            File f = new File("target\\cucumber-reports\\Screenshot");
            FileUtils.forceDelete(f); //delete directory
            FileUtils.forceMkdir(f); //create directory
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}
	public String getRelativeXPATH(String ObjectName, String pageName) {
		String excelName = StaticVariable.CURRENTUSERSHOMEDIR + "\\ObjectRepository\\"
				+ StaticVariable.OBJECTREPOSITORY + ".xlsx";
		boolean dataFound = false;
		String relativeXPATH = null;
		try {
			ExcelFunctions excel = new ExcelFunctions(excelName);

			for (int i = 2; i <= excel.getlastRowNumber(pageName) + 2; i++) {
				if (excel.getCellData(pageName.trim(), "ObjectName", i).contentEquals(ObjectName)) {
					relativeXPATH = excel.getCellData(pageName.trim(), "Relative XPATH", i);
					dataFound = true;
					break;
				}
			}

			if (dataFound) {
				return relativeXPATH;
			} else {
				return null;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Excel/OR is not found");
			System.err.println(excelName);
		}
		return excelName;

	}
	
	public Boolean getElement(String ObjectName, String pageName) throws InterruptedException {

		String objXPATH = getRelativeXPATH(ObjectName, pageName);
		System.out.println("XPATH is " + objXPATH);
		boolean elementFound = false;
		WebElement element = null;
		int maxWaitTime = Integer.parseInt(StaticVariable.MAX_WAIT_TIME);
		// waitForelement(ObjectName, pageName);

		if (objXPATH != null) {
			int p = 1;
			while (p <= 4) {
				try {
					ReusableFunctions.GetDrivers.Driver.manage().timeouts().implicitlyWait(maxWaitTime, TimeUnit.SECONDS);
					waitForelement(ObjectName, pageName);
					System.out.println(ObjectName + " wait successful");
					Actions action = new Actions(ReusableFunctions.GetDrivers.Driver);
					element = ReusableFunctions.GetDrivers.Driver.findElement(By.xpath(objXPATH));

					action.moveToElement(element).build().perform();

					p = 4;
					elementFound = true;

				} catch (StaleElementReferenceException e)

				{

					System.out.println("Stale Element Exception,Retrying to find the Element!!");

				}

				p = p + 1;
			}
			if (elementFound) {

				System.out.println("Element found!!");

				return elementFound;

			} else {
				return false;
			}

		} else {

			System.err.println("Object with relative XPATH-- " + objXPATH + " is not found!!!Please check again");
			return false;
		}

	}
	
	public WebElement waitForelement(String objName, String pageName) throws InterruptedException {
		int maxWaitTime = Integer.parseInt(StaticVariable.MAX_WAIT_TIME);

		int i = 0;
		while (i < 4) {
			try {
				WebDriverWait wait = new WebDriverWait(ReusableFunctions.GetDrivers.Driver, maxWaitTime);
				String objXPATH = getRelativeXPATH(objName, pageName);
				
				
				WebElement element = ReusableFunctions.GetDrivers.Driver.findElement(By.xpath(objXPATH));
				Actions actions = new Actions(ReusableFunctions.GetDrivers.Driver);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(objXPATH)));
				//go to element using jscript
				actions.moveToElement(element);
				actions.build().perform();
				WebElement elementWait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXPATH)));
				i = 4;
				return elementWait;
			} catch (StaleElementReferenceException e) {

				System.out.println("Stale Element Exception,Retrying to find the Element!!");

			}

			i = i + 1;
			// return null;
		}
		return null;

	}
	
public String getTestData(String TestDataName) {
			String excelName = StaticVariable.CURRENTUSERSHOMEDIR + "\\TestData\\" + StaticVariable.TESTDATAREPO
					+ ".xlsx";
			boolean dataFound = false;
			String testDataValue = null;
			try {
				ExcelFunctions excel = new ExcelFunctions(excelName);

				for (int i = 2; i <= excel.getlastRowNumber("TestData") + 2; i++) {
					if (excel.getCellData("TestData".trim(), "ScenarioName", i)
							.contentEquals(StaticVariable.SCENARIO_NAME)) {
						testDataValue = excel.getCellData("TestData".trim(), TestDataName.trim(), i);
						dataFound = true;
						break;
					}
				}

				if (dataFound) {

					return testDataValue;
				} else {
					return null;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("Excel/OR is not found");
				System.err.println(excelName);
			}
			return excelName;
		}
public void clickElement(String objectName, String page) throws InterruptedException {
	
	boolean elementFound = getElement(objectName, page);
	String objXpath = getRelativeXPATH(objectName, page);
	WebElement element;
	
	Actions actions = new Actions(ReusableFunctions.GetDrivers.Driver);
	if (elementFound) {
		element = ReusableFunctions.GetDrivers.Driver.findElement(By.xpath(objXpath));
		waitForelementtobeClickabe(objectName, page);
		actions.moveToElement(element);

		actions.click().build().perform();

	} else {
		Assert.fail(objectName + " is not found!!");
	}
}
public void waitForelementtobeClickabe(String objName, String pageName) throws InterruptedException {
	int maxWaitTime = Integer.parseInt(StaticVariable.MAX_WAIT_TIME);

	WebDriverWait wait = new WebDriverWait(ReusableFunctions.GetDrivers.Driver, maxWaitTime);
	String objXPATH = getRelativeXPATH(objName, pageName);

	WebElement element = ReusableFunctions.GetDrivers.Driver.findElement(By.xpath(objXPATH));
	Actions actions = new Actions(ReusableFunctions.GetDrivers.Driver);

	actions.moveToElement(element);

	actions.build().perform();
	WebElement elementWait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objXPATH)));

}
public void clearElement(String objectName, String page) throws InterruptedException {
	boolean elementFound = getElement(objectName, page);
	String objXpath = getRelativeXPATH(objectName, page);
	WebElement element;
	Actions actions = new Actions(ReusableFunctions.GetDrivers.Driver);
	if (elementFound) {
		element = ReusableFunctions.GetDrivers.Driver.findElement(By.xpath(objXpath));
		actions.moveToElement(element).perform();
		element.clear();

	}
}

public void enterTextinElement(String objectName, String page, String enteredText) throws InterruptedException {
	boolean elementFound = getElement(objectName, page);
	String objXpath = getRelativeXPATH(objectName, page);
	WebElement element;
	if (elementFound) {
		element = ReusableFunctions.GetDrivers.Driver.findElement(By.xpath(objXpath));
		Actions action=new Actions(ReusableFunctions.GetDrivers.Driver);
		action.moveToElement(element).build().perform();
	
		element.sendKeys(enteredText);
	}
}

public void highlightElement(String objName, String pageName, String result) throws InterruptedException {
	if (StaticVariable.HIGHLIGHTS.equalsIgnoreCase("TRUE")) {

		waitForelement(objName, pageName);

		String objXpath = getRelativeXPATH(objName, pageName);
		WebElement element = ReusableFunctions.GetDrivers.Driver.findElement(By.xpath(objXpath));

		JavascriptExecutor js = (JavascriptExecutor) ReusableFunctions.GetDrivers.Driver;

		if (result.trim().equalsIgnoreCase("Pass")) {

			js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid green;');", element);
		} else if (result.trim().equalsIgnoreCase("Fail")) {
			js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
		} else {
			js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid blue;');", element);
		}
	}
}
}
	
