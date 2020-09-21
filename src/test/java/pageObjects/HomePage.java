package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
		
	By search=By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
	By productname=By.xpath("//h4[@class='product-name']");
	public WebElement getSearch()
	{
		return driver.findElement(search);
	}
	
	public WebElement getproductname()
	{
		return driver.findElement(productname);
	}

}
