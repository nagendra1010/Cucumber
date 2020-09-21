package stepDefinations;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Cucumber.Automation.Base;
import ReusableFunctions.Reusable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import junit.framework.Assert;
import pageObjects.CartPage;
import pageObjects.CheckOut;
import pageObjects.HomePage;


public class myStepDefination {
	
	public WebDriver driver;
	HomePage h;
	CartPage c;
	CheckOut c1;
	
	 	@Given("^User is on Greencart landing page$")
	    public void user_is_on_greencart_landing_page() throws Throwable {
	        driver=Base.getDriver();
	        Reusable.takeScreenshot(driver, System.currentTimeMillis());
	    }

	    @When("^User search for (.+) Vegetable$")
	    public void user_search_for_something_vegetable(String strArg1) throws Throwable {
	    	h=new HomePage(driver);
	    	h.getSearch().sendKeys(strArg1);
	        Thread.sleep(3000);
	    }

	    @SuppressWarnings("deprecation")
		@Then("^\"([^\"]*)\" results are displayed$")
	    public void something_results_are_displayed(String strArg1) throws Throwable {
	    	//h=new HomePage(driver);
	    	Assert.assertTrue(h.getproductname().getText().contains(strArg1));
	    	Reusable.takeScreenshot(driver, System.currentTimeMillis());
	    }
	    @SuppressWarnings("deprecation")
		@Then("^verify selected (.+) items are dispalyed in checkout page$")
	    public void verify_selected_something_items_are_dispalyed_in_checkout_page(String strArg1) throws Throwable {
	    	Assert.assertTrue(c1.getproductName().getText().contains(strArg1));
	    	Reusable.takeScreenshot(driver, System.currentTimeMillis());
	    	
	    }

	    @Then("^added items to cart$")
	    public void added_items_to_cart() throws Throwable {
	    	c=new CartPage(driver);
	    	c.getIncrement().click();
	    	c.getAddtocart().click();
	    }

	    @Then("^user proceeded to Checkout page for purchase$")
	    public void user_proceeded_to_checkout_page_for_purchase() throws Throwable {
	    	c1=new CheckOut(driver);
	    	c1.getCart().click();
	    	c1.getproceedtocheckout().click();	
	    	Reusable.takeScreenshot(driver, System.currentTimeMillis());
	    }
}
