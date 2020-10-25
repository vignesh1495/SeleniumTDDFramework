package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumWebDriver {

public static WebDriver  driver ;

public SeleniumWebDriver() {
	
}

public WebDriver initializeWebDriver(String url) {
	
	try {
		// Replace the driver path
		
	if (driver==null) {
		String chromeDriverExecutable="G:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverExecutable);
		DesiredCapabilities desiredCapabilites = DesiredCapabilities.chrome();
		desiredCapabilites.setCapability("ignoreProtectedModeSettings", true);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		desiredCapabilites.setCapability(ChromeOptions.CAPABILITY, options);
		driver=new ChromeDriver(desiredCapabilites);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		}
	else {
		return driver;
	}
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return driver;
	

}

public WebDriver initializeWebDriver() {
	
	return driver;
}



	
	
}