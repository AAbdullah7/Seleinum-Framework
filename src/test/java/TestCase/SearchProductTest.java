package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDeatilsPage;
import Pages.SearchPage;

public class SearchProductTest extends TestBase 
{

	String ProductName = "Apple MacBook Pro 13-inch";
	SearchPage searchobj;
	ProductDeatilsPage productdeailsobj;
	@Test
	public void UserCanSearchForProducts()
	{
		searchobj = new SearchPage(driver);
		productdeailsobj = new ProductDeatilsPage(driver);
		searchobj.Productsearch(ProductName);
		searchobj.OpenProductTitle();
		Assert.assertTrue(productdeailsobj.ProductNameBreadCrumb.getText().equalsIgnoreCase(ProductName));
	}

}
