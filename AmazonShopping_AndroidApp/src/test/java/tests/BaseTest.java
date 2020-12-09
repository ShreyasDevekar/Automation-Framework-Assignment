package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.Constants;
import utils.ReportGeneration;
import utils.Utility;

public class BaseTest extends Utility
{
	// Initializing Android driver,properties, and report utility object to generate reports
	
	public static AndroidDriver<AndroidElement>driver;
	public DesiredCapabilities cap;
	Properties prop;
	ReportGeneration report = new ReportGeneration();
	
	// Description: This method initializes android driver with android device capabilities 
	
	public void setUpDriver()
	{
		cap = new DesiredCapabilities();
		prop = new Properties();
		prop = LoadProperties(Constants.capabilityPath);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
		cap.setCapability("platformName", prop.getProperty("platformName"));
		cap.setCapability("app", Constants.applicationFilePath);
		cap.setCapability("appActivity", prop.getProperty("appActivity"));
		cap.setCapability("appPackage", prop.getProperty("appPackage"));
		try 
		{
			driver=new AndroidDriver<AndroidElement>(new URL(prop.getProperty("Url")),cap);
		}
		catch (IOException e) 
		{	
			e.printStackTrace();
		}
	}
	
	// Description: This method calls initializeReport to initialize the report. 
	
	@BeforeTest
	public void beforeTestMethod()
	{
		report.initializeReports();
	}
	
	/* Description: This method calls createTestLogger to create test logs and starts driver with capabilities. 
	 * Parameters : test method   
	 */
	
	@BeforeMethod
	public void setUp(Method testMethod)
	{
		report.createTestLogger(testMethod);
		setUpDriver();
	}
	
	/* Description: This method calls getTestResultReport to generate test execution result report. 
	 * Parameters : test result   
	 */
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		report.getTestResultReport(result);
		driver.quit();
	}
	
	// Description: This method calls writeTestLog method to write test log in reports. 
	
	@AfterTest
	public void afterTestMethod()
	{
		report.writeTestLog();
	}
	

}
