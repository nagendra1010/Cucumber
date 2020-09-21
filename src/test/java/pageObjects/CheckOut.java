package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOut {
	
public WebDriver driver;
	
	public CheckOut(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By cart=By.xpath("//img[@alt='Cart']");
	By proceedtocheckout=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By productName=By.xpath("//p[@class='product-name']");
	
	public WebElement getCart()
	{
		return driver.findElement(cart);
	}
	
	public WebElement getproceedtocheckout()
	{
		return driver.findElement(proceedtocheckout);
	}
	
	public WebElement getproductName()
	{
		return driver.findElement(productName);
	}
}
