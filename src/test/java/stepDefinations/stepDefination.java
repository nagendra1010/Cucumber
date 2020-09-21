
package stepDefinations;

import java.util.List;
import org.junit.runner.RunWith;

import ReusableFunctions.Reusable;
import io.cucumber.datatable.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefination {
	
	 @Given("^User is on Netbanking landing page$")
	    public void user_is_on_netbanking_landing_page() throws Throwable {
		 System.out.println("Navigated to landing page");
		
	    }

	 @When("^User log into application with \"([^\"]*)\" and \"([^\"]*)\"$")
	    public void user_login_into_application_with_something_and_something(String strArg1, String strArg2) throws Throwable {
		 System.out.println(strArg1);
		 System.out.println(strArg2);
	    }

	    @Then("^Home page is populated$")
	    public void home_page_is_populated() throws Throwable {
	    System.out.println("Home page populated");
	       
	    }

	    @Then("^Cards are displayed$")
	    public void cards_are_displayed() throws Throwable {
	    System.out.println("Card page populated");
	    }
	    
	    @When("^User sign up with following details$")
	    public void user_sign_up_with_following_details(DataTable data) throws Throwable {
	    List<List<String>> obj=data.asLists(); 
	    System.out.println(obj.get(0).get(0));
	    System.out.println(obj.get(0).get(1));
	    System.out.println(obj.get(0).get(2));
	    System.out.println(obj.get(0).get(3));
	    System.out.println(obj.get(0).get(4));
	    }
	    
	    @When("^User login into application with (.+) and (.+)$")
	    public void user_login_into_application_with_and(String username, String password) throws Throwable {
	    System.out.println(username);
	    System.out.println(password);

	    }
	    
	    @Given("^validate the browser$")
	    public void validate_the_browser() throws Throwable {
	        System.out.println("Browser is opened");
	    }

	    @When("^Browser is triggered$")
	    public void browser_is_triggered() throws Throwable {
	    	System.out.println("Url is hit");
	    }

	    @Then("^check if browser is started$")
	    public void check_if_browser_is_started() throws Throwable {
	    	System.out.println("Url is opened");
	    }

}
