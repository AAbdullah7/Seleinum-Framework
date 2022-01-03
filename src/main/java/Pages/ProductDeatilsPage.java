package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDeatilsPage extends PageBase {

	public ProductDeatilsPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = "strong.current-item")
	public WebElement ProductNameBreadCrumb;
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement EmailFriendBtn;
	
	@FindBy(css = "span.price-value-4.price-value-4")
	public WebElement ProductPriceLabel;
	
	@FindBy(linkText = "Add your review")
	WebElement AddReviewLink;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addtowishlistBtn;
	
	@FindBy(linkText = "wishlist")
	WebElement wishlistLinkTxt;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement compareBtn;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement AddToCartBtn;
	
	public void OpenProductDetails()
	{
		ClickButton(ProductNameBreadCrumb);
	}
	
	public void OpenEmailFriendPage()
	{
		ClickButton(EmailFriendBtn);
	}
	
	public void OpenAddReviewPage()
	{
		ClickButton(AddReviewLink);
	}
	
	public void AddProductToWishListPage()
	{
		ClickButton(addtowishlistBtn);
	}
	
	public void OpenWishListPage()
	{
		ClickButton(wishlistLinkTxt);
	}
	
	public void AddProductToCompare()
	{
		ClickButton(compareBtn);
	}
	
	public void AddToCart()
	{
		ClickButton(AddToCartBtn);
	}
	
	
}


