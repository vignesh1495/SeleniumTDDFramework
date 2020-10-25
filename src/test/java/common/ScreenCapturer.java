package common;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.util.log.Log;

import executor.Executor;

public class ScreenCapturer {

	 Logger logger = LogManager.getLogger(this.getClass());  
	public void takeScreenshots(String screenShotdescription,String testcaseID) {
		
		String rootfolder= Executor.resultpath+"\\"+testcaseID;
		

        try { 
            Thread.sleep(120); 
            Robot r = new Robot(); 
  
            // It saves screenshot to desired path 
        //    String path = "D:// Shot.jpg"; 
  
            // Used to get ScreenSize and capture image 
            Rectangle capture =  
            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
            BufferedImage Image = r.createScreenCapture(capture); 
            ImageIO.write(Image, "jpg", new File(rootfolder+".jpg")); 
         
        } 
        catch (AWTException | IOException | InterruptedException ex) { 
            System.out.println(ex); 
        } 
    } 
		
		
	}
	
	