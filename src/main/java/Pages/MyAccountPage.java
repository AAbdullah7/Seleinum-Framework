package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	
	}
	
	
	@FindBy(linkText = "Change password")
	WebElement changepasswordlink;
	
	@FindBy(id = "OldPassword")
	WebElement oldpasswordtxtbox;
	
	@FindBy(id = "NewPassword")
	WebElement newpasswordtxtbox;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmnewpasswordtxtbox;
	
	@FindBy(linkText = "Change password")
	WebElement changepasswordbtn;
	
	@FindBy(css = "div.content")
	public WebElement successchagepasswordmessage;
	
	public void openchangepasswordpage()
	{
		ClickButton(changepasswordlink);
	}
	
	
	public void ChangePassword(String oldpassword , String newpassword)
	{
		SetText(oldpasswordtxtbox, oldpassword);
		SetText(newpasswordtxtbox, newpassword);
		SetText(confirmnewpasswordtxtbox, newpassword);
		ClickButton(changepasswordbtn);
	}

}
