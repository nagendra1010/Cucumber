package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	
	public WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By increment=By.xpath("//a[@class='increment']");
	By addtocart=By.xpath("//*[contains(text(),'ADD TO CART')]");
	
	public WebElement getIncrement()
	{
		return driver.findElement(increment);
	}
	
	public WebElement getAddtocart()
	{
		return driver.findElement(addtocart);
	}

}
