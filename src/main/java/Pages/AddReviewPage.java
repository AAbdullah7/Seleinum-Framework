package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends PageBase 
{

	public AddReviewPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "AddProductReview_Title")
	WebElement addreviewtitletxt;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement addreviewtxt;
	
	@FindBy(id = "addproductrating_5")
	WebElement raingradioBtn;
	
	@FindBy(name = "add-review")
	WebElement addreviewBtn;
	
	@FindBy(css = "div.result")
	public WebElement reviewnotification;
	
	public void AddReview(String AddReviewTitle , String AddReviewText)
	{
		SetText(addreviewtitletxt, AddReviewTitle);
		SetText(addreviewtxt, AddReviewText);
		ClickButton(raingradioBtn);
		ClickButton(addreviewBtn);
	}
	

}
