package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = "button.remove-btn")
	WebElement RemoveBtn;

	@FindBy(css = "button.button-2.update-cart-button")
	WebElement UpdateBtn;

	@FindBy(css = "input.qty-input")
	WebElement QtyTxtBox;

	@FindBy(css="label.Total")
	public WebElement TotalLbl;
	
	@FindBy(id = "termsofservice")
	WebElement TermsCheckBox;
	
	@FindBy(id = "checkout")
	WebElement CheckoutBtn;
	
	public void RemoveProductFromCart()
	{
		ClickButton(RemoveBtn);
	}

	public void UpdateProductQuantityInCart(String Quantity)
	{
		ClearText(QtyTxtBox);
		SetText(QtyTxtBox, Quantity);
		ClickButton(UpdateBtn);
	}
	
	public void OpenCheckoutPage()
	{
		ClickButton(TermsCheckBox);
		ClickButton(CheckoutBtn);
	}

}
