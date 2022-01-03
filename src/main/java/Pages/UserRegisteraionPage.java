package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisteraionPage extends PageBase {

	public UserRegisteraionPage(WebDriver driver) {
		super(driver);

	}


	@FindBy(id="gender-male")
	WebElement GenderRdbtn;

	@FindBy(id = "FirstName")
	WebElement FNameTxtBox;

	@FindBy(id="LastName")
	WebElement LNameTxtBox;

	@FindBy(name = "Email")
	WebElement emailTxtBox;

	@FindBy(id="Password")
	WebElement passwordTxtBox;

	@FindBy(id="ConfirmPassword")
	WebElement ConfimPasswordTxtBox;

	@FindBy(id="register-button")
	WebElement Registerbtn;

	@FindBy(css = "div.result")
	public WebElement successmessage;
	
	@FindBy(linkText = "Log out")
	WebElement Logoutbtn;
	
	@FindBy(linkText = "My account")
	public WebElement myaccountlink;
	
	
	public void UserRegisteration(String FirstName,String LastName ,String Email, String Password)
	{
		ClickButton(GenderRdbtn);
		SetText(FNameTxtBox, FirstName);
		SetText(LNameTxtBox, LastName);
		SetText(emailTxtBox, Email);
		SetText(passwordTxtBox, Password);
		SetText(ConfimPasswordTxtBox, Password);
		ClickButton(Registerbtn);
	}
	
	public void LogOut()
	{
		ClickButton(Logoutbtn);
	}
	
	
	public void openmyaccountpage()
	{
		ClickButton(myaccountlink);
	}



}
