package TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegisteraionPage;

@Test 
public class UserRegisterationDDTWithJavaFaker extends TestBase 
{

	HomePage homeObj;
	UserRegisteraionPage registerObj;
	LoginPage loginobj;
	MyAccountPage myaccountobj;

	Faker fakeData = new Faker();
	String FirstName = fakeData.name().firstName();String LastName = fakeData.name().lastName(); 
	String Email = fakeData.internet().emailAddress(); String Password= fakeData.number().digits(8).toString();


	@Test
	public void UserCanRegister()
	{
		homeObj = new HomePage(driver);
		homeObj.openregisterationpage();
		registerObj = new UserRegisteraionPage(driver);
		registerObj.UserRegisteration(FirstName, LastName, Email, Password);

		System.out.println("The User Data Is : " + FirstName + "\t " + LastName + " \t" + Email + "\t " + Password );
		Assert.assertTrue(registerObj.successmessage.getText().contains("Your registration completed"));

		registerObj.LogOut();

		loginobj = new LoginPage(driver);
		loginobj.openLoginpage();
		loginobj.UserLogin(Email, Password);

		Assert.assertTrue(loginobj.LoginLink.isDisplayed());
	}

}
