package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;

public class HoverMenuTest extends TestBase 
{

	HomePage homeObj;

	@Test
	public void UserCanSelectSubCategoryFromMainMenu() throws InterruptedException 
	{
		homeObj = new HomePage(driver);
		homeObj.SelectNoteBooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
		Thread.sleep(500);
	}
}
