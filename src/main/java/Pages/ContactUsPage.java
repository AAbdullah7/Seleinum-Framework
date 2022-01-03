package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "FullName")
	WebElement FullnameTxt;
	
	@FindBy(id = "Email")
	WebElement EmailTxt;
	
	@FindBy(id = "Enquiry")
	WebElement EnquiryTxt;
	
	@FindBy(name = "send-email")
	WebElement SubmitBtn;
	
	
	
	public void ContactUs(String Fullname , String Email , String Enquiry)
	{
		SetText(FullnameTxt, Fullname);
		SetText(EmailTxt, Email);
		SetText(EnquiryTxt, Enquiry);
		ClickButton(SubmitBtn);
	}

}
