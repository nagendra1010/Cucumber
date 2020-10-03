package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FaceBook {

public WebDriver driver;
	
	public FaceBook(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username=By.xpath("//*[@id='email']");
	By password=By.xpath("//*[@id='pass']");
	By login=By.xpath("//*[@name='login']");
	By homeElement=By.xpath("//span[contains(text(),'Nagendra Sahoo')]");
	By arrowButton=By.xpath("//div[@aria-label='Account']/i");
	By logOut=By.xpath("//*[contains(text(),'Log Out')]");
	
	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getlogin()
	{
		return driver.findElement(login);
	}
	
	public WebElement gethomeElement()
	{
		return driver.findElement(homeElement);
	}
	
	public WebElement getarrowButton()
	{
		return driver.findElement(arrowButton);
	}
	
	public WebElement getlogOut()
	{
		return driver.findElement(logOut);
	}
}

