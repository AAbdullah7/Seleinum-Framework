package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ComparePage;
import Pages.HomePage;
import Pages.ProductDeatilsPage;
import Pages.SearchPage;

public class AddProductToCompareTest extends TestBase 
{

	String FirstProductName = "Apple MacBook Pro 13-inch ";
	String SecondProductName ="Asus N551JK-XO076H Laptop ";
	ProductDeatilsPage detailsobj;
	HomePage homeobj;
	ComparePage compareobj;
	SearchPage searchobj;

	@Test(priority = 1)
	public void UserCanCompareProducts() throws InterruptedException
	{
		searchobj = new SearchPage(driver);
		detailsobj = new ProductDeatilsPage(driver);
		compareobj = new ComparePage(driver);

		searchobj.ProductSearchUsingAutoSuggest("MacB");
		//Assert.assertTrue(detailsobj.ProductNameBreadCrumb.getText().contains(FirstProductName));
		detailsobj.AddProductToCompare();
		
		searchobj.ProductSearchUsingAutoSuggest("Asus");
		//Assert.assertTrue(detailsobj.ProductNameBreadCrumb.getText().contains(SecondProductName));
		detailsobj.AddProductToCompare();
		
		Thread.sleep(1000);
		
		driver.navigate().to("https://demo.nopcommerce.com" + "/compareproducts");
		
		Assert.assertTrue(compareobj.FirstProductName.getText().contains("Apple MacBook Pro 13-inch"));
		Assert.assertTrue(compareobj.SecondProductName.getText().contains("Asus N551JK-XO076H Laptop"));
		compareobj.CompareProducts();
	}

	@Test(priority = 2)
	public void UserCanClearCompare()
	{
		compareobj.ClearCompareTable();
	}


}
