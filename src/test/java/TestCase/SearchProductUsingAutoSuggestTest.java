package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDeatilsPage;
import Pages.SearchPage;

public class SearchProductUsingAutoSuggestTest extends TestBase


{
	String ProductName = "Apple MacBook Pro 13-inch";
	SearchPage searchobj;
	ProductDeatilsPage productdeailsobj;

	@Test
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

}
