package TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

import Data.LoadProperties;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegisteraionPage;

@Test 
public class UserRegisterationUsingDDAndPropertiesFileTest3 extends TestBase {

	HomePage homeObj;
	UserRegisteraionPage registerObj;
	LoginPage loginobj;
	MyAccountPage myaccountobj;
	String FirstName = LoadProperties.UserData.getProperty("FirstName");
	String LastName = LoadProperties.UserData.getProperty("LastName");
	String Email = LoadProperties.UserData.getProperty("Email");
	String Password = LoadProperties.UserData.getProperty("Password");

	@Test(priority = 1)
	public void UserCanRegister()
	{
		homeObj = new HomePage(driver);
		homeObj.openregisterationpage();
		registerObj = new UserRegisteraionPage(driver);
		registerObj.UserRegisteration(FirstName, LastName, Email, Password);
		Assert.assertTrue(registerObj.successmessage.getText().contains("Your registration completed"));
		
	}
	
	@Test(priority = 2)
	public void RegisterUserCanLogout()
	{
		registerObj.LogOut();
	}

	@Test(priority = 3)
	public void RegisterUserCanLogin()
	{

		loginobj = new LoginPage(driver);
		loginobj.openLoginpage();
		loginobj.UserLogin(Email, Password);
		Assert.assertTrue(loginobj.LoginLink.isDisplayed());
	}


}


