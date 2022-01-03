package Steps;

import org.testng.Assert;

import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.ProductDeatilsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import Pages.UserRegisteraionPage;
import Pages.WishListPage;
import TestCase.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class E2ETest extends TestBase {

	HomePage homeObj;
	UserRegisteraionPage registerObj;
	SearchPage searchobj;
	ProductDeatilsPage productdeailsobj;
	WishListPage wishlistobj;
	CheckoutPage checkoutobj;
	ShoppingCartPage cartobj;

	String FirstName = "Abdelrahman";
	String LastName = "Abdullah";
	String Email = "a508@test.com";
	String Password = "82645123";
	String ProductName = "Apple MacBook Pro 13-inch";
	String Country = "Egypt";
	String City = "Cairo";
	String Address = "Haram";
	String Zip = "1152";
	String Phone = "01140354538";

	@Given("User is in Home Page")
	public void user_is_in_home_page() {
		
		homeObj = new HomePage(driver);
		homeObj.openregisterationpage();
		registerObj = new UserRegisteraionPage(driver);
		registerObj.UserRegisteration(FirstName, LastName, Email, Password);
		Assert.assertTrue(registerObj.successmessage.getText().contains("Your registration completed"));
		//Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
	}

	@When("he search for {string}")
	public void he_search_for(String string) throws InterruptedException {
		searchobj = new SearchPage(driver);
		searchobj.ProductSearchUsingAutoSuggest("MacB");
		productdeailsobj = new ProductDeatilsPage(driver);
		Assert.assertTrue(productdeailsobj.ProductNameBreadCrumb.getText().equalsIgnoreCase(ProductName));
	}

	@When("Choose to buy")
	public void choose_to_buy() throws InterruptedException {
		productdeailsobj = new ProductDeatilsPage(driver);
		productdeailsobj.AddToCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
	}

	@Then("Move to checkout cart and enter personel details on checkout page and place the order")
	public void mote_to_checkout_cart_and_enter_personel_details_on_checkout_page_and_place_the_order() {
		checkoutobj = new CheckoutPage(driver);
		cartobj = new ShoppingCartPage(driver);
		cartobj.OpenCheckoutPage();
		checkoutobj.UserCanCheckOut(Country, City, Address, Zip, Phone);
		Assert.assertTrue(checkoutobj.ThankYouLbl.isDisplayed());
	}

}
