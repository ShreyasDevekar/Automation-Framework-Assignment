package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.BaseTest;

public class SuiteListener extends  Utility implements ITestListener 
{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	/* Description: This method takes screenshot if test result is pass. 
	 * Created By: Shreyas Devekar
	 * Parameters : result - test result
	 */

	public void onTestSuccess(ITestResult result) {
	
		//captureScreenShot(Constants.passTestSnipsPath+File.separator+result.getMethod().getMethodName());
		
	}
	
	/* Description: This method takes screenshot if test result is fail.
	 * Created By: Shreyas Devekar 
	 * Parameters : result - test result
	 */

	public void onTestFailure(ITestResult result) 
	{
		//captureScreenShot(Constants.failTestSnipsPath+File.separator+result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
