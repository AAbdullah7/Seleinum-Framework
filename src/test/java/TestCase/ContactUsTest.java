package TestCase;

import org.testng.annotations.Test;

import Pages.ContactUsPage;
import Pages.HomePage;

public class ContactUsTest extends TestBase 
{
	HomePage homeObj;
	ContactUsPage contactusObj;
	String Fullname = "abdelrahman";
	String Email = "aa@gmail.com";
	String Enquiry = "Hello Test";
	
	@Test
	public void UserCanContactUS()
	{
		homeObj = new HomePage(driver);
		homeObj.OpenConatctUsPage();
		contactusObj = new ContactUsPage(driver);
		contactusObj.ContactUs(Fullname, Email, Enquiry);
	}

}
