package Steps;

import org.testng.Assert;

import Pages.HomePage;
import Pages.UserRegisteraionPage;
import TestCase.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegisteration extends TestBase {

	HomePage home ;
	UserRegisteraionPage register ;

	@Given("The user in the home page")
	public void the_user_in_the_home_page() 
	{
		home = new HomePage(driver);
		home.openregisterationpage();
	}

	@When("I click on register link")
	public void i_click_on_register_link() 
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	@When("I entered {string} , {string} , {string} , {string}")
	public void i_entered(String FirstName, String LastName, String Email, String Password) 
	{ 
		register = new UserRegisteraionPage(driver);
		register.UserRegisteration(FirstName, LastName, Email, Password);
	}

	@Then("The registeration page displayed successfully")
	public void the_registeration_page_displayed_successfully() 
	{
		register.LogOut();

	}

}
