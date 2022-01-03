package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(linkText = "Log in")
	WebElement loginLink;

	@FindBy(id = "Email")
	WebElement emailtxtbox;

	@FindBy(id = "Password")
	WebElement Passwordtxtbox;

	@FindBy(linkText = "Log in")
	public WebElement LoginLink;
	
	
	public void openLoginpage ()
	{
		ClickButton(loginLink);
		
	}
	
	public void UserLogin(String Email,String Password)
	{
		SetText(emailtxtbox,Email);
		SetText(Passwordtxtbox,Password);
		ClickButton(LoginLink);
	}
	
	

}
