package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "small-searchterms")
	WebElement searchtxtbox ;

	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchbtn;

	@FindBy(id = "ui-id-2")
	List<WebElement> Productlist;

	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement Producttitle;

	public void Productsearch(String ProductName)
	{
		SetText(searchtxtbox, ProductName);
		ClickButton(searchbtn);
	}

	public void OpenProductTitle()
	{
		ClickButton(Producttitle);
	}

	public void ProductSearchUsingAutoSuggest(String searchTxt) throws InterruptedException
	{
		SetText(searchtxtbox, searchTxt);
		Thread.sleep(3000);
		Productlist.get(0).click();	
	}

}
