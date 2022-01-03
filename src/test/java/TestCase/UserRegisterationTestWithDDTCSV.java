package TestCase;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegisteraionPage;

@Test 
public class UserRegisterationTestWithDDTCSV extends TestBase {

	HomePage homeObj;
	UserRegisteraionPage registerObj;
	LoginPage loginobj;
	MyAccountPage myaccountobj;

	CSVReader reader;

	@Test(priority = 1)
	public void UserCanRegister() throws CsvValidationException, IOException
	{
		String CSV_file = System.getProperty("user.dir") + "/src/test/java/Data/UserData2.csv";
		reader = new CSVReader(new FileReader(CSV_file));

		String [] csvcell;

		while ((csvcell = reader.readNext()) != null)
		{
			String FirstName = csvcell[0];
			String LastName = csvcell[1];
			String Email = csvcell[2];
			String Password = csvcell[3];


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



}
