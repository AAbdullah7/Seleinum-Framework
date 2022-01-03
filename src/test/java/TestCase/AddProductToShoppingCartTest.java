package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDeatilsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase
{

	String ProductName = "Apple MacBook Pro 13-inch";
	SearchPage searchobj;
	ShoppingCartPage shoppingobj;
	ProductDeatilsPage productdeailsobj;
	String Quantity = "5";




	@Test(priority = 1)
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

	@Test(priority = 2)
	public void UserCanAddProductToCart() throws InterruptedException
	{
		productdeailsobj = new ProductDeatilsPage(driver);
		productdeailsobj.AddToCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
	}

	@Test(priority = 3)
	public void UserCanRemoveProductFromCart()
	{
		shoppingobj = new ShoppingCartPage(driver);
		shoppingobj.UpdateProductQuantityInCart(Quantity);
		shoppingobj.RemoveProductFromCart();		
	}



}
