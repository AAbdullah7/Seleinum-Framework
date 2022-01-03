package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.ProductDeatilsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import Pages.UserRegisteraionPage;
import Pages.WishListPage;

public class UserCanCheckOutTest extends TestBase 
{

	HomePage homeObj;
	UserRegisteraionPage registerObj;
	SearchPage searchobj;
	ProductDeatilsPage productdeailsobj;
	WishListPage wishlistobj;
	CheckoutPage checkoutobj;
	ShoppingCartPage cartobj;
	String FirstName = "Abdelrahman";String LastName = "Abdullah"; 
	String Email = "a200@test.com" ; String Password="82645123";
	String ProductName = "Apple MacBook Pro 13-inch";
	String Country="Egypt";String City="Cairo";String Address="Haram";
	String Zip="1152"; String Phone="01140354538"; 

	/*@Test(priority = 1)
	public void UserCanRegister()
	{
		homeObj = new HomePage(driver);
		homeObj.openregisterationpage();
		registerObj = new UserRegisteraionPage(driver);
		registerObj.UserRegisteration(FirstName, LastName, Email, Password);
		Assert.assertTrue(registerObj.successmessage.getText().contains("Your registration completed"));
	}*/

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
	public void UserCanAddProductToCart() throws InterruptedException
	{
		productdeailsobj = new ProductDeatilsPage(driver);
		productdeailsobj.AddToCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
	}

	@Test(priority = 4)
	public void UserCanCheckOut()
	{
		checkoutobj = new CheckoutPage(driver);
		cartobj = new ShoppingCartPage(driver);
		cartobj.OpenCheckoutPage();
		checkoutobj.UserCanCheckOut(Country, City, Address, Zip, Phone);
		Assert.assertTrue(checkoutobj.ThankYouLbl.isDisplayed());
	}
	
	@Test(priority = 5)
	public void UserCanLogOut()
	{
		registerObj.LogOut();
	}

}
