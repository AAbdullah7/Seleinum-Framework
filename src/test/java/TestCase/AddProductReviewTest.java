package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.AddReviewPage;
import Pages.HomePage;
import Pages.ProductDeatilsPage;
import Pages.SearchPage;
import Pages.UserRegisteraionPage;

public class AddProductReviewTest extends TestBase 
{
	String FirstName = "Abdelrahman";String LastName = "Abdullah"; 
	String Email = "a9071@test.com" ; String Password="82645123";
	String AddReviewTitle = "Apple MacBook Pro 13-inch"; String AddReviewText = "Is Very Good Product";
	String ProductName = "Apple MacBook Pro 13-inch";
	HomePage homeObj;
	UserRegisteraionPage registerObj;
	SearchPage searchobj;
	ProductDeatilsPage productdeailsobj;
	AddReviewPage addreviewobj;

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
		try {searchobj = new SearchPage(driver);
		searchobj.ProductSearchUsingAutoSuggest("MacB");
		productdeailsobj = new ProductDeatilsPage(driver);
		Assert.assertTrue(productdeailsobj.ProductNameBreadCrumb.getText().equalsIgnoreCase(ProductName));

		} catch (Exception e) {

			System.out.println("Error Occured " + e.getMessage());

		}

	}

	@Test(priority = 3)
	public void UserCanAddProductReview()
	{
		productdeailsobj = new ProductDeatilsPage(driver);
		addreviewobj = new AddReviewPage(driver);
		productdeailsobj.OpenAddReviewPage();
		addreviewobj.AddReview(AddReviewTitle, AddReviewText);
		Assert.assertTrue(addreviewobj.reviewnotification.getText().contains("Product review is successfully added"));
	}

}
