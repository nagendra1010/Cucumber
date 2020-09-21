package Cucumber.Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ReusableFunctions.StaticVariable;

public class Base {
	public static WebDriver driver; 
	
	public static WebDriver getDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\pc\\eclipse-workspace\\Automation\\configuration\\global.properties");
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver",StaticVariable.chromeDriverpath);
		driver=new ChromeDriver();
        driver.get(StaticVariable.CaseHandlingSystem_URL); 
        return driver;
	}
}
