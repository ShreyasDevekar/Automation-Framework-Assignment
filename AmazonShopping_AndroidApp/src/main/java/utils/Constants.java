package utils;

import java.io.File;

public interface Constants 
{
	// file paths
	
	String capabilityPath = System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"propertyFiles"+File.separator+"capability.properties";
    String applicationFilePath = System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"applicationFile"+File.separator+"Amazon_shopping.apk";
    String reportPath = System.getProperty("user.dir")+File.separator+"Reports"+File.separator+"Automation_Report.html";
    String testDataFilePath = System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"testData"+File.separator+"Datasheet.xlsx";
    String sheetName = "Sheet1";
}
