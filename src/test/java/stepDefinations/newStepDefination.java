package stepDefinations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import Cucumber.Automation.Base;
import ReusableFunctions.Reusable;
import ReusableFunctions.StaticVariable;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.FaceBook;

public class newStepDefination {
	
	//public WebDriver driver;
	Reusable reusableFunctions = new Reusable();
	@Given("^User is on Facebook login page$")
	public void user_is_on_Facebook_login_page() throws Throwable {	
		ReusableFunctions.GetDrivers.Driver=Base.getDriver();
        Reusable.takeScreenshot(ReusableFunctions.GetDrivers.Driver, System.currentTimeMillis());
	}
	
	
	
	@When("^User types \"([^\"]*)\" in the field \"([^\"]*)\"$")
	public void user_logins_with(String enteredText, String objectName, DataTable pageName) throws Throwable {
		List<Map<String, String>> data = pageName.asMaps(String.class, String.class);
		String page = data.get(0).get("PageName").trim();
		enteredText = reusableFunctions.getTestData(enteredText).trim();
		Boolean element = reusableFunctions.getElement(objectName, page);
		if (element) {
			reusableFunctions.clickElement(objectName, page);

			reusableFunctions.clearElement(objectName, page);
			reusableFunctions.enterTextinElement(objectName, page, enteredText);

			System.out.println(enteredText + " is entered in the " + objectName);
			Reporter.addStepLog(enteredText + " is entered in the " + objectName);
			Reusable.takeScreenshot(ReusableFunctions.GetDrivers.Driver, System.currentTimeMillis());
		}
	}
	@Then("^User clicks on \"([^\"]*)\"$")
	public void the_user_clicks_on_the_button(String buttonName, DataTable pageName) throws Throwable {
		List<Map<String, String>> data = pageName.asMaps(String.class, String.class);
		String page = data.get(0).get("PageName").trim();

		Boolean element = reusableFunctions.getElement(buttonName, page);
		if (element) {

			reusableFunctions.waitForelementtobeClickabe(buttonName, page);
			reusableFunctions.highlightElement(buttonName, page, "None");
			reusableFunctions.clickElement(buttonName, page);

			System.out.println(buttonName + " is clicked successfully!!");
			Reporter.addStepLog(buttonName + " is clicked successfully!!");
			Reusable.takeScreenshot(ReusableFunctions.GetDrivers.Driver, System.currentTimeMillis());

		}
	}
	

	@SuppressWarnings("deprecation")
	@Then("^User validates \"([^\"]*)\"$")
	public void user_proceeds_to_Home_page(String objectName, DataTable pageName) throws Throwable {
		List<Map<String, String>> data = pageName.asMaps(String.class, String.class);
		String page = data.get(0).get("PageName").trim();
		
		Boolean element = reusableFunctions.getElement(objectName, page);

		if (element) {

			System.out.println("The " + objectName + " page is displayed successfully");
			Reporter.addStepLog("The " + objectName + " page is displayed successfully");
			reusableFunctions.highlightElement(objectName, page, StaticVariable.PASS);
			Reusable.takeScreenshot(ReusableFunctions.GetDrivers.Driver, System.currentTimeMillis());

		}
		
	}
	
}
