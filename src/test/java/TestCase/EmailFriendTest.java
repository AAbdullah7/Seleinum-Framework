package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.EmailFriendPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDeatilsPage;
import Pages.SearchPage;
import Pages.UserRegisteraionPage;

public class EmailFriendTest extends TestBase 


{
	HomePage homeObj;
	LoginPage loginobj;
	UserRegisteraionPage registerObj;
	String ProductName = "Apple MacBook Pro 13-inch";
	SearchPage searchobj;
	ProductDeatilsPage productdeailsobj;
	EmailFriendPage emailobj;
	String FriendMail = "Test@gmail.com";String Message ="Hello";
	String FirstName = "Abdelrahman";String LastName = "Abdullah";
	String Email = "aa1@test.com" ; String Password="82645123";

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
	public void UserCanSearchWithAutoSuggest()
	{
		try {
			searchobj = new SearchPage(driver);
			searchobj.ProductSearchUsingAutoSuggest("MacB");
			productdeailsobj = new ProductDeatilsPage(driver);
			Assert.assertTrue(productdeailsobj.ProductNameBreadCrumb.getText().equalsIgnoreCase(ProductName));
		}

		catch (Exception e) 
		{
			System.out.println("Error Occured " + e.getMessage());
		}

	}

	@Test(priority = 3)
	public void UserCanMailFriend() throws InterruptedException
	{
		productdeailsobj = new ProductDeatilsPage(driver);
		productdeailsobj.OpenEmailFriendPage();
		emailobj = new EmailFriendPage(driver);
		emailobj.SendMailToYourFriend(FriendMail,Message);
		Thread.sleep(2500);
	}

	@Test(priority = 4)
	public void RegisterUserCanLogout()
	{
		registerObj.LogOut();
	}

	@Test(priority = 5)
	public void RegisterUserCanLogin()
	{
		loginobj = new LoginPage(driver);
		loginobj.openLoginpage();
		loginobj.UserLogin(Email, Password);
		Assert.assertTrue(loginobj.LoginLink.isDisplayed());
	}

}
