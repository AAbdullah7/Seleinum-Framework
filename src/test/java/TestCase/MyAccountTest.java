package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegisteraionPage;

public class MyAccountTest extends TestBase {
	
	HomePage homeObj;
	UserRegisteraionPage registerObj;;
	MyAccountPage myaccountobj;
	LoginPage loginobj;

	@Test(priority=1)
	public void UserCanRegister()
	{
		homeObj = new HomePage(driver);
		homeObj.openregisterationpage();
		registerObj = new UserRegisteraionPage(driver);
		registerObj.UserRegisteration("Abdelrahman","Abdullah","A.abdullah005@gmail.com","82645123");
		Assert.assertTrue(registerObj.successmessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority=2)
	public void UserCanChangePassword()
	{
		myaccountobj = new MyAccountPage(driver);
		registerObj.openmyaccountpage();
		myaccountobj.openchangepasswordpage();
		myaccountobj.ChangePassword("82645123","123456");
	}
	
	
	@Test(priority=3)
	public void RegisterUserCanLogout()
	{
		registerObj.LogOut();
	}
	
	@Test(priority=4)
	public void RegisterUserCanLogin()
	{

		loginobj = new LoginPage(driver);
		loginobj.openLoginpage();
		loginobj.UserLogin("A.abdullah100@gmail.com", "123456");
		Assert.assertTrue(loginobj.LoginLink.isDisplayed());
	}
	

}
