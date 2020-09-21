package Cucumber.Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver; 
	public static String screenshot;
	
	public static WebDriver getDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\pc\\eclipse-workspace\\Automation\\src\\test\\java\\Cucumber\\Automation\\global.properties");
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\eclipse-workspace\\Automation\\src\\test\\java\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(prop.getProperty("url"));
        screenshot = prop.getProperty("Screenshot");
        return driver;
		
	}

}
