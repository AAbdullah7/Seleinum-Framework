package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.ProductDeatilsPage;
import Pages.SearchPage;

public class ChangeCurrencyTest extends TestBase 
{
	HomePage homeObj;
	ProductDeatilsPage productdeailsobj;
	String ProductName = "Apple MacBook Pro 13-inch";
	SearchPage searchobj;
	
	@Test(priority = 1)
	public void UserCanChangeCurrency()
	{
		homeObj = new HomePage(driver);
		homeObj.ChangeCurrency();	
	}
	
	@Test(priority = 2)
	public void UserCanSearchWithAutoSuggest()
	{
		try {searchobj = new SearchPage(driver);
		searchobj.ProductSearchUsingAutoSuggest("MacB");
		productdeailsobj = new ProductDeatilsPage(driver);
		Assert.assertTrue(productdeailsobj.ProductNameBreadCrumb.getText().equalsIgnoreCase(ProductName));
		Assert.assertTrue(productdeailsobj.ProductPriceLabel.getText().contains("€"));
		System.out.print(productdeailsobj.ProductPriceLabel.getText( ) );


		} catch (Exception e) {

			System.out.println("Error Occured " + e.getMessage());

		}

	}

}
