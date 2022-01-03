package TestCase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegisteraionPage;

@Test 
public class UserRegisterationUsingDDTest2 extends TestBase 

{
	HomePage homeObj;
	UserRegisteraionPage registerObj;
	LoginPage loginobj;
	MyAccountPage myaccountobj;

	@DataProvider(name = "TestData")
	public static Object[][] UserData()
	{
		return new Object[][] 

				{
			{"Abdelrahman" , "Abdullah","Test@test.com","82645123"},
			{"Ahmed","Ali","Test1@test.com","123456"}
				};
	}

	
	@Test(priority = 1,dataProvider = "TestData")
	public void UserCanRegister(String FirstName,String LastName ,String Email, String Password)
	{
		homeObj = new HomePage(driver);
		homeObj.openregisterationpage();
		registerObj = new UserRegisteraionPage(driver);
		registerObj.UserRegisteration(FirstName, LastName, Email, Password);
		Assert.assertTrue(registerObj.successmessage.getText().contains("Your registration completed"));
		registerObj.LogOut();
		loginobj = new LoginPage(driver);
		loginobj.openLoginpage();
		loginobj.UserLogin(Email, Password);
		Assert.assertTrue(loginobj.LoginLink.isDisplayed());
	}


	}



