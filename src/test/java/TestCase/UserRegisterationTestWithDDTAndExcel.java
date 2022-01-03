package TestCase;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Data.ExcelReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegisteraionPage;

public class UserRegisterationTestWithDDTAndExcel extends TestBase {

	HomePage homeObj;
	UserRegisteraionPage registerObj;
	LoginPage loginobj;
	MyAccountPage myaccountobj;


	@DataProvider(name = "ExcelData")
	public Object [][] UserRegisterData() throws NullPointerException, IOException
	{
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}

	@Test(priority = 1, dataProvider = "ExcelData")
	public void UserCanRegister(String FirstName,String LastName ,String Email,String Password)
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
	}

}
