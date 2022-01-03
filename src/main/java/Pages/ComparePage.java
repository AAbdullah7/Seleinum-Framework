package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase {


	public ComparePage(WebDriver driver) {
		super(driver);

	}


	@FindBy(css = "a.clear-list")
	WebElement clearlistBtn;

	@FindBy(css = "div.no-data")
	public WebElement nodataLbl;

	@FindBy(css = "table.compare-products-table")
	public WebElement comparetable;

	@FindBy(tagName = "tr")
	public List<WebElement>allrow;

	@FindBy(tagName = "td")
	public List<WebElement>allcol;

	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement FirstProductName;

	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement SecondProductName;


	public void ClearCompareTable()
	{
		ClickButton(clearlistBtn);
	}

	public void CompareProducts()
	{
		System.out.println(allrow.size());
		System.out.println(allcol.size());

		for(WebElement row : allrow)
		{
			System.out.println(row.getText()+"\t");
		}

		for(WebElement col : allcol)
		{
			System.out.println(col.getText()+"\t");	
		}
	}

}
