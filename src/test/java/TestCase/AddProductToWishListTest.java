package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDeatilsPage;
import Pages.SearchPage;
import Pages.WishListPage;

public class AddProductToWishListTest extends TestBase 
{
	

	String ProductName = "Apple MacBook Pro 13-inch";
	SearchPage searchobj;
	ProductDeatilsPage productdeailsobj;
	WishListPage wishlistobj;
	

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
	public void UserCanAddProductForWishList()
	{
		productdeailsobj = new ProductDeatilsPage(driver);
		productdeailsobj.AddProductToWishListPage();
		productdeailsobj.OpenWishListPage();
		wishlistobj = new WishListPage(driver);
		Assert.assertTrue(wishlistobj.WishListHeader.isDisplayed());
		Assert.assertTrue(wishlistobj.ProductCell.getText().contains(ProductName));
	}
	
	
	@Test(priority = 3)
	public void UserCanRemoveProductFromCart()
	{
		wishlistobj = new WishListPage(driver);
		wishlistobj.RemoveProductFromWishList();
	    Assert.assertTrue(wishlistobj.EmptyCartLbl.getText().contains("The wishlist is empty!"));
	}
}