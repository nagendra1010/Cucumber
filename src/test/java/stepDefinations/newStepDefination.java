package stepDefinations;

import org.openqa.selenium.WebDriver;

import Cucumber.Automation.Base;
import ReusableFunctions.Reusable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.FaceBook;

public class newStepDefination {
	
	public WebDriver driver;
	FaceBook f;
	
	@Given("^User is on Facebook login page$")
	public void user_is_on_Facebook_login_page() throws Throwable {
		driver=Base.getDriver();
        Reusable.takeScreenshot(driver, System.currentTimeMillis());
	}

	@When("^User logins with (.+) and (.+)$")
	public void user_logins_with(String strArg1, String strArg2) throws Throwable {
	    f=new FaceBook(driver);
	    f.getUsername().sendKeys(strArg1);
	    f.getPassword().sendKeys(strArg2);
	    Reusable.takeScreenshot(driver, System.currentTimeMillis());
	    f.getlogin().click();
	    Thread.sleep(10000);
	}

	@SuppressWarnings("deprecation")
	@When("^User proceeds to Home page (.+)$")
	public void user_proceeds_to_Home_page(String strArg1) throws Throwable {
		Assert.assertTrue(f.gethomeElement().getText().contains(strArg1));
		Reusable.takeScreenshot(driver, System.currentTimeMillis());
	}

	@Then("^User logsout$")
	public void user_logsout() throws Throwable {
		Thread.sleep(5000);
		f.getarrowButton().click();
		Thread.sleep(3000);
		f.getlogOut();
		Reusable.takeScreenshot(driver, System.currentTimeMillis());
	    
	}
	
}
