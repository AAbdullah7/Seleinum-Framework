package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase 
{

	public CheckoutPage(WebDriver driver)
	{
		super(driver);

	}


	@FindBy(id ="BillingNewAddress_CountryId")
	WebElement CountryList;

	@FindBy(id = "BillingNewAddress_City")
	WebElement CityTxt;


	@FindBy(id = "BillingNewAddress_Address1")
	WebElement AddressTxt;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement ZIPTxt;


	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement NumberTxt;

	@FindBy(name = "save")
	WebElement SaveBtn;

	@FindBy(css = "h1")
	public WebElement ThankYouLbl;
	
	public void UserCanCheckOut(String Country,String City, String Address, String Zip, String Phone )
	{
		select = new Select(CountryList);
		select.selectByVisibleText(Country);
		SetText(CityTxt, City);
		SetText(AddressTxt, Address);
		SetText(ZIPTxt, Zip);
		SetText(NumberTxt, Phone);
		for (int i = 0; i < 4; i++) 
		{
			ClickButton(SaveBtn);
		}

	}



}
