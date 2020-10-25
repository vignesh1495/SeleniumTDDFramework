package executor;

import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.WebDriver;

import TestData.InputTestData;
import common.InitializeLogs;
import common.ScreenCapturer;
import common.SeleniumWebDriver;
import funcationality.GoogleWebFunction;

public class Executor {

	//** logger file and the screenshot will be saved in this location"
	public static String resultpath="D:\\logs\\";
	 public Logger logger = LogManager.getLogger(this.getClass());  
	 public static String  testcaseid=null;
	 Executor(){
		 
		
		new InitializeLogs().initializeLogs();
		
			
			HashMap<String,HashMap<String,String>> testdata=new InputTestData().getTestData("Inputdata");
			System.out.println(testdata);
			
			  for (Entry<String, HashMap<String, String>> entry : testdata.entrySet())  
			  {
				   testcaseid=entry.getKey();
				 
				  if(testdata.get(testcaseid).get("Status").equalsIgnoreCase("scheduled"))
				  {
					  logger.info(testcaseid+" : is started to execute" );
					 if(new GoogleWebFunction().validateLoginFunction()) {

						  logger.info(testcaseid+" : is passed" );
					 }
					 else {
						 logger.info(testcaseid+" : is failed" );
					 }
			
				  }
				
				//  driver.close();
			  }
	 }
	 
	public static void main(String[] args) {
	
		new Executor();
	}

}
