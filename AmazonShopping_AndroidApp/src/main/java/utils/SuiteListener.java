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

public class SuiteListener implements ITestListener 
{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	/* Description: This method takes screenshot if test result is pass. 
	 * Parameters : result - test result
	 */

	public void onTestSuccess(ITestResult result) {
	
		String filePath = System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"PassTestSnips"+File.separator+result.getMethod().getMethodName();
		File f = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(f,new File(filePath+".png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	/* Description: This method takes screenshot if test result is fail. 
	 * Parameters : result - test result
	 */

	public void onTestFailure(ITestResult result) 
	{
		String filePath = System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"FailedTestSnips"+File.separator+result.getMethod().getMethodName();
		File f = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(f,new File(filePath+".png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
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
