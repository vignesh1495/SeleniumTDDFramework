package Computed;

import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.ScreenCapturer;
import common.SeleniumWebDriver;
import executor.Executor;
import generated.GooglePageGenereted;

public class GooglePageComputed  extends GooglePageGenereted{
	
WebDriver driver;
public Logger logger = LogManager.getLogger(this.getClass());
	public GooglePageComputed(WebDriver driver) {
		 super(driver);
		this.driver=driver;
	}
	
	public boolean validateLoginFunction(String name) {
		if(driver!=null) {
			return homePage(name);
		
	}else {
		System.out.println("driver is not initialized");
	}
		return false;
	}
	
	public boolean homePage(String name) {
		boolean status=false;
		if(googlebutton().getAttribute("value").equalsIgnoreCase("Google Search")) {
		System.out.println("button name is valid");
		  new ScreenCapturer().takeScreenshots("button name is valid",   Executor.testcaseid);
		  logger.info( Executor.testcaseid+ " :button name is valid");
		  status=true;
		}else {
			 new ScreenCapturer().takeScreenshots("button name is not valid",   Executor.testcaseid);
			  logger.info( Executor.testcaseid+ " :button name is not valid");
			  status=false;
		}
		
		return status;
	}

	
}

