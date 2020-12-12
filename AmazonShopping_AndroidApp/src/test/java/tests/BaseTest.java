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
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.Actions;
import utils.Constants;
import utils.ReportGeneration;

public class BaseTest extends Actions
{
	// Initializing Android driver,properties, and report utility object to generate reports
	
	public static AndroidDriver<AndroidElement>driver;
	public DesiredCapabilities cap;
	Properties prop;
	ReportGeneration report = new ReportGeneration();
	public static String deviceName;
	public static String  platformName;
	public static String appActivity;
	public static String appPackage;
	public static String url;
	
	/* Description: This method loads all capabilities from capability.properties file.
	 * Created By: Shreyas Devekar 
	 */
	
	public void capabilities()
	{
		prop = LoadProperties(Constants.capabilityPath);
		deviceName = prop.getProperty("deviceName");
		platformName = prop.getProperty("platformName");
		appActivity = prop.getProperty("appActivity");
		appPackage = prop.getProperty("appPackage");
		url = prop.getProperty("Url");
	}
	
	/* Description: This method initializes android driver with android device capabilities
	 * Created By: Shreyas Devekar 
	 */
	
	public void setUpDriver()
	{
		cap = new DesiredCapabilities();
		prop = LoadProperties(Constants.capabilityPath);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability("platformName", platformName);
		cap.setCapability("app", Constants.applicationFilePath);
		cap.setCapability("appActivity", appActivity );
		cap.setCapability("appPackage", appPackage);
		try 
		{
			driver=new AndroidDriver<AndroidElement>(new URL(prop.getProperty("Url")),cap);
		}
		catch (IOException e) 
		{	
			e.printStackTrace();
		}
	}
	
	/* Description: This method calls initializeReport to initialize the report.
	 * Created By: Shreyas Devekar 
	 */
	
	@BeforeTest
	public void beforeTestMethod()
	{
		report.initializeReports();
	}
	
	/* Description: This method calls createTestLogger to create test logs and starts driver with capabilities.
	 * Created By: Shreyas Devekar 
	 * Parameters : test method   
	 */
	
	@BeforeMethod
	public void setUp(Method testMethod)
	{
		report.createTestLogger(testMethod);
		setUpDriver();
	}
	
	/* Description: This method calls getTestResultReport to generate test execution result report.
	 * Created By: Shreyas Devekar 
	 * Parameters : test result   
	 */
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		report.getTestResultReport(result);
		driver.quit();
	}
	
	/* Description: This method calls writeTestLog method to write test log in reports.
	 * Created By: Shreyas Devekar 
	 */
	
	@AfterTest
	public void afterTestMethod()
	{
		report.writeTestLog();
	}
	

}
