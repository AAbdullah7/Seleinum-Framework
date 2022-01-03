package TestCase;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Data.JsonDataReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegisteraionPage;
import io.ous.jtoml.ParseException;

@Test 
public class UserRegisterationTestWithDDTAndJson extends TestBase
{
	HomePage homeObj;
	UserRegisteraionPage registerObj;
	LoginPage loginobj;
	MyAccountPage myaccountobj;
	
	@Test(priority = 1)
	public void UserCanRegister() throws ParseException, IOException, org.json.simple.parser.ParseException
	{
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();
		homeObj = new HomePage(driver);
		homeObj.openregisterationpage();
		registerObj = new UserRegisteraionPage(driver);
		registerObj.UserRegisteration(jsonReader.FirstName, jsonReader.LastName, jsonReader.Email, jsonReader.Password);
		Assert.assertTrue(registerObj.successmessage.getText().contains("Your registration completed"));
		registerObj.LogOut();
		loginobj = new LoginPage(driver);
		loginobj.openLoginpage();
		loginobj.UserLogin(jsonReader.Email, jsonReader.Password);
		Assert.assertTrue(loginobj.LoginLink.isDisplayed());
		
	}

}
