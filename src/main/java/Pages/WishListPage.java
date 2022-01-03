package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase {

	public WishListPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css = "a.product-name")
	public WebElement ProductCell;
	
	@FindBy(css = "h1")
	public WebElement WishListHeader;
	
	@FindBy(css = "button.button-2.update-wishlist-button")
	public WebElement removefromcart;
	
	@FindBy(name = "updatecart")
	public WebElement updatewishlist;
	
	@FindBy(css = "div.no-data")
	public WebElement EmptyCartLbl;
	
	
	public void RemoveProductFromWishList()
	{
		ClickButton(removefromcart);
		ClickButton(updatewishlist);
	}

}
