package utils;

import java.lang.reflect.Method;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ReportGeneration 
{
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	// Description: This method initializes the reports.
	
	public void initializeReports()
	{
		htmlReporter = new ExtentHtmlReporter(Constants.reportPath);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Shreyas Devekar");
	}
	
	/* Description: This method creates test logger for test method 
	 * Parameters : testMethod - test method 
	 */
	
	public void createTestLogger(Method testMethod)
	{
		logger = extent.createTest(testMethod.getName());
	}
	
	/* Description: This method generates reports based on test results. 
	 * Parameters : result - test result.
	 */
	
	public void getTestResultReport(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			String testName = result.getMethod().getMethodName();
			String logMessage = "Test Case: " + testName + " Passed";
			Markup m = MarkupHelper.createLabel(logMessage,ExtentColor.GREEN);
			logger.log(Status.PASS,m);
		}
		
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			String testName = result.getMethod().getMethodName();
			String logMessage = "Test Case: " + testName + " Failed";
			Markup m = MarkupHelper.createLabel(logMessage,ExtentColor.RED);
			logger.log(Status.FAIL,m);
		}
	}
	
	// Description: This method writes report and test logs.
	
	public void writeTestLog()
	{
		extent.flush();
	}
}
