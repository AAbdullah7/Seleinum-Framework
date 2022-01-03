package TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegisteraionPage;

@Test 
public class UserRegisterationTest extends TestBase {

	HomePage homeObj;
	UserRegisteraionPage registerObj;
	LoginPage loginobj;
	MyAccountPage myaccountobj;
	String FirstName = "Abdelrahman";String LastName = "Abdullah"; 
	String Email = "aa0@test.com" ; String Password="82645123";
	
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
