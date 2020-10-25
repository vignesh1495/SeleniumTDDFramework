package funcationality;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Computed.GooglePageComputed;
import TestData.InputTestData;
import common.ScreenCapturer;
import common.SeleniumWebDriver;
import executor.Executor;

public class GoogleWebFunction    {

	 public Logger logger = LogManager.getLogger(this.getClass());


	GooglePageComputed googlepage;
	HashMap<String,HashMap<String,String>> WebFunctiontestdata;
	WebDriver driver;
	public GoogleWebFunction( ) {
		WebFunctiontestdata=new InputTestData().getTestData("WebFunction");
		
		driver=new SeleniumWebDriver().initializeWebDriver("https://www.google.com/");
		  new ScreenCapturer().takeScreenshots("Googlepage screenshot",   Executor.testcaseid);
		  logger.info( Executor.testcaseid+ " :googlepage is opened");
		googlepage=new GooglePageComputed(driver);
	}
	
	public boolean validateLoginFunction() {
		 
		boolean status=googlepage.validateLoginFunction(WebFunctiontestdata.get(Executor.testcaseid).get("name"));
		driver.quit();
		return status;
	}

}
