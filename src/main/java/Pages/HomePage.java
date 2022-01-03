package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		actions = new Actions(driver);

	}

	@FindBy(linkText ="Register")
	WebElement registerlink;

	@FindBy(linkText = "Contact us")
	WebElement contactuslink;

	@FindBy(id = "customerCurrency")
	WebElement CurrencyDropDownList ;

	@FindBy(linkText = "Computers")
	WebElement computermenu;

	@FindBy(xpath ="/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement notebooksmenu;

	public void openregisterationpage ()
	{
		ClickButton(registerlink);

	}

	public void OpenConatctUsPage()
	{
		ScrollToButton();
		ClickButton(contactuslink);
	}

	public void ChangeCurrency()
	{
		select = new Select(CurrencyDropDownList);
		select.selectByVisibleText("Euro");
	}

	public void SelectNoteBooksMenu()
	{
		actions.moveToElement(computermenu)
		.moveToElement(notebooksmenu)
		.click()
		.build()
		.perform();
	}

}
