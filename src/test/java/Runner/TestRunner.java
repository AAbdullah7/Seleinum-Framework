package Runner;

import TestCase.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
features={"src/test/java/Features"}
,glue= {"Steps"}
,plugin= {"pretty","html:target/cucumber-reports"})

public class TestRunner extends TestBase 
{

}
