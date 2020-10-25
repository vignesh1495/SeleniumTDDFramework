package common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;


public class InitializeLogs {

	
	
	public void initializeLogs() {
		
		String logname="D:\\logs\\"+"log123"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
				.replace(",","")+"";
		System.setProperty("basePath", logname);
	org.apache.logging.log4j.core.LoggerContext  ctx=
			(org.apache.logging.log4j.core.LoggerContext)
			LogManager.getContext(false);
	ctx.reconfigure();
	}
}
