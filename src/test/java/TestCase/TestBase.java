package TestCase;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utility.Helper;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestBase extends AbstractTestNGCucumberTests
{

	public static WebDriver driver;


	@BeforeSuite
	@Parameters({"browser"})
	public void StartDriver(@Optional("chrome")String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver1.exe");
			driver= new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	@AfterSuite
	public void StopDriver()
	{
		driver.close();
	}

	@AfterMethod
	public void ScreenShoutOnFailure(ITestResult result)
	{
		if (result.getStatus()==ITestResult.FAILURE || result.getStatus()==ITestResult.SKIP) 
		{
			System.out.println("Faild!");
			System.out.println("Taking Screenshot");
			Helper.CaptureScreenShot(driver, result.getName());
		}
	}

}
